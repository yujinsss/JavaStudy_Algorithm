import java.util.Scanner;
import java.util.Stack;

public class Study_P10828 {
	
	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int input_num = sc.nextInt();	
		
		for(int i = 0 ; i <= input_num ; i++) {
			String stack_comm = sc.nextLine();
			String[] input_str = stack_comm.split(" ");
			switch (input_str[0]) {
				case "push": 
					stack.push(Integer.parseInt(input_str[1]));
					break;
				case "pop": 
					if(stack.empty()) {
						sb.append("-1\n");
					}else {
						sb.append(stack.pop()+"\n");
						
					}
					break;
				case "size": 
					sb.append(stack.size()+"\n");
					break;
				case "empty": 
					if(stack.empty()) {
						sb.append("1\n");
					}else {
						sb.append("0\n");
						
					}
					break;
				case "top": 
					if(stack.empty()) {
						sb.append("-1\n");
					}else {
						sb.append(stack.peek()+"\n");
						
					}
					break;						
			}		
		}
		System.out.println(sb.toString());
	}
}