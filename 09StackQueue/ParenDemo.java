public class ParenDemo{
    public static void main(String[]args){
	String input = "";
	if(args.length >0){
	    input = args[0];
	}
	System.out.println(isMatching(input));
    }
    
    public static boolean isMatching(String s){
	MyStack<String> tester = new MyStack<String>();
	for(int i=0;i<s.length();i++){
	    String ch = s.substring(i,i+1);
	    if(ch.equals("(") || ch.equals("<") || ch.equals("[") || ch.equals("{") ){
		tester.push(ch);
	    }else if (ch.equals(")")){
		if(!tester.pop().equals("(")){
		    System.out.println("No matching opening for "+ch);
		    return false;
		}
	    }else if (ch.equals(">")){
		if(!tester.pop().equals("<")){
		    System.out.println("No matching opening for "+ch);
		    return false;
		}
	    }else if (ch.equals("]")){
		if(!tester.pop().equals("[")){
		    System.out.println("No matching opening for "+ch);
		    return false;
		}
	    }else if (ch.equals("}")){
		if(!tester.pop().equals("{")){
		    System.out.println("No matching opening for "+ch);
		    return false;
		}
	    }else{
		//do nothing :P
	    }
	}
	//System.out.println(tester);
	return tester.isEmpty(); 
    }
}
