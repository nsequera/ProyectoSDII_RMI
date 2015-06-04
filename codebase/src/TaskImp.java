import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    	opcion = 1;
    	user = user_;
    }
    
    public TaskImp ()
    {
    	opcion = 2;
    	user = "";
    }

	@Override
	public HashMap<String, String> execute() {
		HashMap<String, String> users = new HashMap<String,String>();
		BufferedReader br;
		try {
			br = new BufferedReader((new FileReader("usuarios.txt")));
			String line;
			if (opcion == 1){
				System.out.println("Se está buscando la contraseña de: "+user);
				while ((line = br.readLine())!=null){
					String[]info = line.split(" ");
					if (info[0].equals(user)){
						users.put(user, info[1]);
					}
				}
			}else if (opcion == 2){
				System.out.println("Se buscan todos los usuarios.");
				while ((line = br.readLine())!=null){
					String[]info = line.split(" ");
					users.put(info[0], info[1]);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}



}
