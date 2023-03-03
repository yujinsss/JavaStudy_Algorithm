import java.util.Scanner;

public class Study_P2752 {

	public static void main(String[] args) {
		Scanner sc  =  new Scanner(System.in);
		int[] arrayInt = new int [3];
		for(int i  = 0 ; i < 3 ; i++) {
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
			System.out.print(arrayInt[i] + " ");
		}
	}

}
