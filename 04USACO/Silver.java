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
		    board1[i][j] = n.nextInt();
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
	return calcAnswer()+"6,Zhang,Kevin";
    }

}
