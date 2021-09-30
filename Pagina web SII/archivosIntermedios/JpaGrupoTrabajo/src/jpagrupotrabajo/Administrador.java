package jpagrupotrabajo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column (length = 1, nullable = false)
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}