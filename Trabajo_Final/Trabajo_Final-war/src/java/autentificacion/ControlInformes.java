/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Actividad;
import modelo.Informe;
import modelo.Organizacion;
import negocio.NegocioInter;

@Named(value = "controlInformes")
@SessionScoped
public class ControlInformes implements Serializable {
    
    private List<Informe> informes;
    
    private Informe infor;
    
    private String tituloActividad;
    
    @Inject
    private NegocioInter bbdd;
     
    @Inject
    private ControlAutorizacion ctrl;
    
    private List<Informe> misInformesOrganizacion;
    
    public ControlInformes() { 
        informes = new ArrayList<>();
        misInformesOrganizacion = new ArrayList<>();
        infor = new Informe();
        infor.setActividad(new Actividad());
    }
    
    public List<Informe> mostrarInformesOrganizacion(Organizacion org){
        this.misInformesOrganizacion = bbdd.volcadoListaInformesOrganizacion(org);
        return misInformesOrganizacion;
    }

    public List<Informe> getInformes() {
        return informes;
    }
    
    public Informe getInfor(){
        return infor;
    }

    public NegocioInter getBbdd() {
        return bbdd;
    }

    public void setInfor(Informe infor) {
        this.infor = infor;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    
  
    public List<Informe> getInformesOrganizacion() {
        return misInformesOrganizacion;
    }

    public void buscarInforme(){
        infor = bbdd.refrescarInforme(infor);
    }
     
    public void modificarInforme(){
        bbdd.modificarInforme(infor);
    }
    
    public void borrarInforme(){
        bbdd.eliminarInforme(infor);
    }
    
}
