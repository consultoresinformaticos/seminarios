package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.Iterator;
import py.com.consultoresinformaticos.seminarios.dao.UsuarioDao;
import py.com.consultoresinformaticos.seminarios.model.Usuario;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 */
@Stateless
public class UsuarioImpl implements UsuarioDao {

    final static Logger logger = Logger.getLogger(UsuarioImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Usuario create(Usuario object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el participante con id: " + object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: create ", e);
            return null;
        }
    }

    @Override
    public Usuario getById(Integer id) {
        try {
            return em.find(Usuario.class, id);
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Usuario update(Usuario object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza participante con Id: " + object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(Usuario object) {
        try {
            int id = object.getId();
            em.remove(em.find(Usuario.class, id));
            em.flush();
            logger.info("Se elimina participante con Id: " + id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Usuario> getAll() {
        try {
            return em.createNamedQuery("Usuario.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return null;
        }
    }

    @Override
	public Usuario autenticate(String username, String password) {
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) this.getAll();
		
		@SuppressWarnings("rawtypes")
		Iterator it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario us = (Usuario) it.next();
			if(us.getPassword().equals(password) && us.getUsername().equals(username)){
				return us;
			}
		}
		return null;
	}

}
