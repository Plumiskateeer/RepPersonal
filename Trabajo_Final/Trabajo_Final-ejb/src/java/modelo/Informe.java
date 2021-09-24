package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Informe implements Serializable {  
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (length = 20,nullable = false)
    private String titulo;
    @Column (length = 200,nullable = false)
    private String contenido;
    @Temporal(TemporalType.DATE)
    @Column (nullable = true)
    private Date fechaSubida;
    @ManyToOne
    private Organizacion organizacion;
    @ManyToOne
    private Actividad actividad;

    public Informe() {
    }

    public Informe(Long id, String titulo, String contenido, Date fechaSubida, Organizacion organizacion, Actividad actividad) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaSubida = fechaSubida;
        this.organizacion = organizacion;
        this.actividad = actividad;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    @Override
    public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
                return false;
                    }
            Informe other = (Informe) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
             return true;
    }
    
    @Override
    public String toString() {
        return "jpa.informe[ id=" + id + " ]";
    }
                          
}