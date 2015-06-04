/**
 * Javier Abell�n, 5 Mayo 2006
 * Interface para el par�metro que se pasar� al Objeto Remoto
 */

import java.io.Serializable;

/**
 * El par�metro contiene dos sumandos que se pueden obtener con los m�todos
 * getSumando1() y getSumando2()
 * 
 * @author Javier Abell�n
 *
 */
public interface Task  extends Serializable
{
    /**
     * Obtener el sumando 1
     * @return sumando 1
     */
    public Object execute();

}
