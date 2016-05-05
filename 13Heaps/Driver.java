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
	test.remove();
	System.out.println(test);
	System.out.println(test.peek());
    }
    
}
