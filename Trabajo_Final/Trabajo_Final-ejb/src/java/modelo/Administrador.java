package modelo;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("a")
public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column (length = 1, nullable = true)
    private int nivel;
    
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "administrador")
    private List<Noticia> noticia;

    public Administrador() {
    }

    public Administrador(int nivel, List<Noticia> not, String usuario, String nombre, String dni, String contraseña, String email, Date fechaNacimiento, String direccion, String intereses, String horarios, List<Inscripcion> inscripcion, File archivo, List<Comentario> comentario) {
        super(usuario, nombre, dni, contraseña, email, fechaNacimiento, direccion, intereses, horarios, inscripcion, archivo, comentario);
        this.nivel = nivel;
        this.noticia = not;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Noticia> getNoticia() {
        return noticia;
    }

    public void setNoticia(List<Noticia> noticia) {
        this.noticia = noticia;
    }
}