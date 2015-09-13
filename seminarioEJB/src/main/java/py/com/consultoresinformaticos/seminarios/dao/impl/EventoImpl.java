package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.EventoDao;
import static py.com.consultoresinformaticos.seminarios.dao.impl.DisertanteImpl.logger;
import py.com.consultoresinformaticos.seminarios.model.Evento;

/**
 *
 * @author enrique
 */
@Stateless
public class EventoImpl implements EventoDao {
    
    final static Logger logger = Logger.getLogger(EventoImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Evento create(Evento object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el evento con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public Evento getById(Integer id) {
        try {
            return em.find(Evento.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Evento update(Evento object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el evento con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(Evento object) {
        try {
            int id = object.getId();
            em.remove(em.find(Evento.class, id));
            em.flush();
            logger.info("Se elimina el evento con id: "+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Evento> getAll() {
        try {
            return em.createNamedQuery("Evento.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public Evento getByName(String evento) {
        try {
            return (Evento) em.createNamedQuery("Evento.findByTitulo").setParameter("titulo", evento).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getByName ", e);
            return null;
        }
    }

}
