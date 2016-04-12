import java.util.*;
import java.io.*;
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
	    cors = new int[2];
	    cors[0] = x;
	    cors[1] = y;
	    prev = null;
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
	public String toString(){
	    return getX()+","+getY();
	}
    
    }

    public BetterMaze(String filename){
	/*
	  int c1 =0;
	  int c2 =0;
	  ArrayList<Character> tmp = new ArrayList<Character>();
	  Scanner in = new Scanner(new File(dataIn));
	  while(in.hasNext()){
	  String temp = in.nextLine();
	  for(int i =0;i<temp.length()-1;i++){
	  tmp.add(temp.charAt(i));
	  }
	  c2 = temp.length()-1;
	  c1++;
	  }
	  int index = 0;
	  maze = new char[c1][c2];
	  for(int i =0;i<maze.length;i++){
	  for(int j=0;j<maze.length;j++){
	  maze[i][j] = tmp.get(index);
	  index++;
	  }
	  }
	*/
	animate = false;
	int maxc = 0;
	int maxr = 0;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	int index =0;
	for(int i=0;i<maze.length;i++){
	    for(int j=0;j<maze[i].length;j++){
		char c = ans.charAt(index);
		if(c == 'S'){
		    startRow = i;
		    startCol = j;
		    //maze[i][j] = ' ';
		}else if(c == 'E'){
		    endRow = i;
		    endCol = j;
		    //maze[i][j] = ' ';
		}
		maze[i][j] = c;		
		index++;
	    }
	}
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
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
	System.out.println(this);
	return solve();
    }

    public boolean solveDFS(){
	placesToGo = new FrontierStack<Coordinate>();
	System.out.println(this);
	return solve();
    }

    private boolean solve(){
	isSolved = true;//indicate that a solve has been attempted
	Coordinate start = new Coordinate(startRow,startCol);
	System.out.println(startRow+","+startCol);
	System.out.println(start);
	placesToGo.add(start);
	int counter = 0;
	while(placesToGo.hasNext()){
	    Coordinate one = placesToGo.next();
	    System.out.println(counter);
	    System.out.println(one);
	    maze[one.getX()][one.getY()] = '.';
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
	    if(animate){
		System.out.println(this);
	    }
	    counter++;
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
	    if(maze[xCor][yCor] == ' ' || maze[xCor][yCor] == 'S' || maze[xCor][yCor] == 'E'){
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
	

    private void convertSolution(MyDeque<Coordinate> path){
        solution = new int[path.size()*2];
	int index = 0;
	while(path.isEmpty() != true){
	    Coordinate temp = path.removeFirst();
	    solution[index] = temp.getX();
	    solution[index+1]=temp.getY();
	    index += 2;
	}
    }
    
}
