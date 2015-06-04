/*
 * Cliente.java
 *
 * Ejemplo de rmi sin SecurityManager
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.RowFilter.Entry;

import Broadcast.tEnviarBroadcast;
import Broadcast.tRecibirMensaje;


public class Cliente {
    
	private static String ipCodebase;
	static Set<String> ipServidores;
	private static BufferedReader br;
	static Compute objetoRemoto;
	   
    public static void main(String[] args) {
        new Cliente();
        HashMap<String, String> users = new HashMap<>();
        Cliente.buscarServidor (ipServidores);
        try {
			//br = new BufferedReader(new FileReader("vector"));
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Buscando servidores");
			while (ipServidores.size()!=0);
			System.out.println("Se ha encontrado un servidor");
			Thread.sleep(3000);
			String opcion = new String ();
			
			
			do{
				System.out.println("1. Buscar contraseña.");
				System.out.println("2. Mostrar todos los usuarios.");
				System.out.println("3. Salir");
				System.out.print("Opción: ");
				opcion = br.readLine();
				switch (opcion) {
					case "1":
						System.out.print("Ingrese el usuario: ");
						String user = br.readLine();
						
						for (String ipServidor:ipServidores){
							objetoRemoto = (Compute)Naming.lookup ("//"+ipServidor+":1500/Compute");
							Task task = new TaskImp(user);
							HashMap<String, String> users_re = (HashMap<String, String>) objetoRemoto.execute(task);
							users.putAll(users_re);
						}
						if (users.containsKey(user)){
							System.out.println("La contraseña es: "+users.get(user));
						}else{
							System.out.println("El usuario no está registrado.");
						}
						break;
					
					case "2":
						for (String ipServidor:ipServidores){
							objetoRemoto = (Compute)Naming.lookup ("//"+ipServidor+":1500/Compute");
							Task task = new TaskImp();
							HashMap<String, String> users_re = (HashMap<String, String>) objetoRemoto.execute(task);
							users.putAll(users_re);
						}
						System.out.println("Lista de usuarios");
						Set<String> keys = users.keySet();
						for (String key:keys){
							System.out.println(key +" "+users.get(key));
						}
						break;
		
					case "3":
						break;
						
					default:
						System.out.println("Opcion inválida.");
						break;
				}
				users.clear();
		}while (!opcion.equals("3"));
			
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
