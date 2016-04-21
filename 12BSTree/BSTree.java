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
	    return hasRight() && hasLeft();
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
	    if(hasChildren()){
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
	private TreeNode remove(T val){
	    //Pre-Condition: has at least one child.
	    if(!hasChildren()){
		if(hasRight){
		    if(getRight().getValue().compareTo(val) == 0){
			TreeNode temp = getRight();
			setRight(null);
			return temp;
		    }else{
			if(getRight().hasRight() || getRight.hasLeft()){
			    return getRight().remove(val);
			}else{
			    return null;
			}
		    }
		}else{
		    if(getLeft().getValue().compareTo(val)==0){
			TreeNode temp = getLeft();
			setLeft(null);
			return temp;
		    }else{
			if(getLeft().hasLeft()|| getLeft().hasRight()){
			    return getLeft().remove(val);
			}else{
			    return null;
			}
		    }
		}
	    }else{
		//right tree algorithm
		TreeNode current = getRight();
		
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
	root.remove(val);
    }

}
