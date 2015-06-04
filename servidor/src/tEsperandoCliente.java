import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class tEsperandoCliente implements Runnable{
    Thread hilo;

	public String eBroadcast(){
	        String ipCliente="";
	        try{
	        	DatagramSocket socket =new DatagramSocket(8888);
	            socket.setBroadcast(true);
	            byte[] mensajeRecibido = new byte[15000];
	            DatagramPacket paqueteRecibido=new DatagramPacket(mensajeRecibido, mensajeRecibido.length);

	            socket.receive(paqueteRecibido);
	            System.out.println("Ip recibida: "+paqueteRecibido.getAddress().getHostAddress());
	            ipCliente=paqueteRecibido.getAddress().getHostAddress();
	            
	            socket.close();
	            
	        }catch (Exception e){
	        	e.printStackTrace();
	        }
	    return ipCliente;
	}
    
	private void enviarMensaje(String ipDestino) {
		
		try {
			DatagramSocket socket =new DatagramSocket();
			byte[] mensajeEnviar = "soyServidor".getBytes();
            DatagramPacket paqueteEnviar= new DatagramPacket(mensajeEnviar, 
            		mensajeEnviar.length,InetAddress.getByName(ipDestino),9999);
            
            socket.send(paqueteEnviar);
            socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
    public void run() {
    	System.out.println("Esperando al cliente.");   
    	while(true){
    		String add = eBroadcast();
    		if(add != null){
    			enviarMensaje(add);
    		}
    	}
    }

	
}