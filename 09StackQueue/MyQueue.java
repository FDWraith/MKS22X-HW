import java.util.*;
public class MyQueue<T>{
    private MyLinkedList<T> data; 
    
    //Constructor
    public MyQueue(){
	data = new MyLinkedList<T>();
    }
    
    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
	data.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
	if(data.size()==0){
	    throw new NoSuchElementException();
	}
	return data.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if(data.size()==0){
	    throw new NoSuchElementException();
	}
	return data.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size(){
	return data.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
	return data.size()==0;
    }
}
