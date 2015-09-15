/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteDao;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import javax.ejb.EJB;
import py.com.consultoresinformaticos.seminarios.dao.EventoDao;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteEventoDao;
import py.com.consultoresinformaticos.seminarios.model.Evento;
import py.com.consultoresinformaticos.seminarios.model.Participante;

/**
 *
 * @author enrique
 */
@Named(value = "asistenciaBean")
@RequestScoped
public class AsistenciaBean implements Serializable {

    @EJB
    private ParticipanteDao participanteEJB;
    @EJB
    private ParticipanteEventoDao participanteEventoEJB;
    @EJB
    private EventoDao eventoEJB;
    private List<Evento> eventoList;
    private Participante participante;
    private ParticipantesHasEvento participanteEvento;
    private List<ParticipantesHasEvento> particpianteEventoList;
    private Evento evento;
    private boolean checked;

    /**
     * Creates a new instance of AsistenciaBean
     */
    public AsistenciaBean() {
    }

    @PostConstruct
    public void init() {
        participante = new Participante();
        particpianteEventoList = participanteEventoEJB.getAll();
        eventoList = eventoEJB.getAll();
        evento = new Evento();
    }

    public void buscar() {
        particpianteEventoList = participanteEventoEJB.searchParticipante(participante.getNombre(), participante.getApellido(), participante.getEmail(), evento);
    }
    
    public void checkAsistencia(ParticipantesHasEvento p){
        if (checked) {
            p.setAsistencia(1);
        }
        else {
            p.setAsistencia(0);
        }
        participanteEventoEJB.update(p);
    }

    public ParticipantesHasEvento getParaticipanteEvento() {
        return participanteEvento;
    }

    public void setParaticipanteEvento(ParticipantesHasEvento paraticipanteEvento) {
        this.participanteEvento = paraticipanteEvento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<ParticipantesHasEvento> getParticpianteEventoList() {
        return particpianteEventoList;
    }

    public void setParticpianteEventoList(List<ParticipantesHasEvento> particpianteEventoList) {
        this.particpianteEventoList = particpianteEventoList;
    }

    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
}
