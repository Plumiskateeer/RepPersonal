package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Inscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column (length = 2,nullable = false)
    private Boolean estado;
    @Column (length = 50,nullable = true)
    private String comentario;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column (nullable = true)
    private Date fechaRealizacion;
    
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Actividad actividad;
    @OneToOne
    private Evaluacion evaluacion;
    
     private Long idACTIVIDAD;

    public Inscripcion() {
    }
    
    public Inscripcion(Long id, Boolean estado, String comentario, Date fechaRealizacion, Usuario usuario, Actividad actividad, Evaluacion evaluacion) {
        this.id = id;
        this.estado = estado;
        this.comentario = comentario;
        this.fechaRealizacion = fechaRealizacion;
        this.usuario = usuario;
        this.actividad = actividad;
        this.evaluacion = evaluacion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getidACTIVIDAD(){
        return idACTIVIDAD;
    }

    public void setidACTIVIDAD(Long idACTI){
        this.idACTIVIDAD= idACTI;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }   

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Inscripcion[ id=" + id + " ]";
    }
}