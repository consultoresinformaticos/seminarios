package py.com.consultoresinformaticos.seminarios.converters;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import py.com.consultoresinformaticos.seminarios.dao.InstitucionDao;
import py.com.consultoresinformaticos.seminarios.model.Institucion;
import javax.ejb.EJB;
import org.apache.log4j.Logger;
import py.com.consultoresinformaticos.seminarios.dao.impl.DisertanteImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enrique
 */
@FacesConverter(value = "institucionConverter")
public class InstitucionConverter implements Converter {

    @EJB
    private InstitucionDao institucionEjb;
    final static Logger logger = Logger.getLogger(InstitucionConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.equals("")) {
            return null;
        }

        try {
            Institucion intstitucion = institucionEjb.getByName(value);
            return intstitucion;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
        }

        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Institucion institucion = (Institucion) value;
        try {
            return institucion.getNombre();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

}
