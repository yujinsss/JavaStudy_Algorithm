import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Study_P1934{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//일반 출력시 시간초과
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long a = sc.nextLong();
		long b = sc.nextLong();
		long n = gcd(a ,  b);
	         
	    for(int i=0; i<n; i++){
	    	bw.write("1");
	    }
    	bw.flush();
    	bw.close();
 
    }
	//최대 공약수 구하기
	public static long gcd(long a , long b) {
		if(b == 0) return a;
		else return gcd( b , a % b);
		
	}
}