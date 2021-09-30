package jpagrupotrabajo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Organizacion extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column (length = 9, nullable = false)
    private String cif;
    
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "organizacion")
    private List<Informe> informe;
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "organizacion")
    private List<Actividad> actividad;
 
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
    
    

   
    
}
