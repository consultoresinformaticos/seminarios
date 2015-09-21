/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author cbustamante
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.DisertanteFacadeREST.class);
        resources.add(service.EventoFacadeREST.class);
        resources.add(service.InstitucionFacadeREST.class);
        resources.add(service.PantallaFacadeREST.class);
        resources.add(service.ParticipanteFacadeREST.class);
        resources.add(service.ParticipantesHasEventoFacadeREST.class);
        resources.add(service.RolFacadeREST.class);
        resources.add(service.SeminarioFacadeREST.class);
        resources.add(service.UsuarioFacadeREST.class);
    }
    
}
