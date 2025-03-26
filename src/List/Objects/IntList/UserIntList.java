package List.Objects.IntList;

import List.Util.ListError;
import List.Util.Position;
/// Lista con nodos tipo int
public class UserIntList {

    private IntNode head;
    private final String listName;
    private int maxSize = -1;

    public UserIntList(String listName , IntNode head, int size){ //Crear lista con tamaño definido
        this.listName = listName;
        this.head = head;
        this.maxSize = size;
    }

    public UserIntList(String listName, IntNode head){ //Crear lista con tamaño indefinido
        this.listName = listName;
        this.head = head;
    }

    /// MAIN METHODS
    public void push (IntNode newNode, Position pos){ //Agregar nodo
        try {
            if (head == null) {
                head = newNode;
                head.setNextNode(head);
                head.setPrevNode(head);//Si la lista no tiene elementos, asignar nuevo nodo como raíz
            }
            else {
                if(listSize() >= maxSize && maxSize != -1) // Verificar si la lista tiene tamaño definido
                    throw new ListError(maxSize);

                if(pos == Position.RANDOM)
                    pos = pos.getRandom();

                switch (pos) {
                    case FRONT -> pushFront(newNode);
                    case BACK -> pushBack(newNode);
                    case MIDDLE -> pushMiddle(newNode);
                }
            }
            System.out.println("Nodo agregado exitosamente");
        }catch (ListError _){}
    }

    public int pop(Position pos){ //Retirar nodo

        int val;
        try {

            if (head == null)
                throw new ListError(maxSize);

            if (head.getNextNode() == head) {
                val = head.getVal();
                head = null;
                System.out.println("Valor conseguido exitosamente");
                return val;
            }

            if (pos == Position.RANDOM)
                pos = pos.getRandom();

            switch (pos) {
                case FRONT -> val = popFront();
                case BACK -> val = popBack();
                case MIDDLE -> val = popMiddle();
                default -> val = 0;
            }

            System.out.println("Valor conseguido exitosamente");
        }catch (ListError _){
            val =0;
        }
        return val;
    }

    /// PUSH METHODS
    private void pushFront(IntNode newNode){ //Insertar al frente
        IntNode aux = getLastNode(); // Consigue el ultimo nodo
        newNode.setNextNode(head); //Asigna al nuevo nodo, la raíz, como siguiente nodo
        head.setPrevNode(newNode); //Asigna a la raíz, el nuevo nodo, como anterior nodo
        newNode.setPrevNode(aux); //Asigna al nuevo nodo, el ultimo nodo, como anterior nodo
        aux.setNextNode(newNode); //Asigna al ultimo nodo, el nuevo nodo, como siguiente nodo
    }

    private void pushMiddle(IntNode newNode){

        IntNode aux = head;
        for (int i = 1; i < listSize()/2 ; i++) { //Ciclo para localizar al nodo medio
            aux = aux.getNextNode();
        }
        IntNode nextAux = aux.getNextNode();//Consigue el nodo siguente del nodo medio

        aux.setNextNode(newNode); //Asigna al nodo de en medio, el nuevo nodo, como siguiente nodo
        newNode.setPrevNode(aux); //Asigna al nuevo nodo, el nodo de en medio, como anterior nodo
        newNode.setNextNode(nextAux); //Asigna al nuevo nodo, el nodo siguiente del nodo medio, como su siguiente nodo
        nextAux.setPrevNode(newNode); //Asigna al nodo siguiente del nodo medio, el nuevo nodo, como anterior nodo

    }

    private void pushBack(IntNode newHead){
        IntNode aux = head;
        head = newHead;

        head.setNextNode(aux); //Asigna a la nueva raíz, la vieja raíz, como siguiente nodo
        head.setPrevNode(aux.getPrevNode()); //Asigna a la nueva raíz, el anterior de la vieja raíz, como anterior nodo
        head.getPrevNode().setNextNode(head); //Asigno al anterior nodo de la nueva raíz, la nueva raíz, como siguiente nodo
        head.getNextNode().setPrevNode(head); //Asigno al siguiente nodo de la nueva raíz, la nueva raíz, como anterior nodo
    }

    /// POP METHODS
    private int popFront(){
        IntNode rem = getLastNode();
        int val = rem.getVal();

        head.setPrevNode(rem.getPrevNode()); //Asigna a la raíz, el penúltimo nodo, como anterior nodo
        rem.getPrevNode().setNextNode(head); //Asigna al penúltimo nodo, la raíz, como siguiente nodo
        //rem = null; El recolector de basura de Java se encarga de eliminar el objeto no referenciado

        return val;
    }

    private int popMiddle(){

        IntNode aux = head;
        for (int i = 1; i <= listSize()/2 ; i++) { //Ciclo para localizar para el nodo medio
            aux = aux.getNextNode();
        }
        int val =  aux.getVal();

        aux.getPrevNode().setNextNode(aux.getNextNode()); //Asigna al siguiente nodo del nodo anterior del nodo medio, el nodo siguiente del nodo medio, como siguiente nodo
        aux.getNextNode().setPrevNode(aux.getPrevNode()); //Asigna al nodo anterior del nodo siguiente del nodo medio, el nodo anterior al nodo medio, como anterior nodo

        return val;
    }

    private int popBack(){
        int val = head.getVal();
        IntNode aux = head;

        head = aux.getNextNode(); //Asigna al siguiente nodo de la vieja raíz, el nodo siguiente de la raíz, como nueva raíz
        aux.getPrevNode().setNextNode(head); //Asigna al anterior nodo de la vieja raíz, la nueva raíz, como siguiente nodo
        head.setPrevNode(aux.getPrevNode()); //Asigna a la nueva raíz, el anterior de la vieja raíz, como el siguiente nodo

        return val;
    }

    private int pop(int val){

        return 0;

    }

    /// GENERIC METHODS
    protected int listSize(){ // Conseguir el tamaño de la lista
        if(head == null)
            return 0;
        else {
            int nodes = 1;
            IntNode aux = head;
            while (aux.getNextNode() != head) {
                aux = aux.getNextNode();
                nodes++;
            }
            return nodes;
        }
    }

    protected String printValues(){

        int[] values = getValues();
        if(values != null) {
            String printValues = "< ";

            for (int i = 0; i < values.length; i++) {
                if(i % 5 == 0 && i > 0)
                    printValues += "\n"; //Imprime un salto de lista cada 5 valores
                printValues = printValues.concat(String.valueOf(values[i])).concat(" ");
            }

            return printValues.concat(">");
        }
        return "Lista vacia!";
    }

    /// SEEKER METHODS
    private IntNode getLastNode(){ //Conseguir el ultimo nodo de la lista
        IntNode aux = head;
        while (aux.getNextNode() != head)
            aux = aux.getNextNode();
        return aux;
    }

     private int[] getValues(){

        if(head != null) {
            int[] values = new int[listSize()]; //Crear un array del tamano de la lista

            IntNode aux = head;

            for (int i = 0; i < values.length; i++) {
                values[i] = aux.getVal();
                aux = aux.getNextNode();
            }
            return values;

        } else return null; //Si la lista esta vacia regresa nulo
    }

    @Override
    public String toString() {

        return String.format("""
                Nombre lista: %s
                Capacidad: %s
                <Elementos>
                %s""", listName,
                maxSize != -1 ? maxSize : "Infinito!",
                printValues());
    }

    /// GETTERS
    public String getListName() {
        return listName;
    }

    /// SETTERS
    public void setMaxSize(int newMaxSize) { //CAMBIAR TAMAÑO DE LA LISTA
        if(listSize() > newMaxSize) {
            System.out.println("Primero elimine elementos sobrantes");
        }
        else{
            maxSize = newMaxSize;
            System.out.printf("Nueva capacidad [%d] exitosamente asignada\n", maxSize);
        }
    }
}