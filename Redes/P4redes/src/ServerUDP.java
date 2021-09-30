import java.io.IOException;
import java.net.*;
/**
 *
 * @author <ANGEL MANUEL JOAQUIN YEBENES>
 */
public class ServerUDP {
    public static String invertir(String s){
        StringBuilder sbr = new StringBuilder();
        sbr.append(s);
        return sbr.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        // DATOS DEL SERVIDOR
        //* FIJO: Si se lee de línea de comando debe comentarse
        int port = 54322; // puerto del servidor
        byte []buffer = new byte[500];
        //* VARIABLE: Si se lee de línea de comando debe descomentarse
        //int port = Integer.parseInt(args[0]); // puerto del servidor

        // SOCKET
        System.out.println("Iniciado el servidor UDP");
        DatagramSocket server = new DatagramSocket(port);


        // Funcion PRINCIPAL del servidor
        while (true)
        {
            //* COMPLETAR: Crear e inicializar un datagrama VACIO para recibir la respuesta de máximo 500 bytes
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);

            //* COMPLETAR Crear e inicalizar el socket del servidor


            //* COMPLETAR: Recibir datagrama
            server.receive(peticion);
            //* COMPLETAR: Obtener texto recibido
            String mensaje = new String(peticion.getData());
            System.out.println("Recibo el mensaje del cliente: " + mensaje);

            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();

            //* COMPLETAR: Mostrar por pantalla la direccion socket (IP y puerto) del cliente y su texto
            System.out.println("Puerto del cliente: " + puertoCliente + " Direccion Ip cliente: " + direccion.toString());

            // Invertimos la linea
            String mensajeInvertido;
            mensajeInvertido = invertir(mensaje);
            buffer = mensajeInvertido.getBytes();
            System.out.println("El mensaje ha sido invertido" + mensajeInvertido);

            //* COMPLETAR: crear datagrama de respuesta
            DatagramPacket respuestainvertida = new DatagramPacket(buffer,buffer.length,direccion,puertoCliente);
            //* COMPLETAR: Enviar datagrama de respuesta
            server.send(respuestainvertida);
            System.out.println("Mensaje invertido enviado de vuelta al cliente");

        } // Fin del bucle del servicio
    }

}
