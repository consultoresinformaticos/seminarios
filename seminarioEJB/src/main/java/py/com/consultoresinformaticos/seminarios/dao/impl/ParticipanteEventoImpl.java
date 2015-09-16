package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.ParticipanteEventoDao;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import javax.ejb.Stateless;
import javax.persistence.Query;
import py.com.consultoresinformaticos.seminarios.model.Evento;

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
    public List<ParticipantesHasEvento> searchParticipante(String nombre, String apellido, String email, Evento evento) {
        try {

            String query = "select pe from ParticipantesHasEvento pe \n"
                    + "    LEFT JOIN pe.participante p \n"
                    + "    LEFT JOIN pe.evento e \n";
            if (!nombre.trim().equalsIgnoreCase("") || !apellido.trim().equalsIgnoreCase("") || !email.trim().equalsIgnoreCase("") || (evento != null)){
                query += "where \n";

                if (!nombre.trim().equalsIgnoreCase("")) {
                    query += "  p.nombre like UPPER(:nombre)";
                }

                if (!apellido.trim().equalsIgnoreCase("") && !nombre.trim().equalsIgnoreCase("")) {
                    query += "    AND p.apellido like UPPER(:apellido)";
                } else if (!apellido.trim().equalsIgnoreCase("")) {
                    query += "  p.apellido like UPPER(:apellido)";
                }

                if ((!email.trim().equalsIgnoreCase("") && !apellido.trim().equalsIgnoreCase("")) || (!email.trim().equalsIgnoreCase("") && !nombre.equalsIgnoreCase(""))) {
                    query += "    AND p.email like UPPER(:email)";
                } else if(!email.trim().equalsIgnoreCase("")) {
                    query += "  p.email like UPPER(:email)";
                } 
                
                if ((email.trim().equalsIgnoreCase("") && apellido.trim().equalsIgnoreCase("") && nombre.trim().equalsIgnoreCase("")) && (evento.getId() != null)) {
                    query += " e.id = (:evento_id)";
                }        
                else if (evento.getId() != null) {
                    query += " AND e.id = (:evento_id)";
                } 
            }
            Query q = em.createQuery(query);
            if (!nombre.trim().equalsIgnoreCase("")) {
                q.setParameter("nombre", nombre);
            }
            if (!apellido.trim().equalsIgnoreCase("")) {
                q.setParameter("apellido", apellido);
            }
            if (!email.trim().equalsIgnoreCase("")) {
                q.setParameter("email", email);
            }
            if (evento.getId() != null) {
                q.setParameter("evento_id", evento.getId());
            } 
            
            return q.getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: searchParticipante ", e);
            return null;
        }
    }

}
