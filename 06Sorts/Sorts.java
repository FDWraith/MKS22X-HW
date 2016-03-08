public class Sorts{

    public static void insertionSort(int[]entry){
	int nextIndex =1;
	int val;
	boolean checker;
	while(nextIndex<entry.length){
	    System.out.println(printArray(entry));
	    val = entry[nextIndex];
	    checker = false;
	    for(int i=nextIndex-1;i>=0;i--){
		if(val<entry[i]&&!checker){
		    entry[i+1]=entry[i];
		    entry[i]=val;
		}else if(val>=entry[i]&&!checker){
		    entry[i+1]=val;
		    checker=true;
		}else{
		    entry[i]=entry[i];
		}
	    }
	    System.out.println(printArray(entry));
	    nextIndex++;
	}
    }

    public static String printArray(int[]arry){
	String end = "[ ";
	for(int i =0;i<arry.length;i++){
	    end += arry[i] + " "; 
	}
	end += "]";
	return end;
    }
    
    public static void mergesort(int[]arry){
	int[]v1 = new int[arry.length];
	mergeSort(arry,0,arry.length/2+arry.length%2,arry.length/2+arry.length%2,arry.length,v1);
	for(int i=0;i<v1.length;i++){
	    arry[i] = v1[i];
	}//copy values in v1 to arry
    }

    public static String name(){
	return "6,Zhang,Kevin";
    }



    public static void merge(int[]old,int start1, int end1, int start2, int end2, int[]nw){
	int first = start1;
	int second = start2;
	for(int i=0;i<start1;i++){
	    nw[i]=old[i];
	}
	for(int i=start1;i<end2;i++){
	    if(first < end1 && second < end2){
		if(old[first]<old[second]){
		    nw[i]=old[first];
		    first++;
		}else{
		    nw[i]=old[second];
		    second++;
		}
	    }else{
		if(first < end1){
		    nw[i]=old[first];
		    first++;
		}else if(second < end2){
		    nw[i]=old[second];
		    second++;
		}else{
		    //nw[i]=old[i];
		}
	    }
	}
        for(int i=end2;i<old.length;i++){
	    nw[i]=old[i];
	}
    }

    public static void mergeSort(int[]old,int start1, int end1, int start2, int end2, int[]nw){
	if(start1+1==end2){//when it is a single index
	    merge(old,start1,end1,start2,end2,nw);//copy it in.
	}else{
	    mergeSort(old,start1,(start1+end1)/2,(start1+end1)/2,end1,nw);
	    mergeSort(nw,start2,(start2+end2)/2,(start2+end2)/2,end2,old);
	    merge(old,start1,end1,start2,end2,nw);
	}
    }


    
    public static void main(String[]args){
	int[]test1 = {2,1,3};
	mergeSort(test1);
	System.out.println(printArray(test1));
	System.out.println();
	
	int[]hello = {2,-10,4,-3};
	int[]copy = {0,0,0,0};
	System.out.println(printArray(hello));
	mergeSort(hello,0,hello.length/2,hello.length/2,hello.length,copy);
	//mergeSort(hello,0,1,1,2,copy);
	//System.out.println(printArray(copy));
	//mergeSort(copy,2,3,3,4,hello);
	System.out.println(printArray(copy));
	//merge(hello,0,2,2,4,copy);
	//System.out.println(printArray(copy));
	System.out.println();
	
	int[]demon = {10,23,20,1,24,2,3,4,3};
	System.out.println(printArray(demon));
	mergeSort(demon);
	System.out.println(printArray(demon));
    }
}
