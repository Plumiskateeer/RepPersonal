package autentificacion;

import modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.lang.Character.isLetter;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {
    private Usuario usuario;
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        String pag = "login.xhtml";
        if (isLetter(usuario.getUsuario().charAt(8))){
            pag = "normal.xhtml";
        }
        if (isLetter(usuario.getUsuario().charAt(0))) { 
            pag = "organizacion.xhtml";
        }
        if(usuario.getUsuario().length() > 9){
            pag = "admin.xhtml";
        }
        return pag;
    }
    
    public int verRol() {
        if (isLetter(usuario.getUsuario().charAt(8))){
            return 0;
        }
        if (isLetter(usuario.getUsuario().charAt(0))) { 
            return 1;
        }
        if(usuario.getUsuario().length() > 9){
            return 2;
        }
        return 4;
    }
    
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
    public String perfil(){
        return "perfil.xhtml";
    }
    
    public String editarPerfil(){
        return "editarPerfil.xhtml";
    }
      
    public String verEvaluaciones(){
        return "verEvaluaciones.xhtml";
    }
    
    public String verActividades(){
        return "mostraractividades.xhtml";
    }
    
    public String Actividades(){
        return "actividades.xhtml";
    }
    
    public String verNotas(){
        return "verNotas.xhtml";
    }
    
    public String verNotasActividades(){
        return "verNotasActividades.xhtml";
    }
    
    public String crearActividad(){
        return "crearActividad.xhtml";
    }
    
    public String noticias(){
        return "noticias.xhtml";
    }
    
    public String crearNoticia(){
        return "crearNoticia.xhtml";
    }
    
    public String crearComentario(){
        return "crearComentario.xhtml";
    }
    
    public String editarUsuarios(){
        return "editarUsuarios.xhtml";
    }
    
    public String editarNoticia(){
        return "editarNoticia.xhtml";
    }
    
    public String verMisActividadesUsuario(){
        return "verMisActividadesUsuario.xhtml";
    }
    
    public String verMisActividadesOrganizacion(){
        return "verMisActividadesOrganizacion.xhtml";
    }
    
    public String crearEvaluacion(){
        return "crearEvaluacion.xhtml";
    }
    
    public String evaluarInscrito(){
        return "evaluarInscrito.xhtml";
    }
    
    public String comentarios(){
        return "comentarios.xhtml";
    }
    
    public String register(){
        return "register.xhtml";
    }
    
    public String forgot(){
        return "forgot.xhtml";
    }
    
    public String lostPassword(){
        return "lost-password.xhtml";
    }
    
    public String puntuarActividad(){
        return "puntuarActividad.xhtml";
    }
    
    public String editarActividades(){
        return "editarActividades.xhtml";
    }
    
    public String verInformesOrganizacion(){
        return "verInformesOrganizacion.xhtml";
    }
    
    public String crearInforme(){
        return "crearInforme.xhtml";
    }
    
    public String editarInforme(){
        return "editarInforme.xhtml";
    }
    
    public String verInformesUsuario(){
        return "verInformesUsuario.xhtml";
    }
    
    public String verInformes(){
        return "verInformes.xhtml";
    }
    
    public String inscritos(){
        return "inscritos.xhtml";
    }


    public ControlAutorizacion() {
    }
}
