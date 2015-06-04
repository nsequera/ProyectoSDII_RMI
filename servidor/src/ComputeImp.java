
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ComputeImp extends UnicastRemoteObject implements Compute
{
	private static final long serialVersionUID = -7818037258123405855L;

    public ComputeImp () throws RemoteException
    {
        super();
    }

    public Object execute(Task task) 
    {
        return task.execute();
    }
    
}
