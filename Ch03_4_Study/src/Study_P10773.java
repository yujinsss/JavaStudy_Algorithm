import java.util.Scanner;
import java.util.Stack;

public class Study_P10773 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int input_num = sc.nextInt();	
		
		for(int i = 0 ; i < input_num ; i++) {
			int stack_num = sc.nextInt();
			if(stack_num== 0) {
				stack.pop();
			}else {
				stack.push(stack_num);
			}
		}	
		int sum = 0 ;
		for(Integer num :stack) {
			sum+=num;
		}
		System.out.println(sum);
	}
}
