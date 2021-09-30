package jpa;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user
 */
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
public class Autor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellidos;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private Integer indiceH;
    @ElementCollection
    private Set<String> firmas;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return nombre;
    }
    
    public void setFirstName(String nombre) {
        this.nombre = nombre;
    }
    
    public String getLastName() {
        return apellidos;
    }
    
     public void setLastName(String apellidos) {
        this.apellidos = apellidos;
    }
     
     public Date getFechaNac()
     {
         return fechaNacimiento;
     }
     
     public void setFechaNac (Date fechaNacimiento)
     {
         this.fechaNacimiento= fechaNacimiento;
     }
     
     public Integer getIndice()
     {
         return indiceH;
     }
     
     public void setIndice(Integer indiceH)
     {
         this.indiceH = indiceH;
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
        if (!(object instanceof Artist)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Artist[ id=" + id + " ]";
    }

    // observe dicho esquema ¿es el que esperaba?
    // no ya que crea 2 tablas en vez de una
    // esto se debe a la etiqueta @ElementCollection
    
}