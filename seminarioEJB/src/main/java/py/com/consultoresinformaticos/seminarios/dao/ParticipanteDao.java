package py.com.consultoresinformaticos.seminarios.dao;

import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Participante;

/**
 *
 * @author enrique
 */
@Remote
public interface ParticipanteDao extends GenericDao<Participante, Integer>{
    
}
