import java.util.Scanner;
import java.util.Stack;

public class Study_P9012 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		int input_num = sc.nextInt();	
		for(int i = 0 ; i < input_num ; i++) {
			Stack<String> stack = new Stack<>();
			String str = sc.next();
			boolean isVPS = true;
			for(int j = 0 ; j < str.length(); j++) {
				String chr = String.valueOf(str.charAt(j));
				if(chr.equals("(")) {
					stack.push(chr);
				}else if(chr.equals(")")) {
					if(!stack.empty()) {
						stack.pop();
					}else {
						isVPS = false;
						break;
					}
				}
			}
			if(!stack.isEmpty())
	             isVPS = false;

            if(isVPS)
                System.out.println("YES");
            else
                System.out.println("NO");
		}	
	}
}
