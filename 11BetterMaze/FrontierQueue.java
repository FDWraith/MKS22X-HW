public class FrontierQueue<T> implements Frontier<T>{
    private MyDeque<T> queue;    
    
    public FrontierQueue(){
	queue = new MyDeque<T>();
    }
    public void add(T element){
	queue.addFirst(element);
    }
    public T next(){
	return queue.removeLast();
    }
    public boolean hasNext(){
	return queue.getLast()!=null;
    }
    
}
