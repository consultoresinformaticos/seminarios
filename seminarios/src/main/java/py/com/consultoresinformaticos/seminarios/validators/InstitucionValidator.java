package py.com.consultoresinformaticos.seminarios.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author enrique
 */
@FacesValidator("institucionValidator")
public class InstitucionValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (null == value) {
            FacesMessage msg = new FacesMessage("Por favor seleccione una institucion", "Por favor seleccione una institucion");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
