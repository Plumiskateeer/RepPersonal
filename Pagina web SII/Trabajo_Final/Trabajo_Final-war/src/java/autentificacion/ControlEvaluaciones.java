package autentificacion;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import modelo.Evaluacion;
import javax.persistence.EntityManager;
import modelo.Usuario;
import negocio.NegocioInter;


@Named(value = "controlEvaluaciones")
@SessionScoped
public class ControlEvaluaciones implements Serializable {

    private List<Evaluacion> evaluaciones;
    
    private List<Evaluacion> notas;
    
    private Evaluacion evaluacion;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    @Inject
    private ControlActividades ctrlact;
    
    @Inject
    private NegocioInter negocio;
    
    
    private EntityManager em;
    
    public ControlEvaluaciones() {
        evaluacion = new Evaluacion();
    }
    
    public NegocioInter getNegocio(){
        return negocio;
    }
    
    public Evaluacion getEvaluacion(){
        return evaluacion;
    }
    
    public List<Evaluacion> volcadoEvaluaciones(){
          evaluaciones = negocio.volcadoListaEvaluaciones();
          return evaluaciones;
    }
  
    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
    
    public int misNotas(){
        evaluaciones = negocio.listaNotas(ctrl.getUsuario());
        return evaluaciones.size();
    }
}
