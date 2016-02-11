public class Driver{

    public static void main(String[]args){
	QueenBoard b = new QueenBoard(Integer.parseInt(args[0]));
	b.solve();
        b.printSolution();
    }
    
}
