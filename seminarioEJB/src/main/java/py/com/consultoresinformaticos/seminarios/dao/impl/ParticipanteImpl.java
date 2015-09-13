package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteDao;
import py.com.consultoresinformaticos.seminarios.model.Participante;

/**
 *
 * @author enrique
 */
@Stateless
public class ParticipanteImpl implements ParticipanteDao {

    final static Logger logger = Logger.getLogger(ParticipanteImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Participante create(Participante object) {
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
    public Participante getById(Integer id) {
        try {
            return em.find(Participante.class, id);
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Participante update(Participante object) {
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
    public boolean delete(Participante object) {
        try {
            int id = object.getId();
            em.remove(em.find(Participante.class, id));
            em.flush();
            logger.info("Se elimina participante con Id: " + id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Participante> getAll() {
        try {
            return em.createNamedQuery("Participante.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return null;
        }
    }

}
