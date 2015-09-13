package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.PantallaDao;
import py.com.consultoresinformaticos.seminarios.model.Disertante;
import py.com.consultoresinformaticos.seminarios.model.Pantalla;

/**
 *
 * @author enrique
 */
@Stateless
public class PantallaImpl implements PantallaDao{

    final static Logger logger = Logger.getLogger(PantallaImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Pantalla create(Pantalla object) {
        try {
            em.remove(em.find(Disertante.class, object.getId()));
            em.flush();
            logger.info("Se inserta la pantalla con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public Pantalla getById(Integer id) {
        try {
            return em.find(Pantalla.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Pantalla update(Pantalla object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se inserta la pantalla con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(Pantalla object) {
        try {
            int id = object.getId();
            em.remove(em.find(Pantalla.class, id));
            em.flush();
            logger.info("Se elimina la pantalla con id: "+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Pantalla> getAll() {
        try {
            return em.createNamedQuery("Pantalla.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
