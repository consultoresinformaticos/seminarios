package py.com.consultoresinformaticos.seminarios.bean;

import java.util.List;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.consultoresinformaticos.seminarios.dao.InstitucionDao;
import py.com.consultoresinformaticos.seminarios.model.Institucion;
import javax.ejb.EJB;

/**
 *
 * @author enrique
 */
@Named(value = "institucionBean")
@RequestScoped
public class InstitucionBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String descripcion;
    private List<Institucion> instituciones;
    private Institucion institucionSelected;
    private boolean bloquearBotones = true;
    @EJB
    private InstitucionDao institucionEJB;

    /**
     * Creates a new instance of InstitucionBean
     */
    public InstitucionBean() {
    }

    @PostConstruct
    private void init() {
        institucionSelected = new Institucion();
        instituciones = institucionEJB.getAll();
    }

    public void clean() {
        this.descripcion = null;
        this.institucionSelected = null;
        this.bloquearBotones = true;

    }

    public void addInstitucion() {
        FacesContext context = FacesContext.getCurrentInstance();
        for (Institucion inst : instituciones) {

            if (inst.getNombre().equals(descripcion)) {
                context.addMessage(null, new FacesMessage("Advertencia", "La institucion " + descripcion + " ya se encuentra registrada"));
                this.clean();
                return;
            }
        }

        Institucion institucion = new Institucion();
        institucion.setNombre(descripcion);
        institucionEJB.create(institucion);
        context.addMessage(null, new FacesMessage("Mensaje", "Institucion " + descripcion + " almacenada exitosamente"));

        instituciones = institucionEJB.getAll();

        this.clean();
    }

    public void deleteInstitucion() {
        institucionEJB.delete(this.getInstitucionSelected());
        instituciones = institucionEJB.getAll();
    }

    public void editInstitucion() {
        Institucion institucion = institucionEJB.getById(
                this.getInstitucionSelected().getId());
        FacesContext context = FacesContext.getCurrentInstance();
        institucion.setNombre(descripcion);
        institucionEJB.update(institucion);
        context.addMessage(null, new FacesMessage("Mensaje", "Institucion "
                + descripcion + " almacenada exitosamente"));

        instituciones = institucionEJB.getAll();

        this.clean();
    }

    public void onRowSelect(SelectEvent event) {
        this.institucionSelected = ((Institucion) event.getObject());
        this.descripcion = this.institucionSelected.getNombre();
        this.bloquearBotones = false;
        RequestContext.getCurrentInstance().update("institucion-form:dtInst");
    }

    public void guardarListener() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(List<Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    public Institucion getInstitucionSelected() {
        return institucionSelected;
    }

    public void setInstitucionSelected(Institucion institucionSelected) {
        this.institucionSelected = institucionSelected;
    }

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
    }

}
