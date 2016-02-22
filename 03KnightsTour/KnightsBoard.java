public class KnightsBoard{
    private int[][] board;
    private boolean solved;


    //Constructors
    public KnightsBoard(){
	this(8);
    }

    public KnightsBoard(int n){
	this(n,n);
    }

    public KnightsBoard(int row, int col){
	board = new int[row+4][col+4];
	resetBoard();
    }

    //Methods

    public boolean solve(){
	solved = false;
	for(int i = 2;i<board.length -2;i++){
	    for(int j =2;j<board[0].length -2;j++){
		if(solveHelper(i,j,1)){
		    solved = true;
		    return solved;
		}
	    }
	}
	return solved;
    }
    public boolean solveHelper(int row, int col, int num){
        if(num == ((board.length -4) * (board[0].length -4))){
	    if(placeKnight(row,col,num)){
		return true;
	    }
	}
	if(row < 2 || col < 2 || row >= board.length - 2 || col >= board[0].length -2){
	    return false;
	}else{
	    //Manual bashing, but might try automatic solution?
	    boolean det = false;
	    //System.out.println(num);
	    //System.out.println(this);
	    //System.out.println((row-2) + "," + (col-2));
	    
	    if(placeKnight(row,col,num)){
		det = det ||
		    solveHelper(row + 2,col+1,num+1) ||
		    solveHelper(row + 2,col-1,num+1) ||
		    solveHelper(row - 2,col+1,num+1) ||
		    solveHelper(row - 2,col-1,num+1) ||
		    solveHelper(row + 1,col+2,num+1) ||
		    solveHelper(row + 1,col-2,num+1) ||
		    solveHelper(row - 1,col+2,num+1) ||
		    solveHelper(row - 1,col-2,num+1);
		if(det){
		    return true;
		}else{
		    removeKnight(row,col,num);
		}
	    }else{
		return false;
	    }
	}
	return false;
    }

    //Printing

    public String toString(){
	String end ="";
	for(int i =2; i<board.length-2;i++){
	    for(int j =2;j<board[0].length-2;j++){
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
	for(int i =2;i<board.length-2;i++){
	    for(int j =2;j<board[0].length-2;j++){
		if(board[i][j]==0){
		    end += " _ ";
		}else{
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
	    for(int j=0;j<board[0].length;j++){
		if(i < 2 || i >= board.length -2){
		    board[i][j] = -1;
		}else if(j < 2 || j >= board[0].length-2){
		    board[i][j] = -1;
		}else{
		    board[i][j] = 0;
		}
	    }
	}
    }

    public boolean placeKnight(int row, int col, int num){
	if(board[row][col]!= 0){
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
