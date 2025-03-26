package List.Objects.GeneralList;

public class GenericNode <T> {

    private final T value;
    private GenericNode<T> nextNode;
    private GenericNode<T> prevNode;

    public GenericNode(T value){
        this.value = value;
        nextNode = null;
        prevNode = null;
    }

    //METHODS


    //GETTERS
    public T getValue() {
        return value;
    }
    public GenericNode<T> getNextNode() {
        return nextNode;
    }
    public GenericNode<T> getPrevNode() {
        return prevNode;
    }

    //SETTERS
    public void setNextNode(GenericNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    public void setPrevNode(GenericNode<T> prevNode) {
        this.prevNode = prevNode;
    }
}
