package py.com.consultoresinformaticos.seminarios.dao;

import py.com.consultoresinformaticos.seminarios.model.Rol;
import javax.ejb.Remote;
/**
 *
 * @author enrique
 */
@Remote
public interface RolDao extends GenericDao<Rol, Integer>{
    public Rol getRolByName(String value);
}
