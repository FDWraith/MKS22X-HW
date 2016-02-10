public class QueenBoard{
    private int[][]array;
    
    //Constructors
    public QueenBoard(){
	QueenBoard(8);
    }
    public QueenBoard(int n){
	array = new int[n][n];
	resetBoard();
    }

    //Methods
    public boolean solve(){
	return solveHelper(0);
    }
    public boolean solveHelper(int col){
	boolean det = false;
        if(col >= array[0].length()){
	    return false;
	}else{
	    for(int i = 0;i< array.length;i++){
		placeQueen(i,col);
		det = det || solveHelper(col + 1);
		removeQueen(i,col);
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
	    end += "/n";
	}
	return end;
    }
    

    //Mutator
    public boolean placeQueen(int x, int y){
	if(array[x][y] != 0 ){
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
	while(y+adj < array[x+adj].length){
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
