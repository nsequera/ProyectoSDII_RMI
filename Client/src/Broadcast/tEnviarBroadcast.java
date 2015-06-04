package Broadcast;
import java.net.*;


public class tEnviarBroadcast implements Runnable{

	private DatagramSocket socket;

	public void run() {
		try{
            socket = new DatagramSocket();
            socket.setBroadcast(true);
            byte[] mensajeEnviar = "Cliente".getBytes();
            DatagramPacket paqueteEnviar= new DatagramPacket(mensajeEnviar, 
        			mensajeEnviar.length,InetAddress.getByName("255.255.255.255"),8888);
            while(true){
            	socket.send(paqueteEnviar);
            	Thread.sleep(5000);
            }
        }catch (Exception e){

			e.printStackTrace();
        }   
	}
	
	

}
