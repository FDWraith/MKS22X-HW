import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> data;

    //Constructor
    public MyStack(){
	data = new MyLinkedList<T>();
    }

    public String toString(){
	return data.toString();
    }
    
    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
	data.add(item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if(data.size()==0){
	    throw new NoSuchElementException();
	}
	return data.remove(data.size()-1);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if(data.size()==0){
	    throw new NoSuchElementException();
	}
	return data.get(data.size()-1);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return data.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return data.size()==0;
    }
}
