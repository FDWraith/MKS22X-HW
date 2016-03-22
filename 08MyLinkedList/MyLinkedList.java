public class MyLinkedList<T>{
    private LNode start,end;
    private int size;

    private class LNode<T>{
	private T value;
	private LNode next;
	
	private LNode(T t){
	    setValue(t);
	}
	private void setValue(T t){
	    value = t;
	}
	private void setNext(LNode n){
	    next = n;
	}
	private T getValue(){
	    return value;
	}
	private LNode getNext(){
	    return next;
	}
    }

    public MyLinkedList(){
	size = 0;
    }
    public MyLinkedList(T n){
	start = new LNode<T>(n);
	end = start;
	size = 1;
    }
    
    public T get(int index){
	if(start == null || index >= size || index < 0){
	    return null;
	}
	LNode<T> temp = start;
	int counter =0;
	while(counter!=index){
	    temp = temp.getNext();
	    counter++;
	}
	return temp.getValue();
    }
    
    public T set(int index, T newValue){
	if(start == null || index >= size || index < 0){
	    throw(new IndexOutOfBoundsException());
	}
	LNode<T> temp = start;
	int counter =0;
	while(counter!=index){
	    temp = temp.getNext();
	    counter++;
	}
	T store = temp.getValue();
	temp.setValue(newValue);
	return store;
    }

    public int size(){
	return size;
    }

    public boolean add(T value){
	LNode<T> temp = new LNode<T>(value);
	end.setNext(temp);
	end = temp;
	size++;
	return true;
    }

    public boolean add(int index,T value){
	if(index > size || index < 0){
	    throw(new IndexOutOfBoundsException("Stop giving me bad indexes"));
	}
	if(index == size){
	    this.add(value);
	    return true;
	}
	if(index == 0){
	    LNode<T> store = start;
	    start = new LNode<T>(value);
	    start.setNext(store);
	    size++;
	    return true;
	}
	int counter = 0;
	LNode<T> temp = start;
	while(counter != index){
	    temp=temp.getNext();
	    counter++;
	}
	LNode<T> insert = new LNode<T>(value);
	LNode<T> store = temp.getNext();
	temp.setNext(insert);
	insert.setNext(store);
	size++;
	return true;
    }

    public String toString(){
	if(start == null){
	    return "[]";
	}else{
	    String end = "[";
	    LNode temp = start;
	    while(temp!=null){
		end += temp.getValue()+",";
		temp = temp.getNext();
	    }
	    end = end.substring(0,end.length()-1);
	    end += "]";
	    return end;
	}	
    }

    public T remove(int index){
	if(start == null || index >= size || index < 0){
	    throw(new IndexOutOfBoundsException("Stop giving me bad indexes"));
	}
	if(index == 0){
	    LNode store = start.getNext();
	    start.setNext(null);
	    T info = start.getValue();
	    start = store;
	    size--;
	    return info;	    
	}
	LNode temp = start;
	int counter =0;
	while(counter!=index-1){
	    temp = temp.getNext();
	    counter++;
	}
	T store = temp.getNext().getValue();
	if(temp.getNext()!= null){
	    temp.setNext(temp.getNext().getNext());
	}else{
	    end = temp;
	}
	size--;
	return store;
    }

    public int indexOf(T value){
	LNode temp = start;
	int counter =0;
	while(temp!=null){
	    if(temp.getValue().equals(value)){
		return counter;
	    }
	    counter++;
	    temp = temp.getNext();
	}
	return -1;
    }

    public String toStringDebug(){
	String end = "";
	end += "HEAD:"+start.getValue();
	end += " TAIL:"+this.end.getValue();
	return end;
    }
    

}
