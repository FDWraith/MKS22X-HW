public class Coordinate{
    private MyDeque<int[]> path;
    private int[] cors;

    public Coordinate(int x, int y){
	this(x,y,new MyDeque<int[]>());
    }
    public Coordinate(int x, int y,MyDeque<int[]> prev){
	int[] cors = new int[2];
	cors[0] = x;
	cors[1] = y;
	path = prev;
    }
    
    public int getX(){
	return cors[0];
    }
    public int getY(){
	return cors[1];
    }
    public MyDeque<int[]> getPath(){
        path.addLast(cors);
	return path;
    }
    
}
