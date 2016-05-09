import java.util.*;

public class Driver{

    public static void main(String[]args){
	MyHeap<Integer> test = new MyHeap<Integer>();
	System.out.println(test);
	test.add(1);
	System.out.println(test);
	test.add(2);
	System.out.println(test);
	test.add(1);
	System.out.println(test);
	test.add(0);
	System.out.println(test);
	test.add(-1);
	System.out.println(test);
	test.add(2);
	System.out.println(test);
	try{
	    test.delete();
	}catch(Exception e){
	    System.out.println("Working");
	}
	System.out.println(test);
	Random r = new Random();	
	for(int i=0;i<1000;i++){
	    test.add(r.nextInt(10)*(r.nextInt(3)-1));
	    if(r.nextInt(2)==0){
		try{
		    test.delete();
		}catch(Exception e){
		    
		}
	    }
	}
	
	System.out.println(test);
	System.out.println(test.peek());
    }
    
}
