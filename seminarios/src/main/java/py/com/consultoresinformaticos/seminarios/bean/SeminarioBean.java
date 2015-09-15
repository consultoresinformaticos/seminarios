package py.com.consultoresinformaticos.seminarios.bean;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.EventoDao;
import py.com.consultoresinformaticos.seminarios.dao.InstitucionDao;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteDao;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteEventoDao;
import py.com.consultoresinformaticos.seminarios.model.Evento;
import py.com.consultoresinformaticos.seminarios.model.Institucion;
import py.com.consultoresinformaticos.seminarios.model.Participante;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author enrique
 */
@ManagedBean(name = "seminarioBean")
@RequestScoped
public class SeminarioBean implements Serializable {

    @EJB
    private EventoDao eventoEjb;
    @EJB
    private ParticipanteDao participanteEjb;
    @EJB
    private InstitucionDao institucionEjb;
    private Participante participante;
    private List<Institucion> institucionList;
    private boolean inicio = true;
    private List<Evento> eventoList;
    private List<Evento> eventoSeleccionadosList;
    private ParticipantesHasEvento participanteEvento;
    private ParticipantesHasEventoPK participanteEventoPK;
    @EJB
    private ParticipanteEventoDao participanteEventoEjb;
    final static Logger logger = Logger.getLogger(SeminarioBean.class);

    /**
     * Creates a new instance of SeminarioBean
     */
    public SeminarioBean() {
    }

    @PostConstruct
    public void init() {
        participante = new Participante();
        participanteEventoPK = new ParticipantesHasEventoPK();
        participanteEvento = new ParticipantesHasEvento();
        institucionList = institucionEjb.getAll();
        institucionList = institucionEjb.getAll();
        eventoList = eventoEjb.getAll();
        eventoSeleccionadosList = new ArrayList<>();
        inicio = true;
    }

    public String guardarEvento() {
        try {
            participante = participanteEjb.create(participante);
            if (participante != null) {
                for (Evento evento : eventoSeleccionadosList) {
                    participanteEventoPK.setEventoId(evento.getId());
                    participanteEventoPK.setParticipantesId(participante.getId());
                    participanteEvento.setParticipante(participante);
                    participanteEvento.setParticipantesHasEventoPK(participanteEventoPK);
                    participanteEvento.setEvento(evento);
                    if (participanteEventoEjb.update(participanteEvento) != null) {
                        inicio = true;
                    }
                }
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha registrado exitosamente.", "PrimeFaces Rocks."));
                return "index";
            }

        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: guardarEvento ", e);
        }
        return null;
 
   }

    public void limpiar() {
        participante = new Participante();
        participanteEventoPK = new ParticipantesHasEventoPK();
        participanteEvento = new ParticipantesHasEvento();
        eventoSeleccionadosList = new ArrayList<>();
        inicio = true;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public List<Evento> getEventoSeleccionadosList() {
        return eventoSeleccionadosList;
    }

    public void setEventoSeleccionadosList(List<Evento> eventoSeleccionadosList) {
        this.eventoSeleccionadosList = eventoSeleccionadosList;
    }

    public ParticipantesHasEvento getParticipanteEvento() {
        return participanteEvento;
    }

    public void setParticipanteEvento(ParticipantesHasEvento participanteEvento) {
        this.participanteEvento = participanteEvento;
    }

}
