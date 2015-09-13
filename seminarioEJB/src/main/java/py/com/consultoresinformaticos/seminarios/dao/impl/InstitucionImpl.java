package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.InstitucionDao;
import py.com.consultoresinformaticos.seminarios.model.Disertante;
import py.com.consultoresinformaticos.seminarios.model.Institucion;

/**
 *
 * @author enrique
 */
@Stateless
public class InstitucionImpl implements InstitucionDao {
    
    final static Logger logger = Logger.getLogger(InstitucionImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Institucion create(Institucion object) {
        try {
            em.remove(em.find(Disertante.class, object.getId()));
            em.flush();
            logger.info("Se inserta la institucion con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public Institucion getById(Integer id) {
        try {
            return em.find(Institucion.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Institucion update(Institucion object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se inserta la institucion con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(Institucion object) {
        try {
            int id = object.getId();
            em.remove(em.find(Institucion.class, id));
            em.flush();
            logger.info("Se elimina la institucion con id: "+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Institucion> getAll() {
        try {
            return em.createNamedQuery("Institucion.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public Institucion getByName(String institucion) {
        try {
            return (Institucion) em.createNamedQuery("Institucion.findByNombre").setParameter("nombre", institucion).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getByName ", e);
            return null;
        }
    }

}
