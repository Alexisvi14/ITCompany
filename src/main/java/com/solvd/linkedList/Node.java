package com.solvd.linkedList;


public class Node <E>{
    private Node <E> next;
    private Node <E> previous;
    private E data;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    @Override
    public String toString(){
        return data.toString();
    }
}

