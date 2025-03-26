package List.Objects.IntList;

public class IntNode {
    private final Integer val;
    private IntNode nextNode;
    private IntNode prevNode;

    public IntNode(Integer val){
        this.val = val;
        nextNode = null;
        prevNode = null;
    }

    //SETTERS
    public void setNextNode(IntNode nextNode) {
        this.nextNode = nextNode;
    }
    public void setPrevNode(IntNode prevNode) {
        this.prevNode = prevNode;
    }

    //GETTERS
    public Integer getVal() {
        return val;
    }
    public IntNode getNextNode() {
        return nextNode;
    }
    public IntNode getPrevNode() {
        return prevNode;
    }
}
