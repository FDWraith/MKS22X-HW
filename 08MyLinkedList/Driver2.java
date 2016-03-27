public class Driver2{
    public static void main(String[]args){
	MyLinkedList<String> n = new MyLinkedList<>();
	for(int i = 0;i<20;i++){
	    n.add(i+"");
	}
	System.out.println(n);
	System.out.println(n.toStringDebug());
	n.remove(0);
	System.out.println(n);
	System.out.println(n.toStringDebug());
	n.remove(n.size()-1);
	System.out.println(n);
	System.out.println(n.toStringDebug());
	n.add(0,"hello");
	System.out.println(n);
	System.out.println(n.toStringDebug());
	n.add(3,"this");
	System.out.println(n);
	System.out.println(n.toStringDebug());
	n.remove(3);
	System.out.println(n);
	System.out.println(n.toStringDebug());
	
    }

    
}
