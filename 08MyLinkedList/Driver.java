public class Driver{
    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	System.out.println(a);
	a.add(1);
	System.out.println(a);
	a.add(12);
	System.out.println(a);
	System.out.println(a.size());
	a.set(0,12);
	System.out.println(a);
	a.set(2,12);
	System.out.println(a);
    }
}
