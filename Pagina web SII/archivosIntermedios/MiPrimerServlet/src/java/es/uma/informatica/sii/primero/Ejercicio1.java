package es.uma.informatica.sii.primero;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ejercicio1", urlPatterns = {"/Ejercicio1"})
public class Ejercicio1 extends HttpServlet {
    
    public static final String NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='POST'>");
            out.println("DNI: <input type='text' name='DNI'>");
            out.println("<br>NIF: ");
            out.println("<br><input type='submit' value='Calcular'>");
            out.println("</body>");
            out.println("</html>");
        }
    }
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String ver = request.getParameter("DNI");
            response.setContentType("text/html;charset=UTF-8");
             try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Ejercicio1</title>");            
                out.println("</head>");
                out.println("<body>");
                if((Integer.parseInt(ver.trim())) < 0 || (Integer.parseInt(ver.trim())) > 999999999 
                    || ver.trim().isEmpty()){
                    out.println("<div>Error</div>");
                }else{
                    out.println("<div>"+calcularletraDNI(Integer.parseInt(ver.trim()))+"</div>");
                }
                out.println("</body>");
                out.println("</html>");
             } 
        }
    

    public static String calcularletraDNI(int dni) {
            return String.valueOf(dni) + 
                    NIF.charAt(dni % 23);
    }
}
