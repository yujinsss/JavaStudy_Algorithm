import java.util.Scanner;
import java.util.Stack;

public class Study_P17298 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		int input_num = sc.nextInt();	
		Stack<Integer> stack = new Stack<>();
		int su_array[] = new int[input_num];
		for(int i = 0 ; i < input_num ; i++) {
			su_array[i] = sc.nextInt();
		}
		for(int i = 0 ; i < input_num ; i++) {
			while(!stack.empty()&& su_array[stack.peek()] < su_array[i] ) {
				su_array[stack.pop()] = su_array[i];
			}
			stack.push(i);
			
		}
		while(!stack.empty()) {
			su_array[stack.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input_num; i++) {
			sb.append(su_array[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
