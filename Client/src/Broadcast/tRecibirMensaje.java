package Broadcast;
import java.net.*;
import java.util.*;


public class tRecibirMensaje implements Runnable{
		private Set<String> direcciones;
	    Thread hilo;
		private DatagramSocket socket;
		
		
	    public tRecibirMensaje(Set<String> direcciones_) {
	        direcciones=direcciones_;
	    }

	    public void run() {   
	        try{
	            socket = new DatagramSocket(9999);
	            String midireccion = InetAddress.getLocalHost().getHostAddress();
	            socket.setBroadcast(true);
	            byte[] mensajeRecibido = new byte[1500];
	            DatagramPacket paqueteRecibido=new DatagramPacket(mensajeRecibido, mensajeRecibido.length);
	            while(true){
	               socket.receive(paqueteRecibido);
	               //if (!midireccion.equals(paqueteRecibido.getAddress().getHostAddress())){
		               if (!direcciones.contains(midireccion)){
		                    System.out.println("Recibí: "+paqueteRecibido.getAddress().getHostAddress());
		                    direcciones.add(paqueteRecibido.getAddress().getHostAddress());
		               }
	               //}
	            }
	        }catch (Exception e){
	        	e.printStackTrace();
	        }
	    }
	    
}
