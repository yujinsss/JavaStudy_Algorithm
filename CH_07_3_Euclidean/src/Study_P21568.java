import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Study_P21568{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long gcd = gcd(a , b);
		if(c%gcd != 0) { // 최대공약수의 배수가 아닐경우
			System.out.println("-1");
		}else {
			int quot  = (int)(c/gcd);
			long[] result = Excute(a , b);
			System.out.println(result[0] * quot + " " + result[1] * quot);
		}
 
    }
	//최대 공약수 구하기
	public static long[] Excute(int a , int b) { //x 랑 y 구하기
												
		long[] ret = new long[2];
		if(b == 0) { //이전 x와 y값이 없을경우 초기화
			ret[0] = 1;
			ret[1] = 0;
			return ret;
		}
		long q = a / b; // 몫 
		long[] v =  Excute(a , a % b);//유클리드 호제법 재귀호출
		ret[0] = v[1]; //x = y’ , y =x’ – y’ * 몫  계산
		ret[1] = v[0] - v[1] * q; 
		return ret;
	}
		
		
	
	// 유클리드 호제법 최대 공약수 구하기
	public static long gcd(long a , long b) {
		while (b != 0) {
			long temp =  a % b;
			a = b;
			b = temp;
		}
		
		return Math.abs(a);
		
	}
}