import java.io.*;
import java.util.*;
public class Silver {
    private int[][]board1;
    private int[][]board2;
    private int len;
    private int startX,startY,endX,endY;

    public Silver(String txt){
	try{
	    File f = new File(txt);
	    Scanner in = new Scanner(f);
	    int r = in.nextInt();
	    int c = in.nextInt();
	    len = in.nextInt();
	    board1 = new int[r][c];
	    board2= new int[r][c];
	    for(int i =0;i<board1.length;i++){
		Scanner n = new Scanner(in.nextLine());
		for(int j=0;j<board1.length;j++){
		    if(n.next().equals(".")){
			board1[i][j] = 0;
		    }else if(n.next().equals("*")){
			board1[i][j] = -1;
		    }
		}
	    } 
	    startX = in.nextInt();
	    startY = in.nextInt();
	    endX = in.nextInt();
	    endY = in.nextInt();
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }

    public String toString(){
	return calcAnswer(len)+"6,Zhang,Kevin";
    }

    public void update(){
	for(int i=0;i<board1.length;i++){
	    for(int j=0;j<board1[i].length;j++){
		int sum = 0;
		if(i-1 > 0 && board1[i-1][j]!=-1){
		    sum += board1[i-1][j];
		}
		if(j-1 > 0 && board1[i][j-1]!=-1){
		    sum += board1[i][j-1];
		}
		if(i+1 < board1.length && board1[i+1][j]!=-1){
		    sum += board1[i+1][j];
		}
		if(j+1 < board1[i].length && board1[i][j+1]!=-1){
		    sum += board1[i][j+1];
		}
		board2[i][j] = sum;
	    }
	}//First for loop to calculate values
	for(int i =0;i<board1.length;i++){
	    for(int j=0;j<board1[i].length;j++){
		board1[i][j] = board2[i][j];
	    }
	}//Second for loop is to copy values over	
    }

    public int calcAnswer(int k){
	//Initialize the first move(when k =0)

	board1[startX][startY]=1;

	//Loop for k-iterations, updating each time

	for(int i=0;i<k;i++){
	    update();
	}

	//Extract answer from place on board.

	return board1[endX][endY];
    }

    public static void main(String[]args){
	Silver test = new Silver("ctravel.in");
	System.out.println(test);
    }
}
