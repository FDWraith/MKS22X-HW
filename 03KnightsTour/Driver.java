public class Driver{

    public static void main(String[]args){
	KnightsBoard n = new KnightsBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	n.solve();
	n.printSolution();
    }
    
}
