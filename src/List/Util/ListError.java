package List.Util;

public class ListError extends RuntimeException {
    public ListError(int maxSize) {
        if(maxSize > 0)
        System.out.printf("Capacidad de lista [%d] excedido\n",maxSize);
        else System.out.println("Lista vacia!!!");
    }
}
