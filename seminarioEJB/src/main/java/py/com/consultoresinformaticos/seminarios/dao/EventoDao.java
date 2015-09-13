package py.com.consultoresinformaticos.seminarios.dao;

import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Evento;

/**
 *
 * @author enrique
 */
@Remote
public interface EventoDao extends GenericDao<Evento, Integer> {
    public Evento getByName(String evento);
}
