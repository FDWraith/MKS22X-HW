import java.util.*;
public class BetterMaze{
    private char[][] maze;
    private int[] solution;
    private int startRow,startCol;
    private int endRow,endCol;
    private Frontier<Coordinate> placesToGo;
    private boolean animate;
    private boolean hasSolution,isSolved;

    private class Coordinate{
	private Coordinate prev;
	private int[] cors;

	public Coordinate(int x, int y){
	    this(x,y,null);
	}
	public Coordinate(int x, int y,Coordinate prev){
	    int[] cors = new int[2];
	    cors[0] = x;
	    cors[1] = y;
	    this.prev = prev;
	}
    
	public int getX(){
	    return cors[0];
	}
	public int getY(){
	    return cors[1];
	}
	public Coordinate getPrev(){
	    return prev;
	}
	public boolean hasPrev(){
	    return prev != null;
	}
    
    }

    public int[] solutionCoordinates(){
	if(!isSolved){
	    solveDFS();//default solve is DFS;
	}
	if(hasSolution){
	    int[] temp = new int[solution.length];
	    System.arraycopy(solution,0,temp,0,solution.length);
	    return temp;
	}else{
	    System.out.println("Solution not found");
	    return null;
	}
    }

    public boolean solveBFS(){
	placesToGo = new FrontierQueue<Coordinate>();	    
	return solve();
    }

    public boolean solveDFS(){
	placesToGo = new FrontierStack<Coordinate>();
	return solve();
    }

    private boolean solve(){
	isSolved = true;//indicate that a solve has been attempted
	Coordinate start = new Coordinate(startRow,startCol);
	placesToGo.add(start);
	while(placesToGo.hasNext()){
	    Coordinate one = placesToGo.next();
	    int[][] surround = getSurroundings(one);
	    for(int i = 0;i<surround.length;i++){
		Coordinate nw = new Coordinate(surround[i][0],surround[i][1],one);
		if(nw.getX() == endRow && nw.getY() == endCol){
		    convertSolution(findPath(nw));
		    hasSolution = true;
		    return true;//terminate;
		}else{
		    placesToGo.add(nw);
		}
	    }
	}
	hasSolution = false;
	return false;
    }

    private int[][] getSurroundings(Coordinate in){
	int[][] checker = { {0,1}, {1,0}, {-1,0}, {0,-1} };
	ArrayList<int[]> end = new ArrayList<int[]>();
	for(int i =0;i<checker.length;i++){
	    int xCor = in.getX()+checker[i][0];
	    int yCor = in.getY()+checker[i][1];
	    if(maze[xCor][yCor] == ' '){
		int[] temp = {xCor,yCor};
		end.add(temp);
	    }
	}
	int[][] result = new int[end.size()][2];
	for(int i =0;i<end.size();i++){
	    result[i][0] = end.get(i)[0];
	    result[i][1] = end.get(i)[1];
	}
	return result;
    }
    
    private MyDeque<Coordinate> findPath(Coordinate end){
        MyDeque<Coordinate> result = new MyDeque<Coordinate>();
	result.addFirst(end);
	Coordinate current = end.getPrev();
	while(current.hasPrev()){
	    result.addFirst(current);
	    current = current.getPrev();
	}
	return result;
    }
	

    public void convertSolution(Coordinate[] path){
        solution = new int[path.length*2];
	int index = 0;
	while(path.isEmpty() != true){
	    int[] temp = path.removeFirst();
	    solution[index] = temp[0];
	    solution[index+1]=temp[1];
	    index += 2;
	}
    }
    
}
