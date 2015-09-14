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
    private ParticipantesHasEvento paraticipanteEvento;
    private List<ParticipantesHasEvento> particpianteEventoList;
    private Evento evento;
    

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

    public ParticipantesHasEvento getParaticipanteEvento() {
        return paraticipanteEvento;
    }

    public void setParaticipanteEvento(ParticipantesHasEvento paraticipanteEvento) {
        this.paraticipanteEvento = paraticipanteEvento;
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
    
}
