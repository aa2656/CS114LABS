import java.util.Iterator;

public class SortedList_LinkedList {
    public static void main(String[] args){
        SortedList<Integer> intList = new SortedList<Integer>();
        for(int i = 0; i <10;i++){
            intList.insert(i);
        }
        for(int i = 0; i<10;i++){
            System.out.println(intList.retrieve(i));
        }
        for(int i = 0; i<10; i++){
            intList.remove(i);
        }
        System.out.println(intList.retrieve(0));
    }
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
    private void insertHelper(Node<E> node,Node<E> pointer){//if before head, if after head, before and after node
        if(head == null){//is list is empty
            head = node;
        }else if(node.data.compareTo(head.data)<0){//if node is less than head
            node.next = head;
            head = node;
        }else if(pointer.next == null){//if your at the end of the list
            node.next = null;
            pointer.next = node;
        }else if(node.data.compareTo(pointer.next.data)<0){
            node.next = pointer.next;
            pointer.next = node;
        }else{
            pointer = pointer.next;
            insertHelper(node, pointer);
        }
    }

    public void remove(E data){
        Node<E> pointer = head;
        removeHelper(data, pointer);
    }
    private void removeHelper(E data, Node<E> pointer){
        if(pointer.next == data){
            pointer.next = pointer.next.next;
        }else if(head.data == data){//this is a special case for the first node
            head = head.next;
        }else{
            removeHelper(data, pointer);
        }
    }

    public E retrieve(int index){
        Node<E> pointer = head;
        return retrieveHelper(index, 0, pointer);
    }
    private E retrieveHelper(int index, int i, Node<E> pointer){
        if(pointer == null){//returns null if object not in linked list
            return null;
        }else if(index == i){
            return pointer.data;
        }else {
            pointer=pointer.next;
            return retrieveHelper(index, ++i, pointer);
        }
    }

    public boolean search(E data){
        Node<E> pointer = head;
        return searchHelper(data, pointer);
    }
    private boolean searchHelper(E data, Node<E> pointer){
        if(pointer.data == data){
            return true;
        }else if(pointer.next == null){
            return false;
        }else{
            pointer=pointer.next;
            searchHelper(data, pointer);
        }
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }
}