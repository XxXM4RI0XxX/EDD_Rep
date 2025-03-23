package GenericMethods;

/*
    Todo tipo de dato primitivo tiene su tipo de envoltura (java.lang)
    Esto permite manejar datos de tipos primitivos como objetos (clases) :o
    int, float, boolean, char, long (primitivo)
    Integer, Float, Boolean, Character, Long (envoltura)
    Todas estas se extienden de la clase Number
    Todas las clases envoltura son calificadas como tipo final, y tampoco permiten heredarse (extends)

    Los datos primitivos ocupan espacio para su valor
    Los datos clase envoltura hacen una referencia a su dato primitivo (son apuntadores :o)

    En Java SE 5, adopto estas conversiones como propias del sistema:
    boxing: primitivo -> envoltura
    unboxing: envoltura -> primitivo
    Integer a = 10; *apuntador hacia el dato [int 10]
    int b = a; ; a 'b' le asigna el dato [int 10] al que hace referencia el apuntador 'a'
    (Funciona a la inversa también)
    >>Antes los programadores tenían que hacer la conversion a mano xd, alabado sea 2025

    Estas clases de envoltura cuentan con sus propios métodos (parse, compareTo, valueOf)

    // INTERFACES Y ABSTRACTAS

    Implementar una clase implica utilizar todos los metodos de una interfaz
    Se puede declarar una clase como 'abstract' para poder utilizar solo los metodos necesarios
    Pero esto implica que no se pueda crear objetos de esa clase, ya que se considera como una clase incompleta
    Si bien una clase abstracta no puede ser referenciada como objeto, si se pueden llamar sus metodos para utilizarlos
    Esto ultimo puede servir para proteger una clase que se construyan objetos de ella

    Una interfaz sirve como guia al usuario para saber de que manera utilizar un metodo
    Su uso mas que operativo es informativo

    A su vez, una clase declarada como 'abstract' tiene un mejor uso como plantilla

    Comparar su uso como cuando se cambia un foco, la marca, el tamaño, y el voltaje son la interfaz
    indican que es lo que hacen; el como y donde conectar el foco es lo que se llenaria dentro de
    esa interfaz al momento de implimentar sus metodos

 */

public class Main{

    public static void main(String[] args) {

                int x = 10;
                Integer b = 7;
                b.compareTo(x);

    }

    //Metodo generico
    public static <T> void printArray(T[] inputArray){ //Solo puede manejar tipos de datos por referencia, nunca tipos primitivos
        for (T elem : inputArray){
            //display array elements
            System.out.printf("%s\n", elem);
        }
    }//end method printArray

    public static <T extends Comparable<T>> void sort(T[] array){ //???.. pa que?
        int intercambios;
        int finalPos = array.length - 1;

//        do{
//            for (int i = 0; i < finalPos; i++) {
//                if(array[i].compareTo(array[i+1]) > 0){
//                    // ???
//                }
//            }
//            finalPos--;
//        }while (intercambios > 0);
    }
}
