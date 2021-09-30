package autentificacion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import modelo.Actividad;
import modelo.Inscripcion;
import negocio.NegocioInter;


@Named(value = "controlInscritos")
@SessionScoped
public class ControlInscritos implements Serializable {

    private List<Inscripcion> inscritos;
    private String titulo;
    private List<String> lista;
    private Inscripcion inscripcion;
    
    @Inject
    private ControlAutorizacion ctrl;
    @Inject
    private ControlActividades actividades;
    @Inject
    private NegocioInter bbdd;

    
    public ControlInscritos() {
        inscritos = new ArrayList<>();
        lista = new ArrayList<>();
        inscripcion = new Inscripcion();
    }

    public List<Inscripcion> getInscritos() {
        return inscritos;
    }
    
    public int busca(){
        String str;
        int contador = 0;
        Iterator<Inscripcion> it = inscritos.iterator();
        while(it.hasNext()){
            Inscripcion y = it.next();
            if(titulo.equals(y.getActividad().getTitulo())){
                str = " Usuario  "+ y.getUsuario().getDni()+"  con email:  "+y.getUsuario().getEmail();
                lista.add(str);
                contador++;
            }
        }
        return contador;
    }
    
    public List<String> getLista(){
        return lista;
    }

    
    public List<Inscripcion> setInscritos(List<Inscripcion> inscritos){
        return this.inscritos = inscritos;
    }
    
    public String setTituloAct(String t){
        titulo=t;
         return "listaInscritos.xhtml";
    }
    
    public String inscritos(){
         return "inscritos.xhtml";
    }
    
    public void inscribirseActividad(String tituloAct){
          
          Actividad a = actividades.buscarActividad(tituloAct);
          
          
          inscripcion.setUsuario(ctrl.getUsuario()); 
          inscripcion.setidACTIVIDAD(a.getId());
          actividades.volcadoInscripcionesActividad(a).add(inscripcion);
          bbdd.insertarInscripcion(inscripcion);
          
          
      }
}
