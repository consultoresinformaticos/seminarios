package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteEventoDao;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author enrique
 */
@Stateless
public class ParticipanteEventoImpl implements ParticipanteEventoDao {

    final static Logger logger = Logger.getLogger(ParticipanteEventoImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public ParticipantesHasEvento create(ParticipantesHasEvento object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta ParticipanteHasEvento con eventoId: " + object);
            return object;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: create ", e);
            return null;
        }
    }

    @Override
    public ParticipantesHasEvento getById(Integer id) {
        try {
            return em.find(ParticipantesHasEvento.class, id);
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ParticipantesHasEvento update(ParticipantesHasEvento object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza ParticipanteHasEvento con eventoId: " + object);
            return object;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ParticipantesHasEvento object) {
        try {
            em.remove(em.find(ParticipantesHasEvento.class, object.getParticipantesHasEventoPK()));
            return true;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ParticipantesHasEvento> getAll() {
        try {
            return em.createNamedQuery("ParticipantesHasEvento.findAll").getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public List<ParticipantesHasEvento> searchParticipante(String nombre, String apllido, String email) {
        try {

            String query = "select pe from ParticipantesHasEvento pe \n"
                    + "    LEFT JOIN pe.participante p \n"
                    + "    LEFT JOIN pe.evento e \n";
            if (!nombre.trim().equalsIgnoreCase("") || !apllido.trim().equalsIgnoreCase("") || !email.trim().equalsIgnoreCase("")) {
                query += "where \n";

                if (!nombre.trim().equalsIgnoreCase("")) {
                    query += "  p.nombre like UPPER(':nombre')";
                }

                if (!apllido.trim().equalsIgnoreCase("") && !nombre.trim().equalsIgnoreCase("")) {
                    query += "    AND p.nombre like UPPER(':apellido')";
                } else {
                    query += "  p.nombre like UPPER(':apellido')";
                }

                if ((!email.trim().equalsIgnoreCase("") && !apllido.trim().equalsIgnoreCase("")) || (!email.trim().equalsIgnoreCase("") && !nombre.equalsIgnoreCase(""))) {
                    query += "    AND p.nombre like UPPER(':email')";
                } else {
                }
            }
            Query q = em.createQuery(query);
            if (!nombre.trim().equalsIgnoreCase("")) {
                q.setParameter("nombre", nombre);
            }
            if (!apllido.trim().equalsIgnoreCase("")) {
                q.setParameter("nombre", apllido);
            }
            if (!email.trim().equalsIgnoreCase("")) {
                q.setParameter("nombre", email);
            }
            return q.getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: searchParticipante ", e);
            return null;
        }
    }

}
