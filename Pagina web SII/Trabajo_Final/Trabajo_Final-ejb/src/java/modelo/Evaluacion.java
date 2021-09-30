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
import javax.persistence.TemporalType;

@Entity
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column (length = 50,nullable = true)
    private String comentario;
    @Column (length = 2,nullable = false)
    private Double puntuacion;
    @Column (length = 15,nullable = true)
    private String evaluado;
    @Temporal(TemporalType.DATE)
    @Column (nullable = true)
    private Date fechaSubida;
    
    @ManyToOne
    private Organizacion organizacion;
    @OneToOne
    private Inscripcion inscripcion;

    public Evaluacion() {
    }
    
    
    public Evaluacion( String comentario, Double puntuacion, String evaluado, Date fechaSubida, Organizacion organizacion, Inscripcion inscripcion) {
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.evaluado = evaluado;
        this.fechaSubida = fechaSubida;
        this.organizacion = organizacion;
        this.inscripcion = inscripcion;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getEvaluado() {
        return evaluado;
    }

    public void setEvaluado(String evaluado) {
        this.evaluado = evaluado;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
    
    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluacion [ id = " + id + ", puntuacion: "+ puntuacion +", Comentario: "+comentario+" ]";
    }
}