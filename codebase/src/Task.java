/**
 * Javier Abellán, 5 Mayo 2006
 * Interface para el parámetro que se pasará al Objeto Remoto
 */

import java.io.Serializable;

/**
 * El parámetro contiene dos sumandos que se pueden obtener con los métodos
 * getSumando1() y getSumando2()
 * 
 * @author Javier Abellán
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
