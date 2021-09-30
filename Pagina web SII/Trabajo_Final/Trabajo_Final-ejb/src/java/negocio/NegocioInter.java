/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modelo.Actividad;
import modelo.Comentario;
import modelo.Evaluacion;
import modelo.Informe;
import modelo.Inscripcion;
import modelo.Noticia;
import modelo.Organizacion;
import modelo.Usuario;

@Local
public interface NegocioInter {
    
      public Usuario compruebaLogin(Usuario u);
      public void modificarUser(Usuario u);
      public void registrarUsuario(Usuario u)  ;
      public Usuario refrescarUser(Usuario u) ;
      public void insertarUser(Usuario u) ;
      public void eliminarUser(Usuario u) ;
      
      //Organizacion
      public void registrarOrg(Organizacion u) ;
      public void validarCuentaOrg(String cuenta, long validacion);
      public void compruebaLoginOrg(Organizacion u);
      public Organizacion refrescarOrg(Organizacion u);
      public void modificarOrg(Organizacion u);
      public void insertarOrg(Organizacion u);
      public void eliminarOrg(Organizacion u);
      public Organizacion devuelveOrg(Usuario u);
      
      
      //Administrador
      //Al ser admin una subclase de usuario...Â¿como lo hacemos?
      
      
      
      //Actividad
      public Actividad refrescarActividad(Actividad u);
      public void modificarActividad(Actividad u);
      public void insertarActividad(Actividad u);
      public void eliminarActividad(Actividad u);
      public List<Actividad> volcadoListaActividades();
      public List<Actividad> volcadoListaActividadesOrganizacion(Organizacion org);
      public List<Actividad> volcadoListaActividadesUsuario(Usuario u);
      
      //Evaluacion
      
      public Evaluacion refrescarEvaluacion(Evaluacion u);
      public void modificarEvaluacion(Evaluacion u);
      public void insertarEvaluacion(Evaluacion u);
      public void eliminarEvaluacion(Evaluacion u);
      public List<Evaluacion> volcadoListaEvaluaciones();
      public List<Evaluacion> volcadoListaEvaluacionesActividades(List<Actividad> actividades);
      public List<Evaluacion> listaNotas(Usuario u);
          
      //Informe
      
      public Informe refrescarInforme(Informe u);
      public void modificarInforme(Informe u);
      public void insertarInforme(Informe u, String tituloActividad, Usuario user);
      public void eliminarInforme(Informe u);
      public List<Informe> volcadoListaInformesOrganizacion(Organizacion org);
      
      
      //Inscripcion
      public Inscripcion refrescarInscripcion(Inscripcion i);
      public void eliminarInscripcion(Inscripcion i);
      public void modificarInscripcion(Inscripcion i);
      public void insertarInscripcion(Inscripcion i);
      public void eliminarNoticia(Noticia n);
      public List<Inscripcion> volcadoListaInscripcionesActividad(Actividad a);
      
      

    
    //Mis cambios
    
    //Noticia (HECHO)
      
      
      public List<Noticia> mostrarNoticias();
      public Noticia refrescarNoticia(Noticia n);
      public void modificarNoticia(Noticia n);
      public void insertarNoticia(Noticia n);
      public void borrarNoticia(Noticia n);
      
      
    //COMENTARIO (Falta por hacer)
      
      
      public List<Comentario> mostrarComentarios();
      public Comentario refrescarComentario(Comentario u);
      public void modificarComentario(Comentario u);
      public void insertarComentario(Comentario u);
      public void eliminarComentario(Comentario u);
      public List<Comentario> volcadoListaComentarios();
    

    
      public List<Actividad> getActividades() ;
    
}
