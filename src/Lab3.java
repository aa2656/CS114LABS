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

interface Stack<E>{
    E pop();
    void push(E data);
}


class ALStack<E> implements Stack<E> {
    private ArrayList<E> stack = new ArrayList<E>();
    private int top;

    private class StackIterator<E> implements Iterator<E>{
        public boolean hasNext(){

            return top>0;
        }

        public E next() {

            return (E)stack.get(top);
        }
    }

    public Iterator<E> iterator(){

        return new StackIterator<E>();
    }


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



}