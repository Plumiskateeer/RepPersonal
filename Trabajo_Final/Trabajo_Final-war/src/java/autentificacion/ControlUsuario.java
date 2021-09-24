package autentificacion;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import modelo.Usuario;
import javax.inject.Named;
import javax.inject.Inject;
import negocio.NegocioInter;


@Named(value = "login")
@RequestScoped
public class ControlUsuario implements Serializable {
    private Usuario usuario;
    
    @Inject
    private NegocioInter bbdd;
    
    @Inject
    private ControlAutorizacion ctrl;

    public ControlUsuario() {
        usuario = new Usuario(null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    public String autenticar() {
        Usuario u = bbdd.compruebaLogin(usuario);
        if(u == null){
            return "login.xhtml";
        }
        ctrl.setUsuario(u);
        return ctrl.home();
    }
    
    public void modificarUsuario(){
        bbdd.modificarUser(ctrl.getUsuario());
    }
    
    public void buscarUsuario(){
        usuario = bbdd.refrescarUser(usuario);
    }
    
    public void editarUsuario(){
        bbdd.modificarUser(usuario);
    }
    
    public void borrarUsuario(){
        bbdd.eliminarUser(usuario);
    }

    @Override
    public String toString() {
        return "[Usuario = "+ usuario + "]";
    }
}