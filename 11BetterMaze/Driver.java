public class Driver{
    public static void main(String[]args){
        BetterMaze test = new BetterMaze("data2.dat");
	test.setAnimate(true);
	if(args.length == 0){
	    test.solveDFS();
	}else{
	    test.solveBFS();
	}
	
    }
}
