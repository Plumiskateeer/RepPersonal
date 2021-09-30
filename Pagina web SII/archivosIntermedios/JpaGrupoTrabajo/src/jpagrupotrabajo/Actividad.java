package jpagrupotrabajo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (length = 20,nullable = false)
    private String titulo;
    @Column (length = 30,nullable = true)
    private String direccion;
    @Temporal(TemporalType.DATE)
    @Column (nullable = false)
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    @Column (nullable = false)
    private Date fechaRealizacion;
    @Column (length = 15,nullable = true)
    private String asignaturaConvalidable;
    @Column (nullable = true)
    private Boolean Activo;
    @Column (length = 50,nullable = true)
    private String informacion;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "actividad")
    private List<Inscripcion> inscripcion;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "actividad")
    private List<Archivo> archivo;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "actividad")
    private List<Evaluacion> evaluacion;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "actividad")
    private List<Comentario> comentario;
    @ManyToOne
    private Organizacion organizacion;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "actividad")
    private List<Informe> informe;

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public List<Inscripcion> getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(List<Inscripcion> inscripcion) {
        this.inscripcion = inscripcion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getAsignaturaConvalidable() {
        return asignaturaConvalidable;
    }

    public void setAsignaturaConvalidable(String asignaturaConvalidable) {
        this.asignaturaConvalidable = asignaturaConvalidable;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean Activo) {
        this.Activo = Activo;
    }

    public List<Inscripcion> getAlumnos() {
        return inscripcion;
    }

    public void setAlumnos(List<Inscripcion> alumnos) {
        this.inscripcion = alumnos;
    }

    public List<Archivo> getArchivo() {
        return archivo;
    }

    public void setArchivo(List<Archivo> archivo) {
        this.archivo = archivo;
    }

    public List<Evaluacion> getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(List<Evaluacion> evaluacion) {
        this.evaluacion = evaluacion;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

   

    public List<Informe> getInforme() {
        return informe;
    }

    public void setInforme(List<Informe> informe) {
        this.informe = informe;
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.actividad[ id=" + id + " ]";
    }
}