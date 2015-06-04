/*
 * Cliente.java
 *
 * Ejemplo de rmi sin SecurityManager
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.util.HashSet;
import java.util.Set;

import Broadcast.tEnviarBroadcast;
import Broadcast.tRecibirMensaje;


public class Cliente {
    
	private static String ipCodebase;
	static Set<String> ipServidores;
	private static BufferedReader br;
	static Compute objetoRemoto;
	   
    public static void main(String[] args) {
        new Cliente();
        
        Cliente.buscarServidor (ipServidores);
        try {
			//br = new BufferedReader(new FileReader("vector"));
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Buscando servidores");
			while (ipServidores.size()!=0);
			System.out.println("Se ha encontrado un servidor");
			
			String opcion = new String ();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

    public Cliente() 
    {
    	System.out.println("Inicializando cliente");
    	ipServidores  = new HashSet<String>();
    	ipCodebase="localhost";
    	try
        {
            // Cambiar ip del ftp - Cliente
            System.setProperty ("java.rmi.server.codebase",
            //		"ftp://ftp:ftp@"+ipCodebase+"/bin/");
    				"file:/C:/GitHub/ProyectoSDII_RMI/codebase/bin/");	
	        System.setProperty("java.security.policy",
	        		"C:/GitHub/ProyectoSDII_RMI/policy.policy");
	        
            if (System.getSecurityManager()==null){
                System.setSecurityManager(new RMISecurityManager());
            }

           
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    


	private static void buscarServidor(Set<String> ipServidores) {
		Thread th1 = new Thread(new tEnviarBroadcast());
		Thread th2 = new Thread(new tRecibirMensaje(ipServidores));
		th1.start();
		th2.start();
	}
    
}
