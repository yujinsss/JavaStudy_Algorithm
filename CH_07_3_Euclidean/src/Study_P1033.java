
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Study_P1033 {
	static ArrayList<Node>[] A;
	static long lcm;
	static boolean visited[];
	static long D[];
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N  = sc.nextInt();
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;
		
		
		for(int i = 0 ; i< N ; i++) {
			A[i] = new ArrayList<Node>();
			
		}
		for(int i = 0 ; i< N-1 ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			A[a].add(new Node(b, p, q));
			A[b].add(new Node(a, q, p));
			
			lcm *= (p *q / gcd(p , q));// 최소공배수 변경
		}
		D[0] = lcm; // 최소공배수
		DFS(0); //탐색 시작점
		long mgcd  = D[0];
		for(int i = 1 ; i< N ; i++) {
			
			mgcd = gcd(mgcd , D[i]);//배열값들의 최대 공약수 계산
		}
		for(int i = 0 ; i< N ; i++) {
			System.out.print(D[i] / mgcd + " "); // 모든 노드들을 최대공약수로 나눈 후 출력
		}
		
	}

	//최대 공약수 구하기
	public static long gcd(long a , long b) {
		if(b == 0) return a;
		else return gcd( b , a % b);
		
	}
	public static void DFS(int node) { // 노드 탐색
		visited[node] = true;
		for(Node i : A[node]) {
			int next  = i.getB();
			if(!visited[next]) {//방문하지 않은 노드 중
				D[next] = D[node] * i.getQ() / i.getP();//다음 노드 값 현재 노드값 * 비율 
				System.out.print(D[next]+ " D[next] "); 
				System.out.print(D[node]+ " D[node] "); 
				DFS(next);
			}
		}
	}
}

class Node{
	int b;
	int p;
	int q;
	
	public Node(int b , int p , int q) {
		super();
		this.b= b;
		this.p = p;
		this.q = q;
		
	}

	public int getB() {
		return b;
	}

	public int getP() {
		return p;
	}


	public int getQ() {
		return q;
	}
}