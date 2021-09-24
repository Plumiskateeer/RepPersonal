package autentificacion;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Comentario;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Actividad;
import negocio.NegocioInter;


@Named(value = "controlComentarios")
@SessionScoped

public class ControlComentarios implements Serializable{
    
    @Inject
    private ControlAutorizacion ctrl;
    
    
    private Long idAct;
    private List<String> lista;
    
    @Inject
    private NegocioInter bbdd;
    
    private List<Comentario> comentarios;
    private List<Comentario> comentariosActividad;
    
    private Comentario comentario;

    
    public ControlComentarios(){
        comentarios = new ArrayList<>();
        lista = new ArrayList<>();
    }
    
    public void guardarComentario(Usuario usuario, String contenido){
        
        Comentario c = new Comentario();
        c.setUsuario(usuario);
        c.setContenido(contenido);
        comentarios.add(c);
        
    }
    
    public void borrarComentario( Comentario contenido){
        
        
        comentarios.remove(contenido);
        
        
    }
    
    public List<String> getLista(){
        return lista;
    }
    
    public boolean mostrarComentarios(int contador){
       
        return comentarios.get(contador).getUsuario().equals(ctrl.getUsuario());
        
    }
    
    
    public String setidAct(Long id){
         idAct=id;
         return "listaComentarios.xhtml";
        
    }
    
     public int busca(){
        String str = "";
        int contador = 0;
        Iterator<Comentario> it = comentarios.iterator();
        while(it.hasNext()){
            Comentario y = it.next();
            if(idAct.equals(y.getActividad().getTitulo())){
                str = y.getUsuario().getNombre()+":   "+y.getContenido();
                lista.add(str);
                contador++;
            }
        }
        /*if(lista.isEmpty()){
            str = "No existen comentarios ";
            lista.add(str);
            contador++;
        }*/
        return contador;
    }
     
     /**/                                                                                                       /**/
        /*ESTOS SON LOS CAMBIOS REALIZADOS POR ANGEL, NECESARIOS PARA MOSTRAR LOS COMENTARIOS EN CADA ACTIVIDAD*//**/                                                                                                       /**/
        /*ESTOS SON LOS CAMBIOS REALIZADOS POR ANGEL, NECESARIOS PARA MOSTRAR LOS COMENTARIOS EN CADA ACTIVIDAD*/
     /**/                                                                                                       /**/

    /**
     *
     * @return
     */

     
     public NegocioInter getBbdd(){
        return bbdd;
    }
    
    public Comentario getComentario(){
        return comentario;
    }
    public List<Comentario> getComentarios(){
        return comentarios;
    }
    public List<Comentario> getComentariosActividad(){
        return comentariosActividad;
    }
    public List<Comentario> volcadoComentarios(){
        comentarios = bbdd.volcadoListaComentarios();
        return comentarios;
    }
    public List<Comentario> volcadoComentariosActividad(Actividad a){
        
        List<Comentario> listacomentarios = volcadoComentarios();
        comentariosActividad = new ArrayList<>();
        
        
        for(Comentario c : listacomentarios){
            if(c.getActividad().equals(a)){
                comentariosActividad.add(c);
            }
        }
        
        return comentariosActividad;
    }
    
    
        
    }