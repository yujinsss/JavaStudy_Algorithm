import java.util.Scanner;

public class Study_P1083 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		
		int input_num = sc.nextInt();
		int[] arrayInt = new int [input_num];		
		for(int i  = 0 ; i < input_num ; i++) {
			arrayInt[i] = sc.nextInt();
		}
		int max_num = sc.nextInt();

		for(int i= 0 ; i < arrayInt.length ; i++) {
			if(max_num==0) break;
			int max = arrayInt[i];
			int maxIndx = i ; 
			for(int j = i ; j < i + max_num+1 && j < input_num ; j++) {
				if(max < arrayInt[j]) {
					max = arrayInt[j];
					maxIndx = j;
							
				}
			}      
			for(int j = maxIndx ; j > i; j--) {
				if(arrayInt[j]>arrayInt[j-1] ) {
					int temp = arrayInt[j];
					arrayInt[j] = arrayInt[j-1];
					arrayInt[j-1] = temp ;
					max_num--;
				}
			}
			
		}
		for(int i =0; i<arrayInt.length;i++) {
			System.out.print(arrayInt[i] + " ");
		}
	}

}
