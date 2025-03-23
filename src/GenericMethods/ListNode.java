package GenericMethods;
//class to represent one node in a list
public class ListNode <T>{

    T data;
    ListNode<T> nextNode;

    ListNode(T object){}
    ListNode(T object,ListNode<T> node){}
    T getData(){return null;}
    ListNode<T> getNext(){return null;}
} //end class ListNode<T>
