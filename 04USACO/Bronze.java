import java.util.Scanner;

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
	    maxEv = 
	}
    }


}
