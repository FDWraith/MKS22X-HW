public class Recursion implements hw01{
    public String name(){
	return "Zhang,Kevin";
    }

    public double sqrt(double n){
	if(n<0){
	    throw(new IllegalArgumentException());
	}
	return sqrt(n,1);
    }

    public double sqrt(double target, double g){
	double guess = (target/g + g)/2.0;
	if( (Math.pow(guess,2) - target)/target < 0.00001){
	    return guess;
	}else{
	    return sqrt(target, guess);
	}
    }
    
    
    public static void main(String[]args){
	Recursion r = new Recursion();
	System.out.println(r.sqrt(-1));
    }
    

}
