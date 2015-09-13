/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.consultoresinformaticos.seminarios.dao.DisertanteDao;
import py.com.consultoresinformaticos.seminarios.model.Disertante;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 */
@Stateless
public class DisertanteImpl implements DisertanteDao {
    final static Logger logger = Logger.getLogger(DisertanteImpl.class);

    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    @Override
    public Disertante create(Disertante object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el disertante con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public Disertante getById(Integer id) {
        try {
            return em.find(Disertante.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Disertante update(Disertante object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el disertante con id: "+object.getId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(Disertante object) {
        try {
            int id = object.getId();
            em.remove(em.find(Disertante.class, id));
            em.flush();
            logger.info("Se elimina el disertante con id: "+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<Disertante> getAll() {
        try {
            return em.createQuery("select d from Disertante d").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

}
