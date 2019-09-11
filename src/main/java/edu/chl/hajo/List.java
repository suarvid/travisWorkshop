package edu.chl.hajo;

/**
 * A list with positive integers, implemented as a chain of Nodes, each holding
 * an integer value.
 * 
 * @author hajo
 * 
 */
public class List {
    /*
     * This isn't used to store data just to make an empty list contain a start
     * node (instead of null) Always first in list
     */
    private final Node<Object> head = new Node<Object>(null, null, -1);
    // The number of nodes (except head) in list
    private int length = 0;

    /**
     * Add a node first (after head) in list.
     */
    public void add(Object i) {
        Node<Object> tail = head.getNext();
        Node<Object> n = new Node<Object>(head, tail, i);
        head.setNext(n);
        length++;
    }

    public Object remove() {
        if (length == 0) {
            throw new IllegalStateException("List empty");
        }

        length--;
        Object i = head.getNext().getValue();
        head.setNext(head.getNext().getNext());
        return i;
    }

    // We start with index 0
    public Object get(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        Node<Object> pos = head;
        for (int i = 0; i < index + 1; i++) {
            pos = pos.getNext();

        }
        return pos.getValue();
    }

    public List copy() {
        Node<Object> pos = head.getNext();
        List l = new List();
        while (pos != null) {
            l.add(pos.getValue());
            pos = pos.getNext();
        }
        return l;
    }

    public int getLength() {
        return length;
    }
}
