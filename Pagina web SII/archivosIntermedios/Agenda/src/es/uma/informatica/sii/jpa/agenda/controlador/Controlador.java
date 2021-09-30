/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jpa.agenda.controlador;

import es.uma.informatica.sii.jpa.agenda.modelo.Contacto;
import java.awt.event.ActionListener;

/**
 *
 * @author francis
 */
public interface Controlador extends ActionListener {
    
    public void modificaContacto(Contacto c);
    
}
