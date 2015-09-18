package py.com.consultoresinformaticos.seminarios.converters;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import static py.com.consultoresinformaticos.seminarios.converters.EventoConverter.logger;
import py.com.consultoresinformaticos.seminarios.dao.UsuarioDao;
import py.com.consultoresinformaticos.seminarios.model.Usuario;

/**
 *
 * @author karumbe
 */
@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter  {
    
    @EJB
    private UsuarioDao usuarioEjb;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value == null || value.equals("") )
            return null;
        
        try {
            Usuario usuario = usuarioEjb.getByUserName(value);
            return usuario;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAsObject ", e);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Usuario usuario = (Usuario) value;
        try {
            return usuario.getUsername();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAsString ", e);
            return null;
        }
    }
    
}
