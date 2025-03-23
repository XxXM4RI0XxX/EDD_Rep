package List;

import List.Objects.Node;
import List.Objects.UserIntList;
import List.Util.Position;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /* LISTA DOBLE LIGADA CIRCULAR CON NODOS:

         APLICAR MI CONOCIMIENTO ADQUIRIDO EN JFRAMES PARA HACER UNA INTERFAZ PERRA
         PARA ESTA LISTA, VAMO A EXPERIMENTAR >:3
         
         AGREGAR ESTE METODO:
         [SI TIENE MAS ELEMENTOS DEL NUMERO QUE SE QUIERE ASIGNAR,
         SE TIENEN QUE BORRAR HASTA QUE ALCANZE EL TAMAÑO DESEADO;
         AGREGAR OPCION DE "FORZAR BORRADO", BORRA ELEMENTOS AUTOMATICAMENTE
         PARA AJUSTARSE AL TAMAÑO DESEADO (ELEMENTOS PRIMEROS, FINALES, MEDIOS, O AL AZAR)]

         ACOMODAR LISTA (ORDEN NUMERICO)
         - MAYOR A MENOR
         - MENOR A MAYOR
         [AL CAMBIAR ENTRE ACOMODOS MAYOR A MENOR Y VICEVERSA, GUARDAR ESE
         ESTADO DE ACOMODO DE LA LISTA, PARA LOS ACOMODOS AUTOMATICOS]
         HACER LISTAS DE OTROS TIPOS DE DATOS (STRING, CHAR, DOUBLE, GENERIC<T>)

         INSERTAR VALOR ACOMODADO
         POP VALOR ESPECIFICO
         */

        UserIntList userList = new UserIntList("Test list",null);

        userList.push(new Node(20),Position.RANDOM);
        userList.push(new Node(45),Position.RANDOM);
        userList.push(new Node(100),Position.RANDOM);
        userList.push(new Node(-1),Position.RANDOM);
        userList.push(new Node(-20),Position.RANDOM);
        userList.push(new Node(42),Position.RANDOM);



    }
}
