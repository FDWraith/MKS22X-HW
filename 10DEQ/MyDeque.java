import java.util.*;

public class MyDeque<T> {
    private int size,start,end;
    private Object[]ary;

    public MyDeque(){
	ary = new Object[10];
    }

    public MyDeque(int s){
	ary = new Object[s];
    }

    public String toString(){
	return Arrays.toString(ary) + "Start: "+start+ " End: "+end+ " Size: "+size;
    }

    private void grow(){
        Object[]nw = new Object[ary.length*2];
	int store = size;
	for(int i =0;i<size;i++){
	    nw[i] = (Object)(this.removeFirst());
	}
	ary = nw;
	start =0;
	end = store-1;
    }

    public T removeFirst(){
	return null;
    }
    public T removeLast(){
	return null;
    }
    public void addFirst(T value){
	
    }
    public void addLast(T value){
	
    }
    public T getFirst(){
	return null;
    }
    public T getLast(){
	return null;
    }
    
}
