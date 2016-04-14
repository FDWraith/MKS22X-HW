import java.util.*;
public class Driver{
    public static void main(String[]args){
        BetterMaze test = new BetterMaze("data2.dat");
	test.setAnimate(false);
	if(args.length == 0){
	    test.solveDFS();
	}else{
	    test.solveBFS();
	}
	System.out.println(Arrays.toString(test.solutionCoordinates()));
	
    }
}
