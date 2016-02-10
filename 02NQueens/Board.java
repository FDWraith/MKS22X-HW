public class Board{
    private int[][]array;
    
    //Constructors
    public Board(){
	Board(8);
    }
    public Board(int n){
	array = new int[n][n];
	resetBoard();
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
	while(x+adj < array.length && y+adj < array[x+adj].length){
	    array[x+adj][y+adj] -= change;
	    array[x][y+adj] -= change;
	    adj++;
	}
	int vertAdj = -1;
	adj =1;//reset adj
	while(x+vertAdj >= 0 && y+adj < array[x+vertAdj].length){
	    array[x+vertAdj][y+adj] -= change;
	    vertAdj -= 1;
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
