package jpagrupotrabajo;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaGrupoTrabajo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaP");
        EntityManager em = emf.createEntityManager();
        
       
        
        Archivo a = new Archivo();
        a.setNombre("Archivo");
        a.setTipo("Foto");
        a.setUrl("www");

        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       
        em.persist(a);
        tx.commit();
       
        em.close();
        emf.close();
        
        
        
        
    }
}
