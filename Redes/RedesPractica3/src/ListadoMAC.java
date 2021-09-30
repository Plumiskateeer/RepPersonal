import java.net.*;
import java.util.*;


public class ListadoMAC {

	public static void main(String args[]) throws SocketException {
		List<NetworkInterface> nets = Collections.list(NetworkInterface.getNetworkInterfaces());

		for (NetworkInterface netint : nets)
			System.out.print(displayInterfaceInformation(netint));
	}

	public static String mac2text(byte[] mac) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
		}
		return sb.toString();
	}

	public static String displayInterfaceInformation(NetworkInterface inet) throws SocketException {
		StringBuilder sb = new StringBuilder();
		List<InterfaceAddress> ips = inet.getInterfaceAddresses();
		if (inet.isUp() && inet.getHardwareAddress() != null) {
			if (ips.size() > 0)
				sb.append(inet.getName() + ": MAC = " + mac2text(inet.getHardwareAddress())
						+ " | IP = " + ips.get(0).getAddress().getHostAddress() + "  (" + ips.get(0).getAddress().getHostAddress()
						+ "/" + ips.get(0).getNetworkPrefixLength() + ") \n");
			else
				sb.append(inet.getName() + ": MAC = " + mac2text(inet.getHardwareAddress()) + " | IP = NO DISPONIBLE \n");
		}
		return sb.toString();
	}
}