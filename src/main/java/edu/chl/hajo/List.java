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
    private final Node<Integer> head = new Node<Integer>(null, null, -1);
    // The number of nodes (except head) in list
    private int length = 0;

    /**
     * Add a node first (after head) in list.
     */
    public void add(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Only positive values allowed");
        }
        Node<Integer> tail = head.getNext();
        Node<Integer> n = new Node<Integer>(head, tail, i);
        head.setNext(n);
        length++;
    }

    public int remove() {
        if (length == 0) {
            throw new IllegalStateException("List empty");
        }

        length--;
        int i = head.getNext().getValue();
        head.setNext(head.getNext().getNext());
        return i;
    }

    // We start with index 0
    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        Node<Integer> pos = head;
        for (int i = 0; i < index + 1; i++) {
            pos = pos.getNext();

        }
        return pos.getValue();
    }

    public List copy() {
        Node<Integer> pos = head.getNext();
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
