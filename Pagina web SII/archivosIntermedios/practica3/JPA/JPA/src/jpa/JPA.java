/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Alejandro
 */
public class JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        CONFIGURAR PRIMERO EL ARCHIVO persistence.xml:
        En services -> Databases -> Java DB.
        click derecho 'start server'
        click derecho 'Create Database'
        meter los datos de la base de datos en persistence.xml
        En javax.persistence.jdbc.url despues del puerto 1527/ va el nombre de la base de datos
        
        Para las nuevas entidades deben añadirse al archivo de persistence.xml con <class>
        */
        
        Artist al = new Artist();
        al.setFirstName("Alejandro");
        al.setLastName("Mozo");
        Artist a2 = new Artist();
        a2.setFirstName("Alejandro2");
        a2.setLastName("Mozo2");

        Autor a11 = new Autor();
        a11.setFirstName("Nombre");
        a11.setLastName("Apellido");
        a11.setId(Long.MIN_VALUE);
        
        Autor a22 = new Autor();
        a22.setFirstName("Nombre");
        a22.setLastName("Apellido");
        a22.setId(Long.MIN_VALUE);
        
        Articulo a111 = new Articulo();
        a111.setTitulo("hola");
        
        Articulo a222 = new Articulo();
        a222.setTitulo("adios");
        
        
        // TODO Auto-generated method stub
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        // 3-Persists the book to the database
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(al);
        em.persist(a2);
        tx.commit();
        
        em.close();
        emf.close();
    }
    
}
