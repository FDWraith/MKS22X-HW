public class KnightsBoard{
    private int[][] board;
    private boolean solved;


    //Constructors
    public KnightsBoard(){
	this(8);
    }

    public KnightsBoard(int n){
	board = new int[n+4][n+4];
	resetBoard();
    }

    //Methods

    public boolean solve(){
	solved = false;
	for(int i = 2;i<board.length -2;i++){
	    for(int j =2;j<board.length -2;j++){
		if(solveHelper(i,j,1)){
		    solved = true;
		    return solved;
		}
	    }
	}
	return solved;
    }
    public boolean solveHelper(int row, int col, int num){
        if(num == Math.pow(board.length-4,2) + 1){
	    if(board[row][col] == 1){
		return true;	       
	    }else{
		return false; 
	    }	    
	}
	if(row < 2 || col < 2 || row >= board.length - 2 || col >= board.length -2){
	    return false;
	}else{
	    //Manual bashing, but might try automatic solution?
	    boolean det = false;
	    //System.out.println(this);
	    //System.out.println((row-2) + "," + (col-2));
	    //System.out.println(num);
	    
	    if(placeKnight(row,col,num)){
		det = det ||
		    solveHelper(row + 2,col+1,num+1) ||
		    solveHelper(row + 2,col-1,num+1) ||
		    solveHelper(row - 2,col+1,num+1) ||
		    solveHelper(row - 2,col-1,num+1) ||
		    solveHelper(row + 1,col+2,num+1) ||
		    solveHelper(row + 1,col-2,num+1) ||
		    solveHelper(row - 1,col+2,num+1) ||
		    solveHelper(row - 1,col+2,num+1);
		if(!det){
		    removeKnight(row,col,num);
		}else{
		    return true;
		}
	    }
	}
	return false;
    }

    //Printing

    public String toString(){
	String end ="";
	for(int i =2; i<board.length-2;i++){
	    for(int j =2;j<board.length-2;j++){
		end += " "+board[i][j]+" ";
	    }
	    end += "\n";
	}
	return end;
    }

    public void printSolution(){
	if(!solved){
	    resetBoard();
	    System.out.println("No Solution");
	}
        String end ="";
	for(int i =0;i<board.length;i++){
	    for(int j =0;j<board.length;j++){
		if(board[i][j]>0){
		    end += " "+board[i][j]+" ";
		}
	    }
	    end += "\n";
	}
	System.out.println(end);
    }
    
    //Mutator
    public void resetBoard(){
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		if(i < 2 || i >= board.length -2){
		    board[i][j] = -1;
		}else if(j < 2 || j >= board.length -2){
		    board[i][j] = -1;
		}else{
		    board[i][j] = 0;
		}
	    }
	}
    }

    public boolean placeKnight(int row, int col, int num){
	if(board[row][col]==-1 || board[row][col]!= 0){
	    return false;
	}else{
	    board[row][col] = num;
	    return true;
	}
    }

    public boolean removeKnight(int row, int col, int num){
	if(board[row][col] <= 0 ){
	    return false;
	}else{
	    board[row][col] = 0;
	    return true;
	}
    }
    
    
}
