import java.io.*;
import java.util.*;
public class Silver {
    private int[][]board1;
    private int[][]board2;
    private int len;
    private int startX,startY,endX,endY;
    private static final boolean DEBUG = true;
    
    public Silver(String txt){
	try{
	    File f = new File(txt);
	    Scanner in = new Scanner(f);
	    Scanner first = new Scanner(in.nextLine());
	    int r = first.nextInt();
	    int c = first.nextInt();
	    len = first.nextInt();
	    board1 = new int[r][c];
	    board2= new int[r][c];
	    for(int i =0;i<board1.length;i++){
		String n = in.nextLine();
		for(int j=0;j<board1[i].length;j++){
		    if(n.charAt(j) == '.'){
			board1[i][j] = 0;
		    }else if(n.charAt(j) == '*'){
			board1[i][j] = -1;
		    }
		}
	    } 
	    startX = in.nextInt()-1;
	    startY = in.nextInt()-1;
	    endX = in.nextInt()-1;
	    endY = in.nextInt()-1;
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }

    public String toString(){
	String end = "";
	for(int i=0;i<board1.length;i++){
	    for(int j=0;j<board1[i].length;j++){
		end += board1[i][j]+" ";
	    }
	    end += "\n";
	}
	return end;
    }

    public void update(){
	for(int i=0;i<board1.length;i++){
	    for(int j=0;j<board1[i].length;j++){
		int sum = 0;
		if(i-1 >= 0 && board1[i-1][j]!=-1){
		    sum += board1[i-1][j];
		}
		if(j-1 >= 0 && board1[i][j-1]!=-1){
		    sum += board1[i][j-1];
		}
		if(i+1 < board1.length && board1[i+1][j]!=-1){
		    sum += board1[i+1][j];
		}
		if(j+1 < board1[i].length && board1[i][j+1]!=-1){
		    sum += board1[i][j+1];
		}
		
		if(board1[i][j]!=-1){
		    board2[i][j] = sum;
		}else{
		    board2[i][j] = -1;
		}
	    }
	}//First for loop to calculate values
	for(int i =0;i<board1.length;i++){
	    for(int j=0;j<board1[i].length;j++){
		board1[i][j] = board2[i][j];
	    }
	}//Second for loop is to copy values over
	if(DEBUG){
	    System.out.println(this);
	}
    }

    public int calcAnswer(){
	//Initialize the first move(when k =0)

	board1[startX][startY]=1;

	//Loop for k-iterations, updating each time

	for(int i=0;i<len;i++){
	    update();
	}

	//Extract answer from place on board.

	return board1[endX][endY];
    }

    public void printSolution(){
	System.out.println(calcAnswer()+",6,Zhang,Kevin");
    }

    public static void main(String[]args){
	Silver test = new Silver("ctravel.in");
	System.out.println(test);
	test.printSolution();
    }
}
