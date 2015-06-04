/*
 * InterfaceRemota.java
 *
 * Created on 27 de abril de 2004, 21:17
 */


import java.rmi.*;

/**
 * Interface remota 
 */
public interface Compute extends Remote {
    public Object execute (Task sumVector) throws RemoteException; 
}
