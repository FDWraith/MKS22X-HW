public class QueenBoard{
    private int[][]array;
    private boolean solved;
    
    //Constructors
    /*public QueenBoard(){
	QueenBoard(8);
	}*/
    public QueenBoard(int n){
	array = new int[n][n];
	resetBoard();
    }

    //Methods
    public boolean solve(){
	solved = solveHelper(0);
	return solved;
    }
    public boolean solveHelper(int col){
	boolean det = false;
	if(col == array.length){
	    for(int i =0;i<array.length;i++){
		if(array[i][col-1]==1){
		    System.out.println("here");
		    return true;
		}
	    }
	    return false;
	}else{
	    for(int i =0;i<array.length;i++){
		//System.out.println(this);
		//System.out.println(i+","+col);
		if(placeQueen(i,col)){
		    det = solveHelper(col+1) || det;
		    if(det){
			return true;
		    }else{
			//System.out.println("Backtracked");
			removeQueen(i,col);
		    }
		}
	    }
	    return det;
	}
	
    }

    //ToString
    public String toString(){
	String end = "";
	for(int i = 0; i < array.length; i++){
	    for(int j =0; j < array.length;j++){
		end += " "+array[i][j]+" ";
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
	String end = "";
	    for(int i =0;i<array.length;i++){
		for(int j = 0;j<array[i].length;j++){
		    if(array[i][j] == 1){
			end += " Q ";
		    }else{
			end += " _ ";
		    }
		}
		end += "\n";
	    }
	System.out.println(end);
	
    }

    //Mutator
    public boolean placeQueen(int x, int y){
	if(array[x][y] != 0 ){
	    //System.out.println("cant "+x+" "+y);
	    return false;
	}else{
	    array[x][y] = 1;
	    adjustBoard(x,y,"place");
	    return true;
	}
    }

    public boolean removeQueen(int x, int y){
	if(array[x][y] != 1){
	    return false;
	}else{
	    array[x][y] = 0;
	    adjustBoard(x,y,"remove");
	    return true;
	}
    }

    public boolean adjustBoard(int x, int y, String reason){
	int change = 0;
	if(reason.equals("place")){
	    change = 1;
	}else if(reason.equals("remove")){
	    change = -1;
	}
	int adj = 1;
	while(y+adj < array[0].length){
	    if(x+adj < array.length){
		array[x+adj][y+adj] -= change;
	    }
	    array[x][y+adj] -= change;
	    if(x-adj >= 0){
		array[x-adj][y+adj] -= change;
	    }
	    adj += 1;
	}
	return true;
    }

    public boolean resetBoard(){
	for(int i =0;i<array.length;i++){
	    for(int j=0;j<array[i].length;j++){
		array[i][j]=0;
	    }
	}
	return true;
    }

    
    
    
}
