public class BSTree<T extends Comparable<T>>{
    private class TreeNode{
	private T value;
	private TreeNode left;
	private TreeNode right;
	private int tally;

	public TreeNode(T val){
	    value = val;
	}
	public TreeNode(){
	    left = null;
	    right = null;
	    value = null;
	}	
	private boolean hasLeft(){
	    return left!=null;
	}
	private boolean hasRight(){
	    return right!=null;
	}
	private boolean hasValue(){
	    return value!=null;
	}
	private boolean hasChildren(){
	    return hasRight() || hasLeft();
	}
	private T getValue(){
	    return value;
	}
	private TreeNode getLeft(){
	    return left;
	}
	private TreeNode getRight(){
	    return right;
	}
	private void setValue(T val){
	    value = val;
	}
	private void setLeft(TreeNode n){
	    left = n;
	}
	private void setRight(TreeNode n ){
	    right = n;
	}
	private int getHeight(){
	    if(hasChildren()){
		int leftHeight = getLeft().getHeight();
		int rightHeight = getRight().getHeight();
		return Math.max(leftHeight,rightHeight) + 1;
	    }else if(hasRight()){
		return getRight().getHeight() + 1;
	    }else if(hasLeft()){
		return getLeft().getHeight() + 1;
	    }else{
		return 1;//default height is one, for self.
	    }
	}
	private String toTreeString(){
	    if(hasLeft() && hasRight()){
		return getValue() + " " + getLeft().toTreeString() + " " + getRight().toTreeString();
	    }else if(hasLeft()){
		return getValue() + " " + getLeft().toTreeString()+ " _";
	    }else if(hasRight()){
		return getValue() + " _ " + getRight().toTreeString();
	    }else{
		return getValue()+" _ _";
	    }
	}
	private void add(T val){
	    if(!hasValue()){
		setValue(val);
	    }else{
		if(this.value.compareTo(val)==0){
		    tally++;
		}else if(this.value.compareTo(val)<0){
		    if(hasRight()){
			getRight().add(val);
		    }else{
			setRight(new TreeNode(val));
		    }
		}else{
		    if(hasLeft()){
			getLeft().add(val);
		    }else{
			setLeft(new TreeNode(val));
		    }
		}
	    }	    
	}	
    }

    private TreeNode root;

    public BSTree(){
	root = new TreeNode();
    }
    public BSTree(T v){
	root = new TreeNode(v);
    }
    
    public void add(T val){
	root.add(val);
    }
    public String toString(){
	if(root.hasValue()){
	    return root.toTreeString();
	}else{
	    return "_";
	}
    }
    public int getHeight(){
	return root.getHeight();
    }
    public boolean contains(T val){
	TreeNode current = root;
	while(current!=null && current.hasValue()){
	    int comp = current.getValue().compareTo(val);//get compareTo
	    if(comp == 0){
		return true;
	    }else if(comp > 0 ){
		current = current.getLeft();
	    }else{
		current = current.getRight();
	    }
	}
	return false;
    }

    public void remove(T val){
	if(!contains(val)){
	    System.out.println("Tree Does Not have Such Element");
	}else{	    
	    //root.remove(val);

	    //System.out.println(this);

	    //System.out.println("Break 0");
	    
	    TreeNode current = root;
	    TreeNode temp = null;
	    int compare = -1;
	    while(compare!=0){
		compare = current.getValue().compareTo(val);
		if(compare > 0){
		    temp = current;
		    current = current.getLeft();
		}else if(compare < 0){
		    temp = current;
		    current = current.getRight();
		}
	    }

	    //System.out.println(root.toTreeString());//breaks here as well?
	    
	    //System.out.println("Break 1");	    
	    
	    TreeNode store = null;
	    if(!current.hasChildren()){
		//nada
	    }else if(current.hasRight()){
		store = rightTreeAlgorithm(current);
	    }else{
		store = leftTreeAlgorithm(current);		
	    }	    
	    
	    // System.out.println("Break 2");
	    
	    if(temp == null){
		root = store;
	    }else{
		if(temp.getLeft().getValue().compareTo(current.getValue()) == 0){
		    temp.setLeft(store);
		}else{
		    temp.setRight(store);
		}
	    }

	    //System.out.println(store);
	    
	    //System.out.println(store.toTreeString());//something is wrong with store?
	    
	    //System.out.println("Break 3");

	    //System.out.println(root.toTreeString());//something is causing toTreeSting to break

	    //System.out.println("Break 4");
	}
    }

    private TreeNode rightTreeAlgorithm(TreeNode replaced){
	TreeNode current = replaced.getRight();
	TreeNode temp = replaced;
	while(current.hasLeft()){
	    temp = current;
	    current = current.getLeft();	    
	}
	
	//System.out.println("Parent: "+temp.getValue()+" & Child:"+current.getValue());
	
	if(temp.getValue().compareTo(replaced.getValue()) == 0){
	    temp.setRight(current.getRight());
	}else{
	    temp.setLeft(current.getRight());//parent's new left children is current's right children.
	}
	
	
	current.setLeft(replaced.getLeft());//child takes over
	current.setRight(replaced.getRight());

	return current;//current replaces the former TreeNode;
    }

    private TreeNode leftTreeAlgorithm(TreeNode replaced){
	TreeNode current = replaced.getLeft();
	TreeNode temp = replaced;
	while(current.hasRight()){
	    temp = current;
	    current = current.getRight();
	}
	if(temp.getValue().compareTo(replaced.getValue()) == 0){
	    temp.setLeft(current.getLeft());
	}else{
	    temp.setRight(current.getLeft());
	}
	
	current.setLeft(replaced.getLeft());
	current.setRight(replaced.getRight());

	return current;
    }

}
