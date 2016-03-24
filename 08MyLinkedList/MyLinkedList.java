public class MyLinkedList<T> implements Iterable<T>{
    private LNode start,end;
    private int size;

    private class LNode{
	private T value;
	private LNode next;

	private LNode(){
	    
	}
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

    public class myIterator implements Iterator<T>{
	private LNode current;
	public myIterator(){
	    LNode temp = new LNode();
	    temp.setNext(start);
	    current = temp;
	}
	public boolean hasNext(){
	    if(current.getNext()==null){
		return false;
	    }else{
		return true;
	    }
	}
	public T next(){
	    if(!this.hasNext()){
		throw(new NoSuchElementException());
	    }else{
		current = current.getNext();
		return current.getValue();
	    }
	}
	public void remove(){
	    throw(new UnsupportedOperationException());
	}
    }

    public MyLinkedList(){
	size = 0;
    }
    public MyLinkedList(T n){
	start = new LNode(n);
	end = start;
	size = 1;
    }

    public Iterator<T> iterator(){
	return new myIterator();
    }
    
    public T get(int index){
	if(start == null || index >= size || index < 0){
	    return null;
	}
	LNode temp = start;
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
	LNode temp = start;
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
	LNode temp = new LNode(value);
	if(size == 0){
	    start = temp;
	    end = temp;
	    size++;
	    return true;
	}
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
	    LNode store = start;
	    start = new LNode(value);
	    start.setNext(store);
	    size++;
	    return true;
	}
	int counter = 0;
	LNode temp = start;
	while(counter != index){
	    temp=temp.getNext();
	    counter++;
	}
	LNode insert = new LNode(value);
	LNode store = temp.getNext();
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
	T store;
	if(temp.getNext().getNext() != null){
	    store = temp.getNext().getValue();
	    temp.setNext(temp.getNext().getNext());
	}else{
	    store = temp.getNext().getValue();
	    end = temp;
	    temp.setNext(null);
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
