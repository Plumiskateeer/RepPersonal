import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class ServerTCP {
    public static String invertir(String s){
        StringBuilder sbr = new StringBuilder(s);
        sbr.reverse();
        return sbr.toString();
    }

    public static void main(String[] args)
    {
        // DATOS DEL SERVIDOR
        //* FIJO: Si se lee de línea de comando debe comentarse
        int port = 12345; // puerto del servidor
        //* VARIABLE: Si se lee de línea de comando debe descomentarse
        // int port = Integer.parseInt(args[0]);

        // SOCKETS
        ServerSocket server = null; // Pasivo (recepción de peticiones)
        Socket client = null;       // Activo (atención al cliente)

        // FLUJOS PARA EL ENVÍO Y RECEPCIÓN
        BufferedReader in = null;
        PrintWriter out = null;

        int ncola = 1;

        //* COMPLETAR: Crear e inicalizar el socket del servidor (socket pasivo)
        System.out.println("Iniciando servidor");
        try{
            server = new ServerSocket(port,ncola); // se crea el socket con el puerto y el tamaño maximo

        while (true) // Bucle de recepción de conexiones entrantes
        {

                //* COMPLETAR: Esperar conexiones entrantes
                System.out.println("Esperando conexion...");
                client = server.accept(); // aceptamos la conexion

                //* COMPLETAR: Una vez aceptada una conexion, inicializar flujos de entrada/salida del socket conectado
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));//Lectura de los desplazamientos y cadenas del cliente
                out = new PrintWriter(client.getOutputStream());//Envio de las cadenas invertidas al cliente
                System.out.println("Conexión establecida");

                out.println("Mensaje desde el servidor, el texto va a ser invertido");
                out.flush();

                boolean salir = false;
                while (!salir) // Inicio bucle del servicio de un cliente
                {
                    //* COMPLETAR: Recibir texto en line enviado por el cliente a través del flujo de entrada del socket conectado
                    String line = in.readLine();

                    //* COMPLETAR: Comprueba si es fin de conexion - SUSTITUIR POR LA CADENA DE FIN enunciado
                    if (line.compareTo("") != 0) {
                        line = invertir(line);
                        System.out.println("La cadena invertida es " + line);

                        //* COMPLETAR: Enviar texto al cliente a traves del flujo de salida del socket conectado
                        out.println(line);
                        out.flush();
                    } else { // El cliente quiere cerrar conexión, ha enviado TERMINAR
                        out.println("Mensaje desde el servidor, se realiza la desconexion");
                        out.flush();
                        System.out.println("El cliente quiere cerrar la conexion");
                        salir = true;
                    }
                } // fin del servicio

                //* COMPLETAR: Cerrar flujos y socket
                client.close();
                out.close();
                in.close();


            } // fin del bucle
        }catch(IOException e)   {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    } // fin del metodo
}
