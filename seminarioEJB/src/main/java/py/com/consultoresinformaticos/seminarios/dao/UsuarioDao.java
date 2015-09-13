package py.com.consultoresinformaticos.seminarios.dao;

import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Usuario;
/**
 *
 * @author enrique
 */
@Remote
public interface UsuarioDao extends GenericDao<Usuario, Integer>{
    public Usuario autenticate(String username, String password);
}
