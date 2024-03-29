import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new ALStack<>();
        for(int i=0;i<11;i++){
            stack.push(i);
        }

        for(int i=0; i <11;++i){
            System.out.println(stack.pop());
        }
    }
}

interface Stack<E> extends Iterable<E>{
    E pop();
    void push(E data);
}

class ALStack<E> implements Stack<E> {
    private ArrayList<E> stack = new ArrayList<E>();
    private int top;

    public E pop(){
        E temp = null;
        if(top > 0) {
            temp = stack.get(--top);
            stack.remove(top);

            return temp;
        }
        return temp;
    }

    public void push(E data){
        stack.add(data);
        top++;
    }

    public Iterator<E> iterator(){

        return stack.iterator();
    }
}