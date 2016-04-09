import java.util.*;
public class BetterMaze{
    private char[][] maze;
    private int[] solution;
    private int startRow,startCol;
    private int endRow,endCol;
    private Frontier<Coordinate> placesToGo;
    private boolean animate;
    private boolean hasSolution,isSolved;

    public int[] solutionCoordinates(){
	if(!isSolved){
	    solve();
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

    public void solve(){
	solve("DFS");
    }
    public void solve(String type){
	if(type.equals("BFS")){
	    placesToGo = new FrontierQueue<Coordinate>();	    
	}else{
	    placesToGo = new FrontierStack<Coordinate>();
	}
	runAlgorithm();
	isSolved = true;
    }

    public void runAlgorithm(){
	Coordinate start = new Coordinate(startRow,startCol);
	placesToGo.add(start);
	while(placesToGo.hasNext()){
	    Coordinate one = placesToGo.next();
	    int[][] surround = getSurroundings(one);
	    for(int i = 0;i<surround.length;i++){
		Coordinate nw = new Coordinate(surround[i][0],surround[i][1],one.getPath());
		if(nw.getX() == endRow && nw.getY() == endCol){
		    convertSolution(nw.getPath());
		    hasSolution = true;
		    return;//terminate;
		}else{
		    placesToGo.add(nw);
		}
	    }
	}
	hasSolution = false;
    }

    public int[][] getSurroundings(Coordinate in){
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

    public void convertSolution(MyDeque<int[]>path){
        solution = new int[path.size()*2];
	int index = 0;
	while(path.isEmpty() != true){
	    int[] temp = path.removeFirst();
	    solution[index] = temp[0];
	    solution[index+1]=temp[1];
	    index += 2;
	}
    }
    
}
