package autentificacion;

import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import modelo.Noticia;
import negocio.NegocioInter;

@Named(value = "controlNoticias")
@SessionScoped
public class ControlNoticias implements Serializable {
    private Noticia noticia;
    private List<Noticia> noticias;
    
    @Inject
    private NegocioInter bbdd;
    
    public ControlNoticias() {
        noticias = new ArrayList<>();
        noticia = new Noticia();
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public NegocioInter getBbdd() {
        return bbdd;
    }

    public void setBbdd(NegocioInter bbdd) {
        this.bbdd = bbdd;
    }
    
    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
    
    public int listaNoticias(){
        noticias = bbdd.mostrarNoticias();
        return noticias.size();
    }
    
    public void crearNoticia(){
        bbdd.insertarNoticia(noticia);
    }
     
    public void modificarNoticia(){
        bbdd.modificarNoticia(noticia);
    }
    
    public void borrarNoticia(){
        bbdd.borrarNoticia(noticia);
    }
    
    public void buscarNoticia(){
        noticia = bbdd.refrescarNoticia(noticia);
    }
}
