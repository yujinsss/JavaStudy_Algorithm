import java.util.Scanner;
import java.util.Stack;

public class Study_P1874 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int stack_num = 1;
		StringBuffer sb = new StringBuffer();
		int input_num = sc.nextInt();	
		int su_array[] = new int[input_num];
		for(int i = 0 ; i < input_num ; i++) {
			su_array[i] = sc.nextInt();
		}	
		for(int i = 0 ; i < su_array.length ; i++) {	
			System.out.println(su_array[i]);System.out.println(stack_num);
			while(su_array[i]>=stack_num) {
				stack.push(stack_num);
				sb.append("+ \n");
				stack_num++;
			}	
			int pop_num = stack.pop();
			System.out.println(pop_num);
			if(pop_num > su_array[i]) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}else {
				sb.append("- \n");
			}		
		}
		System.out.println(sb.toString());
	}
}
