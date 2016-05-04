public class Driver{
    public static void main(String[]args){
	BSTree<Integer> test = new BSTree<Integer>();
	System.out.println(test);
	test.add(1);
	System.out.println(test);
	test.add(5);
	System.out.println(test);
	test.add(3);
	System.out.println(test);
	test.add(20);
	System.out.println(test);
	test.add(-1);
	test.add(19);
	test.add(21);
	test.add(-2);
	test.add(-4);
	test.add(-3);
	test.add(0);
	System.out.println(test);
	System.out.println(test.contains(-2));
	System.out.println(test.contains(20));
	test.remove(1);
	System.out.println(test);
    }
}
