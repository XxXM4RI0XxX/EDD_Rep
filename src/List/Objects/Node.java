package List.Objects;

public class Node {
    private final Integer val;
    private Node nextNode;
    private Node prevNode;

    public Node(Integer val){
        this.val = val;
        nextNode = null;
        prevNode = null;
    }

    //SETTERS
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    //GETTERS
    public Integer getVal() {
        return val;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public Node getPrevNode() {
        return prevNode;
    }
}
