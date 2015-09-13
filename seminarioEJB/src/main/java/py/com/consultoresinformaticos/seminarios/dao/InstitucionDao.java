package py.com.consultoresinformaticos.seminarios.dao;

import javax.ejb.Remote;
import py.com.consultoresinformaticos.seminarios.model.Institucion;

/**
 *
 * @author enrique
 */
@Remote
public interface InstitucionDao extends GenericDao<Institucion, Integer>{
    public Institucion getByName(String institucion);
}
