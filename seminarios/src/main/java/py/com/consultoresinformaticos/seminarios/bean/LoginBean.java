package py.com.consultoresinformaticos.seminarios.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import py.com.consultoresinformaticos.seminarios.model.Rol;
import py.com.consultoresinformaticos.seminarios.model.Usuario;
import javax.ejb.EJB;
import py.com.consultoresinformaticos.seminarios.dao.PantallaDao;
import py.com.consultoresinformaticos.seminarios.dao.RolDao;
import py.com.consultoresinformaticos.seminarios.dao.UsuarioDao;
import py.com.consultoresinformaticos.seminarios.model.Pantalla;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private boolean loggedIn;
    private Usuario usuario;
    private Rol rol;
    @EJB
    private UsuarioDao usuarioEjb;
    @EJB
    private RolDao rolDaoEJB;
    @EJB
    private PantallaDao pantallaEJB;
    
    private static final Logger logger = Logger.getLogger(LoginBean.class);

    /**
     * Método para cerrar Sesión
     *
     * @return
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        logger.info("Cerró la sessión");
        loggedIn = false;
        return "index";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Método para iniciar sessión
     *
     * @return
     * @throws java.io.IOException
     */
    public String login() throws IOException {
        usuario = usuarioEjb.autenticate(username, password);
        loggedIn = usuario != null;

        if (loggedIn) {
            logger.info("Se inició sesión como " + username);
            rol = rolDaoEJB.getRolByName(usuario.getRol().getDescripcion());
            FacesContext.getCurrentInstance().getExternalContext().redirect("secure/home.xhtml");
            return "home";
        } else {
            loggedIn = false;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de acceso", "El usuario y la contraseña no coinciden");
            FacesContext.getCurrentInstance().addMessage(null, message);
            logger.info("Se intentó ingresar como " + username);
            logger.error("Se intentó ingresar como " + username);
            username = null;
            password = null;
            RequestContext.getCurrentInstance().update("loginPage");
            RequestContext.getCurrentInstance().update("mensajes");
            return "login";
        }
    }

    /**
     * Método que redirecciona al home de la aplicación en caso de que el
     * usuario este correctamente autenticado, de lo contrario la regla de
     * acceso aplicada a travez de loginFilter hace que se redireccione al
     * login.jsf
     *
     * @throws IOException
     */
    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("secure/home.xhtml");
    }


    public boolean getPermisoPantalla(String roles) {
        if (null != roles && !roles.equalsIgnoreCase("")) {
            if (null != rol) {
                String pantallaView[] = roles.split(",");
                List<Pantalla> pantallas = rol.getPantallaList();
                if (pantallas != null) {
                    for (String ps : pantallaView) {
                        for (Pantalla p : pantallas) {
                            if (p.getPantalla().trim().equals(ps.trim())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //Getters && Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
