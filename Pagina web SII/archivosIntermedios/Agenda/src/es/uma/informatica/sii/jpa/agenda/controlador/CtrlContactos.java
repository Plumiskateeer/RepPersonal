/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jpa.agenda.controlador;

import es.uma.informatica.sii.jpa.agenda.modelo.Contacto;
import es.uma.informatica.sii.jpa.agenda.modelo.Modelo;
import es.uma.informatica.sii.jpa.agenda.vista.Vista;
import java.awt.event.ActionEvent;

/**
 *
 * @author francis
 */
public class CtrlContactos implements Controlador {

    private Modelo modelo;
    private Vista vista;
    
    public CtrlContactos(Modelo m, Vista v)
    {
        vista = v;
        modelo = m;
        
        vista.setContolador(this);
        vista.setContactos(modelo.getContactos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Añadir":
                aniadirContacto();
                break;
            case "Eliminar":
                eliminarContacto();
                break;
        }
    }

    private void aniadirContacto() {
        Contacto c = new Contacto();
        modelo.aniadirContacto(c);
        vista.addContacto(c);
    }

    private void eliminarContacto() {
        Contacto c = vista.getSelected();
        if (c != null)
        {
            modelo.eliminarContacto(c);
            vista.setContactos(modelo.getContactos());
        }
    }

    @Override
    public void modificaContacto(Contacto c) {
        modelo.modificarContacto(c);
    }
}
