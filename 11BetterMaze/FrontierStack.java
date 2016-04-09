public class FrontierStack<T> implements Frontier<T>{
    private MyDeque<T> stack;

    public FrontierStack(){
	stack = new MyDeque<T>();
    }    
    public void add(T element){
	stack.addFirst(element);
    }
    public T next(){
	return stack.removeFirst();
    }
    public boolean hasNext(){
	return stack.getFirst() != null;
    }
    
}
