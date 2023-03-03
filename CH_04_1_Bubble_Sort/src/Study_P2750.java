import java.util.Scanner;

public class Study_P2750 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		int input_num = sc.nextInt();
		int[] arrayInt = new int [input_num];
		for(int i  = 0 ; i < input_num ; i++) {
			arrayInt[i] = sc.nextInt();
		}
		
		for(int i= 1 ; i < arrayInt.length ; i++) {
			for(int j  = 0 ; j < arrayInt.length -i ; j++) {
				if(arrayInt[j]> arrayInt[j+1]) {
					int temp = arrayInt[j+1];
					arrayInt[j+1] = arrayInt[j];
					arrayInt[j] = temp;
				}
			}
		}
		for(int i =0; i<arrayInt.length;i++) {
			System.out.println(arrayInt[i]);
		}
	}

}
