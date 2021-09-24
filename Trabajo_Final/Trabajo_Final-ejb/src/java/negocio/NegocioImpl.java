package negocio;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Usuario;
import modelo.Organizacion;
import modelo.Comentario;
import modelo.Actividad;
import modelo.Evaluacion;
import modelo.Informe;
import modelo.Inscripcion;
import modelo.Noticia;


@Stateless
public class NegocioImpl implements NegocioInter{
    
    @PersistenceContext(unitName = "SistInf")
    private EntityManager em;
    
    
    //USUARIO
    //FUNCIONA
    @Override
    public Usuario compruebaLogin(Usuario u){
        Usuario user = em.find(Usuario.class, u.getUsuario());
        if(user == null || !user.getContrasenia().equals(u.getContrasenia())){
            return null;
        }
        return user;
    }

    //FUNCIONA
    @Override
    public Usuario refrescarUser(Usuario u) {
        Usuario usu = em.find(Usuario.class, u.getUsuario());
        em.refresh(usu);
        return usu;
    }
      
    //FUNCIONA
    @Override
    public void modificarUser(Usuario u) {
       em.merge(u);
    }
    
    //SIN PROBAR
    public void registrarUsuario(Usuario u)  {
        Usuario user = em.find(Usuario.class, u.getUsuario());
        if(user !=null){
            throw new RuntimeException("Usuario existente");
        }
        em.persist(u); 
    }
    
    //NOTICIA TOTALMENTE FUNCIONAL
    @Override
    public List<Noticia> mostrarNoticias() {
          TypedQuery<Noticia> q = em.createQuery("Select n FROM Noticia n", Noticia.class);
          return q.getResultList();
    }
    
    @Override
    public Noticia refrescarNoticia(Noticia n) {
        Noticia not = em.find(Noticia.class, n.getId());
        em.refresh(not);
        return not;
    }

    @Override
    public void modificarNoticia(Noticia n) {
        em.merge(n);
    }

    @Override
    public void insertarNoticia(Noticia n) {
        em.persist(n);
    }
    
    @Override
    public void borrarNoticia(Noticia n) {
          Noticia not = em.find(Noticia.class, n.getId());
          em.remove(em.merge(not)); 
    }
    
      public void insertarUser(Usuario u) {
          em.persist(u);
      }
      
      public void eliminarUser(Usuario u) {
          Usuario user = em.find(Usuario.class, u.getUsuario());
          em.remove(em.merge(user)); //Porque si no se usa merge puede ser que dos user con misma pk se eliminen o se elimine otro
          em.refresh(refrescarUser(u));
      }
      
      //Organizacion
      public void registrarOrg(Organizacion u) {
       
         Organizacion org = em.find(Organizacion.class, u.getCif());
         if(org !=null)
         {
             // El usuario ya existe
             throw new RuntimeException("Usuario existente");
         }
         u.setCif(u.getCif());
        em.persist(u);
         
     }
      
      
      public void validarCuentaOrg(String cuenta, long validacion)
      {
          Organizacion org = em.find(Organizacion.class,cuenta);
          if(org==null)
          {
              throw new RuntimeException("Cuenta inexsistnente");
          }
          
          if(org.getUsuario()==null)
          {
              //cuenta ya activa
              return;
          }
          
          if(!org.getCif().equals(validacion))
          {
              throw new RuntimeException("Validacion incorrecta");
          }
          //Eliminamos el id indicando que la cuenta ya esta activa
          org.setCif(null);
      }
      
      public void compruebaLoginOrg(Organizacion u)
      {
          Organizacion org = em.find(Organizacion.class,u.getCif());
          if(org ==null)
          {
              throw new RuntimeException("organizacion inexistente");
          }
          if(org.getUsuario()!=null)
          {
              throw new RuntimeException(" cuenta inactiva");
          }
          if(!org.getContrasenia().equals(u.getContrasenia()))
          {
             throw new RuntimeException(" contraseÃ±a invalida"); 
          }
      }
      
      public Organizacion refrescarOrg(Organizacion u)
      {
          compruebaLogin(u);
          em.refresh(u);
          return u;
      }
      
      public void modificarOrg(Organizacion u)
      {
          refrescarUser(u);
          em.merge(u);
          
      }
      
      public void insertarOrg(Organizacion u)
      {
          refrescarOrg(u);
          em.persist(u);
      }
      
      public void eliminarOrg(Organizacion u) 
      {
          Organizacion org = em.find(Organizacion.class, u.getCif());
          em.remove(em.merge(org)); //Porque si no se usa merge puede ser que dos user con misma pk se eliminen o se elimine otro
          em.refresh(refrescarOrg(u));
      }
      
    @Override
      public Organizacion devuelveOrg(Usuario u){
          Organizacion org = em.find(Organizacion.class, u.getUsuario());
          return org;
      }
      
      //Actividad
      @Override
       public Actividad refrescarActividad(Actividad u)
      {
          Actividad act = em.find(Actividad.class,u.getTitulo());
          em.refresh(act);
          return act;
      }
      @Override
      public void modificarActividad(Actividad u)
      {
          
          em.merge(u);
          
      }
      @Override
      public void insertarActividad(Actividad u)
      {
        
        em.persist(u);
        
          
      }
      @Override
      public void eliminarActividad(Actividad u) 
      {
          Actividad a = em.find(Actividad.class, u.getTitulo());
          em.remove(em.merge(a)); //Porque si no se usa merge puede ser que dos user con misma pk se eliminen o se elimine otro
          em.refresh(refrescarActividad(u));
          
      }
      @Override
      public List<Actividad> volcadoListaActividades() {
          
          TypedQuery<Actividad> q = em.createQuery("Select i from Actividad i",Actividad.class);
          List<Actividad> x = new ArrayList<>();
          x = q.getResultList();
          return x;
      }
      
      @Override
      public List<Actividad> volcadoListaActividadesOrganizacion(Organizacion org){
          TypedQuery<Actividad> q = em.createQuery("Select i from Actividad i",Actividad.class);
          List<Actividad> x;
          x = q.getResultList();
          List<Actividad> y = new ArrayList<>();
          for(Actividad a : x){
              if(a.getOrganizacion().equals(org)){
                  y.add(a);
              }
          }
          return y;
      }
      @Override
      public List<Actividad> volcadoListaActividadesUsuario(Usuario u){
          
          TypedQuery<Actividad> q = em.createQuery("Select i from Actividad i",Actividad.class);
          List<Actividad> x;
          x = q.getResultList();
          List<Actividad> y = new ArrayList<>();
          for(Actividad a : x){
              for(Inscripcion i :  a.getAlumnos()){
                  if(i.getUsuario().equals(u)){
                      y.add(a);
                  }
              }
          }
          return y;
      }
      
      //Evaluacion
      @Override
      public Evaluacion refrescarEvaluacion(Evaluacion u) 
      {
          em.refresh(u);
          return u;
      }
      @Override
      public void modificarEvaluacion(Evaluacion u)
      {
          refrescarEvaluacion(u);
          em.merge(u);
          
      }
      @Override
      public void insertarEvaluacion(Evaluacion u) 
      {
          em.persist(u);
      }
      @Override
      public void eliminarEvaluacion(Evaluacion u) 
      {
          Evaluacion a = em.find(Evaluacion.class, u.getId());
          em.remove(em.merge(a));
          em.refresh(refrescarEvaluacion(u));
          
          
      }
      @Override
    public List<Evaluacion> volcadoListaEvaluaciones() {
        TypedQuery<Evaluacion> q = em.createQuery("Select i from Evaluacion i",Evaluacion.class);
        List<Evaluacion> x;
        x = q.getResultList();
        return x;
    }
    
    //CAMBIAR
    @Override
    public List<Evaluacion> volcadoListaEvaluacionesActividades(List<Actividad> actividades) {
        TypedQuery<Evaluacion> q = em.createQuery("Select i from Evaluacion i",Evaluacion.class);
        List<Evaluacion> x;
        x = q.getResultList();
        List<Evaluacion> y = new ArrayList<>();
        for(Evaluacion e : x){
            for(Actividad a : actividades){
                if(e.getComentario().equals(a.getTitulo())){
                    y.add(e);
                }
            }
        } 
        return y;
    }
    
    //Sin probar
    @Override
    public List<Evaluacion> listaNotas(Usuario u) {
        TypedQuery<Evaluacion> q = em.createQuery("Select i from Evaluacion i",Evaluacion.class);
        List<Evaluacion> x = q.getResultList();
        List<Evaluacion> y = new ArrayList<>();
        for(Evaluacion e : x){
            if(e.getEvaluado().equals(u.getUsuario())){
                y.add(e);
            }
        } 
        return y;
    }
      
      //Informe
      @Override
      public Informe refrescarInforme(Informe u) 
      {
          Informe inf = em.find(Informe.class, u.getId());
          em.refresh(inf);
          return inf;
      }
      
      @Override
      public void modificarInforme(Informe u) 
      {
          refrescarInforme(u);
          em.merge(u);
          
      }
      
      @Override
      public void insertarInforme(Informe u, String tituloActividad, Usuario user) 
      {
          Boolean encontrado = false;
          int i = 0;
          List<Actividad> x = new ArrayList<>();
          Actividad y = new Actividad();
          x = volcadoListaActividades();
          while(!encontrado && i<x.size()){
              if(x.get(i).getTitulo().equals(tituloActividad)){
                  encontrado = true;
                  y = x.get(i);
              }
          }
          Organizacion org = new Organizacion();
          org = devuelveOrg(user);
          u.setOrganizacion(org);
          u.setActividad(y);
          em.persist(u);
      }
      
      @Override
      public void eliminarInforme(Informe u) 
      {
          Informe a = em.find(Informe.class, u.getId());
          em.remove(em.merge(a));
      }
      
      @Override
      public List<Informe> volcadoListaInformesOrganizacion(Organizacion org) {
          
          TypedQuery<Informe> q = em.createQuery("Select i from Informe i",Informe.class);
          List<Informe> x = new ArrayList<>();
          x = q.getResultList();
          List<Informe> y = new ArrayList<>();
          for(Informe inf : x){
              if(inf.getOrganizacion().equals(org)){
                  y.add(inf);
              }
          }
          return y;
      }
      

    @Override
    public Inscripcion refrescarInscripcion(Inscripcion i) 
      {
          em.refresh(i);
          return i;
      }
    @Override
    public void eliminarInscripcion(Inscripcion i) {
        Inscripcion encontrado = em.find(Inscripcion.class, i.getId());
        em.remove(encontrado);
        em.refresh(refrescarInscripcion(i));

    }
@Override
      public void modificarInscripcion(Inscripcion i)
      {
          refrescarInscripcion(i);
          em.merge(i);

      }
@Override
      public void insertarInscripcion(Inscripcion i) 
      {
          
          em.persist(i);
      }
      @Override
      public void eliminarNoticia(Noticia n) {
        Noticia encontrado = em.find(Noticia.class, n.getId());
        em.remove(encontrado);
        em.refresh(refrescarNoticia(n));
    }
      
     @Override
     public List<Inscripcion> volcadoListaInscripcionesActividad(Actividad a){
         TypedQuery<Inscripcion> q = em.createQuery("Select i from Inscripcion i",Inscripcion.class);
          List<Inscripcion> x;
          x = q.getResultList();
          List<Inscripcion> y = new ArrayList<>();
          for(Inscripcion e : x){
              if(e.getidACTIVIDAD().equals(a.getId())){
                  y.add(e);
              }
          }
          return y;
     }

    
    //COMENTARIO (Falta por hacer)
    public List<Comentario> mostrarComentarios() {
          TypedQuery<Comentario> q = em.createQuery("Select i from Comentario i", Comentario.class);
          return q.getResultList();
    }
    
    public Comentario refrescarComentario(Comentario u){
        em.refresh(u);
        return u;
    }
      
    public void modificarComentario(Comentario u) {
        refrescarComentario(u);
        em.merge(u);
    }
      
    public void insertarComentario(Comentario u){
        refrescarComentario(u);
        em.persist(u);
    }
      
    public void eliminarComentario(Comentario u){
        Comentario com = em.find(Comentario.class, u.getId());
        em.remove(em.merge(com));
        em.refresh(refrescarComentario(u)); 
    }
    
    @Override
    public List<Comentario> volcadoListaComentarios(){
        
          TypedQuery<Comentario> q = em.createQuery("Select i from Comentario i", Comentario.class);
          List<Comentario> x;
          x = q.getResultList();
          return x;
    }

    @Override
    public List<Actividad> getActividades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
