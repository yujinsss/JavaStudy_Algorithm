
import java.util.PriorityQueue;
import java.util.Scanner;

public class Study_P11286 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		int input_num = sc.nextInt();	
		PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) ->{
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1> o2 ? 1  :-1;
			}else {
				return Math.abs(o1) - Math.abs(o2);
			}
        });
		
		for(int i = 0 ; i<input_num ; i++) {
			int input_num2 = sc.nextInt();	
			if(input_num2 == 0) {
				if(que.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(que.poll());
				}
			}else {
				que.add(input_num2);
			}
		}
	}
}
