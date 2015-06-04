import java.util.HashMap;



public class TaskImp implements Task
{
  
    /**
	 * 
	 */
	private static final long serialVersionUID = -60853326034356937L;
	private String user;
	private int opcion;
    
    
    public TaskImp (String user_)
    {
    	opcion = 2;
    	user = user_;
    }
    
    public TaskImp ()
    {
    	opcion = 1;
    	user = "";
    }

	@Override
	public HashMap<String, String> execute() {
		HashMap<String, String> users = new HashMap<String,String>();
		
		if (opcion == 1){
			
		}else if (opcion == 2){
			
		}
		return users;
	}



}
