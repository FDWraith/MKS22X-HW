public class Driver{
    public static void main(String[]args){
	MyDeque<String> one = new MyDeque<String>();
	//Deque<String> two = new Deque<String>();
	
	try{
	    one.getFirst();
	    System.out.println("You done goofed");
	}catch(Exception e){
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
	
	


    }

}
