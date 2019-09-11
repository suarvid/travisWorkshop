package edu.chl.hajo;

/**
 * This is used as "links" in a chained list.
 * Each link can hold a value
 * 
 * No test for this class it's trivial.
 * 
 * @author hajo
 *
 * @param <T> Type of value
 */
public class Node<T> {
    private final T value;
    private Node<T> next;
    private final Node<T> prev;
    public Node( Node<T> prev, Node<T> next, T value){
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }
    public Node<T> getPrev(){
        return prev;
    }
    public T getValue(){
        return value;
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
}
