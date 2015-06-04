

import java.rmi.*;
import java.io.Serializable;


public interface Compute extends Remote {
    public Object execute (Task task) throws RemoteException; 
}
