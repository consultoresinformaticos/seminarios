/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.consultoresinformaticos.seminarios.dao.DisertanteDao;
import py.com.consultoresinformaticos.seminarios.model.Disertante;

/**
 *
 * @author enrique
 */
@Named(value = "disertanteBean")
@RequestScoped
public class DisertanteBean implements Serializable {

    @EJB
    private DisertanteDao disertanteEJB;
    private List<Disertante> disertanteList;
    private Disertante disertante;

    /**
     * Creates a new instance of DisertanteBean
     */
    public DisertanteBean() {
    }

    @PostConstruct
    public void init() {
        disertante = new Disertante();
        disertanteList = disertanteEJB.getAll();
    }

    public List<Disertante> getDisertanteList() {
        return disertanteList;
    }

    public void setDisertanteList(List<Disertante> disertanteList) {
        this.disertanteList = disertanteList;
    }

    public Disertante getDisertante() {
        return disertante;
    }

    public void setDisertante(Disertante disertante) {
        this.disertante = disertante;
    }

}
