package ie.ucd.hello;


public class LinkedStack<T> {

    private int size;       
    private Node top;       


    // helper linked list class
    private class Node {
        T element;
        Node next;
    }

    public LinkedStack(){
        top =null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T element) {
        Node oldTop = top;
        top = new Node();
        top.element = element;
        top.next = oldTop;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new StackEmptyException();
        T element = top.element;
        top = top.next;
        size--;
        return element;
    }


    public T top() {
        if (isEmpty()) throw new StackEmptyException();
        return top.element;
    }


}



