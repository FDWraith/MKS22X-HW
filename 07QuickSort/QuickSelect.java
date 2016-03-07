import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
    private static Random r = new Random();

    public static int rearrange(int[]ary,int startIndex, int left, int right){

	if(left == right){
	    return left;
	}

	int checker = ary[startIndex];
	int origRight = right;

	//set centerPiece aside
	swap(ary,startIndex,right);
	right--;

	//Until we reach last element, compare the leftmost element to centerPiece. If greater, swap.
	while(left != right){
	    
	    if(ary[left]<=checker){
		left++;
	    }else{
		swap(ary,left,right);
		right--;
	    }
	}
	
	//Check last element with centerPiece. If it is less, then swap with element to right. Otherwise, swap with left.
	if(ary[left]<=checker){
	    swap(ary,right+1,origRight);
	    return right+1;
	}else{
	    swap(ary,left,origRight);
	    return left;
	}

	
    }

    public static void swap(int[]ary,int firstDex, int secondDex){
	int store = ary[firstDex];
	ary[firstDex]=ary[secondDex];
	ary[secondDex]=store;
    }

    
    public static int quickSelect(int[]ary,int k){
	
	int left = 0;
	int right = ary.length -1;
	int numIndex = -1;
	int n;
	do{
	    //System.out.println(left+","+right);
	    numIndex = r.nextInt(right-left+1)+left;
	    n = rearrange(ary,numIndex,left,right);
	    //System.out.println(n);
	    if(n < ary.length-k){
		left = n+1;
	    }else{
		right = n-1;
	    }
	}while(n != ary.length-k);

	return ary[n];
	
    }
    
    public static void main(String[]args){
	int[] test1 = {-5,-1,0,2,1,7,3,4,6,8,10};
	System.out.println(Arrays.toString(test1));
	System.out.println(quickSelect(test1,2));
	System.out.println(Arrays.toString(test1));
    }

    
}
