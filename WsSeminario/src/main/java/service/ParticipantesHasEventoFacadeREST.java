/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEvento;
import py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK;

/**
 *
 * @author cbustamante
 */
@Stateless
@Path("py.com.consultoresinformaticos.seminarios.model.participanteshasevento")
public class ParticipantesHasEventoFacadeREST extends AbstractFacade<ParticipantesHasEvento> {
    @PersistenceContext(unitName = "SeminarioPU")
    private EntityManager em;

    private ParticipantesHasEventoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;participantesId=participantesIdValue;eventoId=eventoIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK key = new py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> participantesId = map.get("participantesId");
        if (participantesId != null && !participantesId.isEmpty()) {
            key.setParticipantesId(new java.lang.Integer(participantesId.get(0)));
        }
        java.util.List<String> eventoId = map.get("eventoId");
        if (eventoId != null && !eventoId.isEmpty()) {
            key.setEventoId(new java.lang.Integer(eventoId.get(0)));
        }
        return key;
    }

    public ParticipantesHasEventoFacadeREST() {
        super(ParticipantesHasEvento.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(ParticipantesHasEvento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, ParticipantesHasEvento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public ParticipantesHasEvento find(@PathParam("id") PathSegment id) {
        py.com.consultoresinformaticos.seminarios.model.ParticipantesHasEventoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<ParticipantesHasEvento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<ParticipantesHasEvento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
