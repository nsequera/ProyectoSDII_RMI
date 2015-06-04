
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.*;

public class Servidor 
{
	private tEsperandoCliente tesperandocliente;
	private String dirCodebase;
    /** Constructor */
    public Servidor() {
    	dirCodebase = "localhost";
    	System.out.println("Inicializando servidor");
    	
    	tesperandocliente = new tEsperandoCliente();
    	Thread th = new Thread(tesperandocliente);
    	th.start();
    	
		System.setProperty ("java.rmi.server.codebase",
		//		"ftp://ftp:ftp@"+dirCodebase+"/bin/");
				"file:/C:/GitHub/ProyectoSDII_RMI/codebase/bin/");	
		
    	System.setProperty("java.security.policy",
        		"C:/proyectoSD/policy.policy");
    	
    	if (System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager()); 
        }
            
        try{
            // Se publica el objeto remoto
            Compute compute = new ComputeImp();
            /////////////////////////////CAMBIAR IP IP IP IP
            Naming.rebind ("//"+InetAddress.getLocalHost().getHostAddress()+":1500/Compute", compute);
            System.out.println("Inicializado");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Servidor s = new Servidor();
    }
}
