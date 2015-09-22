package py.com.consultoresinformaticos.seminarios.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.ejb.EJB;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.EventoDao;
import py.com.consultoresinformaticos.seminarios.dao.impl.DisertanteImpl;
import py.com.consultoresinformaticos.seminarios.model.Evento;

/**
 *
 * @author enrique
 */
@FacesConverter(value = "eventoConverter")
public class EventoConverter implements Converter {

    @EJB
    private EventoDao eventoEjb;
    final static Logger logger = Logger.getLogger(DisertanteImpl.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.equals("")) {
            return null;
        }

        try {
            Evento evento = eventoEjb.getByName(value);
            return evento;
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
        Evento evento = (Evento) value;
        try {
            return evento.getTitulo();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAsString ", e);
            return null;
        }
    }

}
