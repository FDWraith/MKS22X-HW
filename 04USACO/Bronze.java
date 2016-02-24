import java.util.Scanner;
import java.io.*;

public class Bronze {
    private int[][] array;
    private int depth;
    private int[][] commands;
    private int[][] delta = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,0}, {0,1}, {1,-1}, {1,0}, {1,1} };

    public Bronze(int row, int col, int dep, int[][]given,int[][] digs){
	array = new int[row][col];
	depth = dep;
	for(int i =0;i<array.length;i++){
	    for(int j =0;j<array[i].length;j++){
		array[i][j] = given[i][j];
	    }
	}
	commands = digs;
    }

    public String go(){
	this.executeStompingCommands();
	int n = this.calculateVolume();
	return n +",6,Zhang,Kevin";
    }
    
    public int calculateVolume(){
	int sum = 0;
	for(int i = 0;i<array.length;i++){
	    for(int j =0;j<array[i].length;j++){
		if(array[i][j] < depth){
		    sum += (depth - array[i][j]);
		}
	    }
	}
	return sum * 72 * 72;
    }
    
    public void executeStompingCommands(){
	for(int i =0;i<commands.length;i++){
	    executeStomp(commands[i][0],commands[i][1],commands[i][2]);
	}
    }
    public void executeStomp(int row, int col, int elev){
	int maxEv = 0;
	for(int i = 0;i<delta.length;i++){
	    maxEv =  Math.max(maxEv,array[row+delta[i][0]][col+delta[i][1]]);
	}//determine maxValue
	int finEv = maxEv - elev;//
	for(int i = 0;i<delta.length;i++){
	    if(array[row+delta[i][0]][col+delta[i][1]] > finEv){
		//if the elevation of spot is greater than finalElevation then that spot will become final Elevation
		array[row+delta[i][0]][col+delta[i][1]] = finEv;
	    }
	}
    }

    public static void main(String[]args){
	try{
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    Scanner first = new Scanner(in.nextLine());
	    int r = first.nextInt();
	    int c = first.nextInt();
	    int e = first.nextInt();
	    int numOfStomp = first.nextInt();
	    
	    int[][]ar1 = new int[r][c];
	    for(int i=0;i<r;i++){
		Scanner n1 = new Scanner(in.nextLine());
		for(int j=0;j<c;j++){
		    ar1[i][j] = n1.nextInt();
		}
	    }
	    
	    int[][]ar2 = new int[numOfStomp][3];
	    for(int i=0;i<numOfStomp;i++){
		Scanner n2 = new Scanner(in.nextLine());
		ar2[i][0] = n2.nextInt();
		ar2[i][1] = n2.nextInt();
		ar2[i][2] = n2.nextInt();
	    }

	    Bronze p = new Bronze(r,c,e,ar1,ar2);
	    System.out.println(p.go());
	
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found!!!!");
	    return;
	}
	
	
    }


}
