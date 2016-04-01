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
        T v = (T)(ary[start]);
	if(start == ary.length-1){
	    start = 0;
	}else{
	    start++;
	}
	size--;
	return v;
    }
    public T removeLast(){
	T v = (T)(ary[end]);
	if(end == 0){
	    end = ary.length-1;
	}else{
	    end--;
	}
	size--;
	return v;
    }
    public void addFirst(T value){
	
    }
    public void addLast(T value){
	
    }
    public T getFirst(){
	return (T)(ary[start]);
    }
    public T getLast(){
	return (T)(ary[end]);
    }
    
}
