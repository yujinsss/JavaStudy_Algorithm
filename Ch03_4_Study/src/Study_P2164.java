import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Study_P2164 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		int input_num = sc.nextInt();	
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1 ; i <= input_num ; i++) {
			que.add(i);
		}
		while(que.size()!= 1) {
			que.poll();
			que.offer(que.poll());
		}
		System.out.println(que.poll());
	}
}
