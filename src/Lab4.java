import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        Queue<Integer> queue = new ALQueue<>();
        for(int i=0;i<11;i++){
            queue.enqueue(i);
        }
        for(int i=0; i <11;++i){
            System.out.println(queue.dequeue());
        }


    }

}

interface Queue<E> extends Iterable<E>{
    E dequeue();
    void enqueue(E data);
}


class ALQueue<E> implements Queue<E> {
    private ArrayList<E> queue = new ArrayList<E>();
    private int top;

    public E dequeue(){
        E temp = null;
        if(top > 0) {
            temp = queue.get(0);
            queue.remove(0);
            top--;
            return temp;
        }
        return temp;
    }

    public void enqueue(E data){
        queue.add(data);
        top++;
    }

    public Iterator<E> iterator(){
        return queue.iterator();
    }

}