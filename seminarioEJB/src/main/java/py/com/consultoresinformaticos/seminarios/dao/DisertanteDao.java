/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.dao;

import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Disertante;

/**
 *
 * @author enrique
 */
@Remote
public interface DisertanteDao extends GenericDao<Disertante, Integer> {
    
}
