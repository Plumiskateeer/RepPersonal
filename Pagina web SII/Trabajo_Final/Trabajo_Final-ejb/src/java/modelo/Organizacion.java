package modelo;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("o")
public class Organizacion extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column (length = 9, nullable = true)
    private String cif;
    
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "organizacion")
    private List<Informe> informe;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "organizacion")
    private List<Actividad> actividad;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "organizacion")
    private List<Evaluacion> evaluacion;

    public Organizacion() {
    }

    public Organizacion(String cif, List<Informe> informe, List<Actividad> actividad, List<Evaluacion> evaluacion, String usuario, String nombre, String dni, String contraseña, String email, Date fechaNacimiento, String direccion, String intereses, String horarios, List<Inscripcion> inscripcion, File archivo, List<Comentario> comentario) {
        super(usuario, nombre, dni, contraseña, email, fechaNacimiento, direccion, intereses, horarios, inscripcion, archivo, comentario);
        this.cif = cif;
        this.informe = informe;
        this.actividad = actividad;
        this.evaluacion = evaluacion;
    }

    public List<Informe> getInforme() {
        return informe;
    }
 
    public void setInforme(List<Informe> informe) {
        this.informe = informe;
    }

    public List<Actividad> getActividad() {
        return actividad;
    }

    public void setActividad(List<Actividad> actividad) {
        this.actividad = actividad;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    
    public List<Evaluacion> getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(List<Evaluacion> evaluacion) {
        this.evaluacion = evaluacion;
    }

}