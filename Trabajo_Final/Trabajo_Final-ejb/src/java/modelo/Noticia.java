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
public class Noticia implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (length = 20,nullable = false)
    private String titulo;
    @Column (length = 300,nullable = true)
    private String informacion;
    @Temporal(TemporalType.DATE)
    @Column (nullable = true)
    private Date fechaCreacion;

    @ManyToOne
    private Administrador administrador;

    public Noticia() {
        
    }
    
    public Noticia(Long id, String titulo, String informacion, Date fechaCreacion, Administrador administrador) {
        this.id = id;
        this.titulo = titulo;
        this.informacion = informacion;
        this.fechaCreacion = fechaCreacion;
        this.administrador = administrador;
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

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("id: " + id);
    }
}