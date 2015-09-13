package py.com.consultoresinformaticos.seminarios.dao;

import java.util.List;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import javax.ejb.Remote;

/**
 *
 * @author enrique
 */
@Remote
public interface ParticipanteEventoDao extends GenericDao<ParticipantesHasEvento, Integer>{
    public List<ParticipantesHasEvento> searchParticipante(String nombre, String apllido, String email);
}
