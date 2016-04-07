import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyDeque<String> one = new MyDeque<String>();
	//Deque<String> two = new Deque<String>();
	
	try{
	    one.getFirst();
	    System.out.println("You done goofed");
	}catch(Exception e){
	    System.out.println("Well Done!");
	    //e.printStackTrace();
	}
	try{
	    one.getLast();
	    System.out.println("You done goofed");
	}catch(Exception e){
	    //e.printStackTrace();
	}
	try{
	    one.removeFirst();
	    System.out.println("You done goofed");
	}catch(Exception e){
	    //e.printStackTrace();
	}
	try{
	    one.removeLast();
	    System.out.println("You done goofed");
	}catch(Exception e){
	    //e.printStackTrace();
	}
	/*
	System.out.println(one);
	one.addFirst("Start");
	System.out.println(one);
	one.removeLast();
	System.out.println(one);
	*/

	
	Random r = new Random();
        for(int i = 0;i<20;i++){
	    int op = r.nextInt(2);
	    if(op == 0){
		one.addFirst(""+r.nextInt(400));
	    }else{
		one.addLast(""+r.nextInt(400));
	    }
	    //
	}

	//System.out.println(one);
	
	
	int counter = 0;
 	while(one.getSize()!= 0 && counter < 1000){
	    int op = r.nextInt(6);
	    if(op == 0){
		one.addFirst(""+r.nextInt(400));
	    }else if(op == 1){
		one.addLast(""+r.nextInt(400));
	    }else if(op == 2){
		one.removeFirst();
	    }else if(op == 3){
		one.removeLast();
	    }else if(op == 4){
		one.getFirst();
	    }else if(op == 5){
		one.getLast();
	    }
	    counter++;
	}
	System.out.println(one);
	System.out.println("Finished~!");
	
    }
    

}
