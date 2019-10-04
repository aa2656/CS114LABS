import java.util.Iterator;

public class SortedList_LinkedList {

}

abstract class List<E> implements Iterable<E> {

    protected class Node<T> {

        protected Node(T data) {
            this.data = data;
        }

        protected T data;
        protected Node<T> next;
    }

    public abstract void insert(E data);
    public abstract void remove(E data);
    public abstract E retrieve(int index);
    public abstract boolean search(E data);

    protected Node<E> head;
}

class SortedList<E extends Comparable<? super E>> extends List<E> {

    public void insert(E data){
        Node<E> temp = new Node<E>(data);
        Node<E> pointer = head;
        insertHelper(temp,pointer);
    }
    public void insertHelper(Node<E> node,Node<E> pointer){
        if(head.data == null || node.data.compareTo(head.data) < 0){
            node.next = head;
            head = node;
        }else{
            pointer=pointer.next;
            insertHelper(node,pointer);
        }
    }

    public void remove(E data){
        Node<E> pointer = head;
        removeHelper(data, pointer);
    }
    public void removeHelper(E data, Node<E> pointer){
        if(pointer.next == data){
            pointer.next = pointer.next.next;
        }else{
            removeHelper(data, pointer);
        }
    }

    public E retrieve(int index){
        Node<E> pointer = head;
        return retrieveHelper(index, 0, pointer);
    }
    public E retrieveHelper(int index, int i, Node<E> pointer){
        if(index == i){
            return pointer.data;
        }else{
            pointer=pointer.next;
            retrieveHelper(index, ++i, pointer);
        }
    }

    public boolean search(E data){

    }
    public void seachHelper(E data, Node<E> pointer){
        if(pointer.next == data){
            pointer.next = pointer.next.next;
        }else{
            removeHelper(data, pointer);
        }
    }



    public Iterator<E> iterator() {
        return null;
    }
}