package List;

import List.Objects.GeneralList.GenericNode;
import List.Objects.GeneralList.UserGenericList;
import List.Util.Position;
import Util.RandomGenerator;
import Util.RandomObject;

public class Main {

    public static void main(String[] args) {

        /* TODO LISTA DOBLE LIGADA CIRCULAR CON NODOS:

         APLICAR MI CONOCIMIENTO ADQUIRIDO EN JFRAMES PARA HACER UNA INTERFAZ PERRA
         PARA ESTA LISTA, VAMO A EXPERIMENTAR >:3

         AGREGAR ESTE METODO:
         [SI TIENE MAS ELEMENTOS DEL NUMERO QUE SE QUIERE ASIGNAR,
         SE TIENEN QUE BORRAR HASTA QUE ALCANCE EL TAMAÑO DESEADO;
         AGREGAR OPCIÓN DE "FORZAR BORRADO", BORRA ELEMENTOS AUTOMÁTICAMENTE
         PARA AJUSTARSE AL TAMAÑO DESEADO (ELEMENTOS PRIMEROS, FINALES, MEDIOS, O AL AZAR)]

         ACOMODAR LISTA (ORDEN NUMÉRICO)
         - MAYOR A MENOR
         - MENOR A MAYOR
         [AL CAMBIAR ENTRE ACOMODOS MAYOR A MENOR Y VICEVERSA, GUARDAR ESE
         ESTADO DE ACOMODO DE LA LISTA, PARA LOS ACOMODOS AUTOMÁTICOS]

         INSERTAR VALOR ACOMODADO
         POP VALOR ESPECIFICO
         */

        UserGenericList<Object> list = new UserGenericList<>("Lista chida",null);


//        list.push(new GenericNode<>("Algo"),Position.RANDOM);
//        list.push(new GenericNode<>(25),Position.RANDOM);
//        list.push(new GenericNode<>(true),Position.RANDOM);

        RandomObject obj = RandomGenerator.genRandomObject();

        System.out.println(obj);

    }
}
