package py.com.consultoresinformaticos.seminarios.dao;

import java.util.List;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Evento;

/**
 *
 * @author enrique
 */
@Remote
public interface ParticipanteEventoDao extends GenericDao<ParticipantesHasEvento, Integer>{
    public List<ParticipantesHasEvento> searchParticipante(String nombre, String apellido, String email, Evento evento);
}
