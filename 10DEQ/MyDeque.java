import java.util.*;

public class MyDeque<T> {
    private int size,start,end;
    private T[]ary;

    public MyDeque(){
	this(10);
    }

    public MyDeque(int s){
	ary = (T[])( new Object[s]);
    }

    public String toString(){
	return Arrays.toString(ary) + "Start: "+start+ " End: "+end+ " Size: "+size;
    }

    public int getSize(){
	return size;
    }

    private void grow(){
        T[]nw = (T[])(new Object[ary.length*2]);
	int store = size;
	for(int i =0;i<store;i++){
	    nw[i] = this.removeFirst();
	}
	
	ary = nw;
	start =0;
	end = store-1;
	size = store;
    }

    public T removeFirst(){
	if(size == 0){
	    throw new IndexOutOfBoundsException("Size is zero");
	}
        T v = ary[start];
	ary[start]=null;
	if(end!= start){
	    if(start == ary.length-1){	    
		start = 0;
	    }else{
		start++;
	    }
	}
	size--;
	return v;
    }
    public T removeLast(){
	if(size == 0){
	    throw new IndexOutOfBoundsException("Size is zero");
	}
	T v = ary[end];
	ary[end]=null;
	if(end != start){
	    if(end == 0){
		end = ary.length-1;
	    }else{
		end--;
	    }
	}
	size--;
	return v;
    }
    public void addFirst(T value){
	if(size==0){
	    ary[start] = value;
	    size++;
	    return;
	}
	if(size >= ary.length){
	    grow();
	}
	if(start == 0){
	    ary[ary.length-1] = value;
	    start=ary.length-1;
	}else{
	    ary[start-1] = value;
	    start--;
	}
	size++;
    }
    public void addLast(T value){
	if(size==0){
	    ary[start] = value;
	    size++;
	    return;
	}
	if(size >= ary.length){
	    grow();
	}
	if(end == ary.length-1){
	    ary[0] = value;
	    end = 0;
	}else{
	    ary[end+1] = value;
	    end++;
	}
	size++;
    }
    public T getFirst(){
	if(size == 0){
	    throw new IndexOutOfBoundsException("Size is zero");
	}
	return ary[start];
    }
    public T getLast(){
	if(size == 0){
	    throw new IndexOutOfBoundsException("Size is zero");
	}
	return ary[end];
    }
    
}
