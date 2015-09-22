/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author enrique
 */
@Embeddable
public class ParticipantesHasEventoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "participantes_id", nullable = false)
    private int participantesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evento_id", nullable = false)
    private int eventoId;

    public ParticipantesHasEventoPK() {
    }

    public ParticipantesHasEventoPK(int participantesId, int eventoId) {
        this.participantesId = participantesId;
        this.eventoId = eventoId;
    }

    public int getParticipantesId() {
        return participantesId;
    }

    public void setParticipantesId(int participantesId) {
        this.participantesId = participantesId;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) participantesId;
        hash += (int) eventoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantesHasEventoPK)) {
            return false;
        }
        ParticipantesHasEventoPK other = (ParticipantesHasEventoPK) object;
        if (this.participantesId != other.participantesId) {
            return false;
        }
        if (this.eventoId != other.eventoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK[ participantesId=" + participantesId + ", eventoId=" + eventoId + " ]";
    }
    
}
