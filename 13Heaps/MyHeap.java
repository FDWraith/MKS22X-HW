import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private static boolean isMaxHeap;
    private int size;
    private T[] heap;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean isMax){
	size = 0;
	heap = (T[])(new Comparable[10]);
	isMaxHeap = isMax;
    }
    public MyHeap(T[] input){
	this(input,true);
    }
    public MyHeap(T[] input, boolean isMax){
	isMaxHeap = isMax;
	heapify(input);
    }

    public String toString(){
	String end = "[";
	for(int i =1;i<=size;i++){
	    end+= heap[i]+", ";
	}
	if(end.length() > 1){
	    end = end.substring(0,end.length()-2);
	}
	return end + "]";
    }

    private void heapify(T[] ary){
	heap = (T[])(new Comparable[ary.length+1]);
	size = ary.length;
	System.arraycopy(ary,0,heap,1,ary.length);
	for(int i = size / 2; i > 0; i--){
	    pushDown(i);
	}
    }

    private void pushDown(int index){
	if(index * 2 > size || index <= 0){
	    return;//no children to push down to.
	}else if(index * 2 + 1 > size){
	    if(compare(heap[index * 2],heap[index])){
		swap(index, index *2);
		pushDown(index * 2);
	    }
	}else{
	    T left = heap[index *2];
	    T right = heap[index * 2 + 1];
	    T val = heap[index];
	    if(compare(val,left) && compare(val,right)){
	    }else{
		if(compare(left,right)){
		    swap(index, index *2);
		    pushDown(index * 2);
		}else{
		    swap(index, index * 2 + 1);
		    pushDown(index * 2 + 1);
		}
	    }
	}
    }

    private void pushUp(int index){
	if(index <= 1){
	    return;//fucking plebs
	}else{
	    T parent = heap[index /2];
	    T child = heap[index];
	    if(compare(child,parent)){
		swap(index,index/2);
		pushUp(index/2);
	    }
	}
    }

    private void swap(int index1, int index2){
	T temp = heap[index1];
	heap[index1] = heap[index2];
	heap[index2] = temp;
    }

    private boolean compare(T val1, T val2){
	if(isMaxHeap){
	    return val1.compareTo(val2) >= 0;
	}else{
	    return val1.compareTo(val2) <= 0;
	}
    }

    private void doubleSize(){
	T[] temp = (T[])(new Comparable[heap.length * 2]);
	System.arraycopy(heap,0,temp,0,heap.length);
	heap = temp;
    }

    public void add(T element){
	if(size == heap.length - 1){
	    doubleSize();
	}//conditional start.

	size++;
	heap[size] = element;
	pushUp(size);	
    }

    public T peek(){
	if(size == 0){
	    return null;
	}
	return heap[1];
    }

    public T delete(){
	if(size == 0){
	    return null;
	}
	T temp = heap[1];
	heap[1] = heap[size];
	size--;
	pushDown(1);
	return temp;
    }
	
}
