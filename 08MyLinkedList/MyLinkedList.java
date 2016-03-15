public class MyLinkedList {
    private LNode start;
    private int size;

    private class LNode{
	private int value;
	private LNode next;
	
	private LNode(int n){
	    setValue(n);
	}
	private LNode(){
	    this(0);
	}

	private void setValue(int n){
	    value = n;
	}
	private void setNext(LNode n){
	    next = n;
	}
	private int getValue(){
	    return value;
	}
	private LNode getNext(){
	    return next;
	}
    }

    public MyLinkedList(){
	size = 0;
    }
    public MyLinkedList(int n){
	start = new LNode(n);
	size = 1;
    }
    
    public int get(int index){
	if(start == null || index >= size){
	    return -1;
	}
	LNode temp = start;
	int counter =0;
	while(counter!=index){
	    temp = temp.getNext();
	    counter++;
	}
	return temp.getValue();
    }
    
    public int set(int index, int newValue){
	if(start == null || index >= size){
	    throw(new IndexOutOfBoundsException());
	}
	LNode temp = start;
	int counter =0;
	while(counter!=index){
	    temp = temp.getNext();
	    counter++;
	}
	int store = temp.getValue();
	temp.setValue(newValue);
	return store;
    }

    public int size(){
	return size;
    }

    public boolean add(int value){
	if(start == null){
	    start = new LNode(value);
	    size++;
	    return true;
	}else{
	    LNode temp = start;
	    while(temp.getNext()!=null){
		temp = temp.getNext();
	    }
	    temp.setNext(new LNode(value));
	    size++;
	    return true;
	}
    }

    public String toString(){
	if(start == null){
	    return "[]";
	}else{
	    String end = "[";
	    LNode temp = start;
	    while(temp!=null){
		end += temp.getValue()+",";
		temp=temp.getNext();
	    }
	    end = end.substring(0,end.length()-1);
	    end += "]";
	    return end;
	}	
    }

    public int remove(int index){
	if(start == null || index >= size){
	    throw(new IndexOutOfBoundsException("Stop giving me bad indexes"));
	}
	LNode temp = start;
	int counter =0;
	while(counter!=index){
	    temp = temp.getNext();
	    counter++;
	}
	int store = temp.getValue();
	if(index == size - 1){
	    temp.setNext(null);
	}else{
	    temp.setNext(temp.getNext());
	}
	return store;
    }

    

}
