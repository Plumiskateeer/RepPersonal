/**
 *
 * @author <tu nombre aqui>
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {

    public static void main(String[] args) throws IOException {
        // DATOS DEL SERVIDOR:
        //* FIJOS: coméntelos si los lee de la línea de comandos
        String serverName = "127.0.0.1"; // direccion local
        int serverPort = 12345;
        //* VARIABLES: descoméntelos si los lee de la línea de comandos
        //String serverName = args[0];
        //int serverPort = Integer.parseInt(args[1]);

        // SOCKET
        Socket serviceSocket = null;

        // FLUJOS PARA EL ENVÍO Y RECEPCIÓN
        PrintWriter out = null;
        BufferedReader in = null;

        //* COMPLETAR: Crear socket y conectar con servidor
        serviceSocket = new Socket(serverName,serverPort);
        System.out.println("Cliente conectado con el servidor");

        //* COMPLETAR: Inicializar los flujos de entrada/salida del socket conectado en las variables PrintWriter y BufferedReader
        in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
        out = new PrintWriter(serviceSocket.getOutputStream(),true);

        //* COMPLETAR: Recibir mensaje de bienvenida del servidor y mostrarlo

        String mensaje = in.readLine();


        // Obtener texto por teclado
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println("Introduzca un texto a enviar (END para acabar)");
        userInput = stdIn.readLine();

        //* COMPLETAR: Comprobar si el usuario ha iniciado el fin de la interacción
        while (userInput.compareTo("") != 0) { // bucle del servicio
            //* COMPLETAR: Enviar texto en userInput al servidor a través del flujo de salida del socket conectado
            out.println(userInput);
            out.flush();

            //* COMPLETAR: Recibir texto enviado por el servidor a través del flujo de entrada del socket conectado
            String line = in.readLine();

            System.out.println("El mensaje ha sido invertido: " + line);

            // Leer texto de usuario por teclado
            System.out.println("Introduzca un texto a enviar (END para acabar)");
            userInput = stdIn.readLine();
        } // Fin del bucle de servicio en cliente

        // Salimos porque el cliente quiere terminar la interaccion, ha introducido END
        //* COMPLETAR: Enviar TERMINAR al servidor para indicar el fin deL Servicio
        out.println(userInput);
        out.flush();
        //* COMPLETAR: Recibir el VALE del Servidor
        System.out.println(in.readLine());
        //* COMPLETAR Cerrar flujos y socket
        serviceSocket.close();
        in.close();
        out.close();
    }
}
