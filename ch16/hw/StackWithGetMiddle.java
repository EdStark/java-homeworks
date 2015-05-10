package ch16.hw;

import java.util.NoSuchElementException;

/**
 * Created by ikirilov on 08/05/15.
 * Stack with GetMiddle
 */
public class StackWithGetMiddle {
    private Node first, last;
    private int N;

    public StackWithGetMiddle(){
        first=null;
        last=null;

    }
    /*BEGIN NODE CLASS*/
    private static class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data=data;
            next=null;
        }
    }
        /*END NODE CLASS*/

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return N;
    }

    public void push(Object data){
        if(isEmpty()){
            first=new Node(data);
            last=first;
        }
        else if(first==last){
            first=new Node(data);
            first.next=last;
        }
        else{
            Node old_first = first;
            first = new Node(data);
            first.next=old_first;
        }
        N++;
    }

    public Object pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack is empty");
        Object result = first.data;
        first = first.next;
        N--;
        return result;
    }

    public Object getMiddle(){
        Node current=first;
        Node middle = first;
        int length=0;
        while(current.next!=null){
            length++;
            current = current.next;
            if(length%2==0){
                middle = middle.next;
            }
        }
        if(length%2==1)
            middle = middle.next;
        return middle.data;
    }

    public static void main(String[] args) {
        StackWithGetMiddle stack = new StackWithGetMiddle();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println("Size of the stack is :" + stack.size());
        System.out.println("Min of the stack is :" + stack.last.data);
        System.out.println("Middle of the stack is :" + stack.getMiddle());
        System.out.println("Top of the stack is :" + stack.pop());
        System.out.println("Size of the stack is now:" + stack.size());
    }
}
