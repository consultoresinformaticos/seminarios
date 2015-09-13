package py.com.consultoresinformaticos.seminarios.dao;

import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Pantalla;
/**
 *
 * @author enrique
 */

@Remote
public interface PantallaDao extends GenericDao<Pantalla, Integer>{
    
}
