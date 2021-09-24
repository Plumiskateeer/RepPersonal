
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author <ANGEL MANUEL JOAQUIN YEBENES>
 */

public class ClientUDP {
    private static InetAddress InetAdress;

    public static void main(String[] args) throws IOException {
        // DATOS DEL SERVIDOR:
        //* FIJOS: coméntelos si los lee de la línea de comandos
        String serverName = "127.0.0.1"; //direccion local
        int serverPort = 54322;
        byte []buffer = new byte[500];
        DatagramSocket serviceSocket = null;

        //* VARIABLES: descoméntelos si los lee de la línea de comandos
        //String serverName = args[0];
        //int serverPort = Integer.parseInt(args[1]);
/*
        String mensaje = "Mensaje desde el cliente";

        buffer = mensaje.getBytes();

        DatagramPacket pregunta = new DatagramPacket(buffer,buffer.length, direccion, serverPort);

        System.out.println("Envio el datagrama");
        serviceSocket.send(pregunta);

        DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);

        serviceSocket.receive(peticion);
        System.out.println("Recibo la peticion");

        mensaje = new String(peticion.getData());

        System.out.println(mensaje);

        serviceSocket.close();

*/

        //* COMPLETAR: crear socket

        try {
            serviceSocket = new DatagramSocket();
        } catch (SocketException e)
        {
            System.err.println("Error: No se ha podido crear");
        }


        // INICIALIZA ENTRADA POR TECLADO
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in) );
        String userInput;
        System.out.println("Introduzca un texto a enviar (END para acabar): ");
        userInput = stdIn.readLine(); /*CADENA ALMACENADA EN userInput*/
        buffer = userInput.getBytes();

        //* COMPLETAR: Comprobar si el usuario quiere terminar servicio
        while (userInput.compareTo("END") != 0)
        {
            //* COMPLETAR: Crear datagrama con la cadena escrito en el cuerpo

            try{
                DatagramPacket datagram = new DatagramPacket(buffer, buffer.length,InetAdress.getByName(serverName), serverPort);//
                serviceSocket.send(datagram);

            }catch (UnknownHostException e){
                System.err.println("No conocido");
            }
            System.out.println("STATUS: Waiting for the reply");

            //* COMPLETAR: Crear e inicializar un datagrama VACIO para recibir la respuesta de máximo 500 bytes

            DatagramPacket receivedDatagram = new DatagramPacket(buffer,buffer.length);
            //* COMPLETAR: Recibir datagrama de respuesta

            serviceSocket.receive(receivedDatagram);
            //* COMPLETAR: Extraer contenido del cuerpo del datagrama en variable line
            String line = new String(receivedDatagram.getData());

            System.out.println("texto invertido: " + line);
            System.out.println("Introduzca un texto a enviar (END para acabar): ");
            userInput = stdIn.readLine();
            buffer = userInput.getBytes();
        }

        System.out.println("STATUS: Closing client");

        //* COMPLETAR Cerrar socket cliente
        serviceSocket.close();

        System.out.println("STATUS: closed");
    }

}
