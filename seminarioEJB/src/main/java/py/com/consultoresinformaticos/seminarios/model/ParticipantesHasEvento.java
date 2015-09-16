/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enrique
 */
@Entity
@Table(name = "participantes_has_evento", catalog = "talleres", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipantesHasEvento.findAll", query = "SELECT p FROM ParticipantesHasEvento p"),
    @NamedQuery(name = "ParticipantesHasEvento.findByParticipantesId", query = "SELECT p FROM ParticipantesHasEvento p WHERE p.participantesHasEventoPK.participantesId = :participantesId"),
    @NamedQuery(name = "ParticipantesHasEvento.findByEventoId", query = "SELECT p FROM ParticipantesHasEvento p WHERE p.participantesHasEventoPK.eventoId = :eventoId"),
    @NamedQuery(name = "ParticipantesHasEvento.findByAsistencia", query = "SELECT p FROM ParticipantesHasEvento p WHERE p.asistencia = :asistencia")})
public class ParticipantesHasEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipantesHasEventoPK participantesHasEventoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia", nullable = false)
    private int asistencia;
    @JoinColumn(name = "participantes_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Participante participante;
    @JoinColumn(name = "evento_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento;

    public ParticipantesHasEvento() {
    }

    public ParticipantesHasEvento(ParticipantesHasEventoPK participantesHasEventoPK) {
        this.participantesHasEventoPK = participantesHasEventoPK;
    }

    public ParticipantesHasEvento(ParticipantesHasEventoPK participantesHasEventoPK, int asistencia) {
        this.participantesHasEventoPK = participantesHasEventoPK;
        this.asistencia = asistencia;
    }

    public ParticipantesHasEvento(int participantesId, int eventoId) {
        this.participantesHasEventoPK = new ParticipantesHasEventoPK(participantesId, eventoId);
    }

    public ParticipantesHasEventoPK getParticipantesHasEventoPK() {
        return participantesHasEventoPK;
    }

    public void setParticipantesHasEventoPK(ParticipantesHasEventoPK participantesHasEventoPK) {
        this.participantesHasEventoPK = participantesHasEventoPK;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
    
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantesHasEventoPK != null ? participantesHasEventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantesHasEvento)) {
            return false;
        }
        ParticipantesHasEvento other = (ParticipantesHasEvento) object;
        if ((this.participantesHasEventoPK == null && other.participantesHasEventoPK != null) || (this.participantesHasEventoPK != null && !this.participantesHasEventoPK.equals(other.participantesHasEventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento[ participantesHasEventoPK=" + participantesHasEventoPK + " ]";
    }
    
}
