package autentificacion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import modelo.Actividad;
import modelo.Evaluacion;
import modelo.Inscripcion;
import modelo.Organizacion;
import modelo.Usuario;
import negocio.NegocioInter;

@Named(value = "controlActividades")
@SessionScoped
public class ControlActividades implements Serializable {

    private List<Actividad> actividades;
    private List<Actividad> actividadesorganizacion;
    private List<Actividad> actividadesusuario;
    private List<Evaluacion> evaluacionesactividades;
    private List<Inscripcion> inscripciones;
    private List<ArrayList<Inscripcion>> inscripcionesactividades;
    
    private Actividad actividad;
    private Evaluacion evaluacion;
    
    @Inject
    private ControlAutorizacion ctrl;
    @Inject
    private ControlEvaluaciones ctrlev;
    @Inject
    private NegocioInter negocio;
    
    
    public ControlActividades() {
        inscripciones = new ArrayList<>();
        evaluacion = new Evaluacion();
        actividad = new Actividad();
        inscripcionesactividades = new ArrayList<ArrayList<Inscripcion>>();
        actividad = new Actividad();
        actividadesorganizacion = new ArrayList<>();
        actividadesusuario = new ArrayList<>();
    }
    
    public Evaluacion getEvaluacion(){
        return evaluacion;
    }
    public NegocioInter getNegocio(){
        return negocio;
    }
    
    public Actividad getActividad(){
        return actividad;
    }
    
    public List<Actividad> volcadoActividades(){
          
          actividades = negocio.volcadoListaActividades();
          return actividades;
      }
    public List<Actividad> volcadoActividadesOrganizacion(Organizacion org){
          actividadesorganizacion = negocio.volcadoListaActividadesOrganizacion(org);
          return actividadesorganizacion;
      }
    public List<Actividad> volcadoActividadesUsuario(Usuario u){
          actividadesusuario = negocio.volcadoListaActividadesUsuario(u);
          return actividadesusuario;
      }
    public List<Evaluacion> volcadoEvaluacionesActividades(){
          
          evaluacionesactividades = negocio.volcadoListaEvaluacionesActividades(actividades);
          return evaluacionesactividades;
      }
    
   public List<Inscripcion> volcadoInscripcionesActividad(Actividad a){
        inscripciones = negocio.volcadoListaInscripcionesActividad(a);
        return inscripciones;
    }
    
    public void guardarInscripcionesActividad(Actividad a, List<Inscripcion> i){
        int indiceAct = (int)(long)a.getId();
        inscripcionesactividades.get(indiceAct).addAll(i);
    }
    public List<Actividad> getActividades() {
        return actividades;
    }
    public void puntuarActividad(){
        
       negocio.insertarEvaluacion(evaluacion);
        
    }
    
     public Actividad buscarActividad(String titulo){
        List<Actividad> actividadesbbdd = volcadoActividades();
        Actividad aux = new Actividad();
        
        for(Actividad a : actividadesbbdd){
            if(a.getTitulo().equals(titulo)){
                aux = a;
            }
        }
        return aux;
    }
    
}