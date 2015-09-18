/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.consultoresinformaticos.seminarios.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import py.com.consultoresinformaticos.seminarios.dao.RolDao;
import py.com.consultoresinformaticos.seminarios.dao.UsuarioDao;
import py.com.consultoresinformaticos.seminarios.model.Rol;
import py.com.consultoresinformaticos.seminarios.model.Usuario;

/**
 *
 * @author root
 */
@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> listUsuario;
    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private RolDao rolDao;
    private List<Rol> listRol;
    private Usuario usuarioSeleccionado;
    private boolean bloquearBotones;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        listRol = rolDao.getAll();
        listUsuario = usuarioDao.getAll();

    }

    public void guardar() {
        usuario = usuarioDao.create(usuario);
    }
    
    public void eliminar(){
        
    }
    
    public void onRowSelect(){
        bloquearBotones = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<Rol> getListRol() {
        return listRol;
    }

    public void setListRol(List<Rol> listRol) {
        this.listRol = listRol;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
    }
    
}
