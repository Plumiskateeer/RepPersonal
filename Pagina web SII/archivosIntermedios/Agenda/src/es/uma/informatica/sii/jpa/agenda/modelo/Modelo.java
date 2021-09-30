/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jpa.agenda.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author francis
 */
public class Modelo {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public Modelo()
    {
        emf = Persistence.createEntityManagerFactory("AgendaPU");
        em=emf.createEntityManager();
    }
    
    public boolean aniadirContacto (Contacto c)
    {
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        em.persist(c);
        entr.commit();
        return true;
    }
    
    public void modificarContacto (Contacto c)
    {
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        entr.commit();
    }
    
    public void eliminarContacto (Contacto c)
    {
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        em.remove(c);
        entr.commit();
    }
    
    public List<Contacto> getContactos()
    {
        // TODO: Insertar código para devolver todos los contactos de la BBDD (se puede hacer en 3 líneas contando las que ya hay)
        List<Contacto> res = null;
        res = em.createQuery("Select c from Contacto c").getResultList();
        return res;
    }
    
    public void cerrar()
    {
        em.close();
        emf.close();
    }
    
    
}
