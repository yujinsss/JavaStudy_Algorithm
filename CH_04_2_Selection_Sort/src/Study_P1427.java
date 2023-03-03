import java.util.Scanner;

public class Study_P1427{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int array[] = new int[str.length()];
        
        for(int i=0; i<array.length; i++){
        	array[i]=str.charAt(i)-'0';
        }
    	
        for(int i=0; i<array.length -1; i++){
        	int max = i;
            for(int j=i+1; j<array.length; j++){
            	if(array[j] > array[max]) 
            		max = j;
            }
            if(array[i] < array[max]) {
	            int temp = array[max];
	            array[max] = array[i];
	            array[i] = temp;
            }
                
        }
        for(int i = 0 ; i < array.length; i++) {
 			System.out.print(array[i]);
	    }  
    }
}