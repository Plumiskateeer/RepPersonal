package modelo;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("u")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column (length = 20, nullable = false)
    private String usuario;
    @Column (length = 20, nullable = false)
    private String nombre;
    @Column (length = 9, nullable = false)
    private String dni;
    @Column (length = 15, nullable = false)
    private String contrasenia;
    @Column (length = 30, nullable = false)
    private String email;
    @Temporal(TemporalType.DATE)
    @Column (nullable = true)
    private Date fechaNacimiento;
    @Column (length = 30, nullable = true)
    private String direccion;
    @Column (length = 50, nullable = true)
    private String intereses;
    @Column (length = 50, nullable = true)
    private String horarios;
    @Column
    private File imagen;
    
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "usuario")
    private List<Inscripcion> inscripcion;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "usuario")
    private List<Comentario> comentario;

    public Usuario() {
    }

    public Usuario(String usuario, String nombre, String dni, String contraseña, String email, Date fechaNacimiento, String direccion, String intereses, String horarios, List<Inscripcion> inscripcion, File archivo, List<Comentario> comentario) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.dni = dni;
        this.contrasenia = contraseña;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.intereses = intereses;
        this.horarios = horarios;
        this.inscripcion = inscripcion;
        this.imagen = archivo;
        this.comentario = comentario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }    

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public List<Inscripcion> getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(List<Inscripcion> inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getUsuario();
    }
}