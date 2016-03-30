import java.util.*;
public class Driver {
    public static void main(String[]args){
	MyStack<String> ms = new MyStack<String>();
	Stack<String> s = new Stack<String>();
	MyQueue<String> mq = new MyQueue<String>();
	Queue<String> q = new Queue<String>();
	try{ 
	    mq.dequeue();
      	}catch(NoSuchElementException e){
	    System.out.println("Pass 1");
	}
	try{ 
	    q.dequeue();
      	}catch(NoSuchElementException e){
	    System.out.println("Pass 2");
	}

	try{ 
	    ms.pop();
      	}catch(NoSuchElementException e){
	    System.out.println("Pass 3");
	}
	try{ 
	    s.pop();
      	}catch(NoSuchElementException e){
	    System.out.println("Pass 4");
	}
	try{ 
	    ms.peek();
      	}catch(NoSuchElementException e){
	    System.out.println("Pass 5");
	}
	try{ 
	    s.peek();
      	}catch(NoSuchElementException e){
	    System.out.println("Pass 6");
	}


	Random r = new Random(1000);
	for(int i=0;i<100000;i++){
	    int one = r.nextInt(5000);
	    ms.push(one+"");
	    s.push(one+"");
	    int two = r.nextInt(5000);
	    mq.enqueue(two+"");
	    q.enqueue(two+"");
	}
	
	System.out.println(ms.isEmpty());
	System.out.println(s.isEmpty());
	System.out.println(mq.isEmpty());
	System.out.println(q.isEmpty());
	
	int n = r.nextInt(100000);
	
	for(int i=0;i<n;i++){
	    if(ms.pop()!=s.pop()){
		System.out.println("Bad Match");
		System.exit();
	    }
	    if(mq.dequeue()!=q.dequeue()){
		System.out.println("Bad Match");
		System.exit();
	    }
	}

	
	
    }
}
