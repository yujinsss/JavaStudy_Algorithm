import java.util.Scanner;

public class Study_P23881{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int input_num = sc.nextInt();
    	int change_num = sc.nextInt();
    	int change_num_2 = 0;
        int array[] = new int[input_num];
        int change_array[]  = new int[2];
        for(int i=0; i<array.length; i++){
        	array[i]= sc.nextInt();
        }
        for(int i = array.length-1 ; i > 0; i--){
        	int max = i;
            for(int j = 0 ; j < i ; j++){
            	if(array[j]  >  array[max]) {
            		max = j;	
            	}  	
            }
            if(array[i] <  array[max]) {
	            int temp = array[max];
	            array[max] = array[i];
	            array[i] = temp;   
	            change_num_2++;
	            if(change_num_2 == change_num) {
	            	change_array[0] = array[max];
	            	change_array[1] = array[i];
	            }
            }              
        }
        
        if(change_num_2 < change_num) {
        	change_num_2 = -1;
        	System.out.println(change_num_2);
        }else {
	        for(int i = 0 ; i < change_array.length; i++) {
	 			System.out.print(change_array[i] + " ");
		    }
        }
    }
}