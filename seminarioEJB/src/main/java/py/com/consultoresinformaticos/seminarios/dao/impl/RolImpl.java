package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.RolDao;
import py.com.consultoresinformaticos.seminarios.model.Rol;

/**
 *
 * @author enrique
 */
@Stateless
public class RolImpl implements RolDao {

    final static Logger logger = Logger.getLogger(RolImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Rol create(Rol object) {
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
    public Rol getById(Integer id) {
        try {
            return em.find(Rol.class, id);
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Rol update(Rol object) {
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
    public boolean delete(Rol object) {
        try {
            int id = object.getId();
            em.remove(em.find(Rol.class, id));
            em.flush();
            logger.info("Se elimina participante con Id: " + id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Rol> getAll() {
        try {
            return em.createNamedQuery("Rol.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return null;
        }
    }
    
    @Override
    public Rol getRolByName(String value) {
        try {
            Query q = em.createNamedQuery("Rol.findByDescripcion");
            q.setParameter("descripcion", value);
            return (Rol) q.getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getRolByName ", e);
            return null;
        }
    }
}
