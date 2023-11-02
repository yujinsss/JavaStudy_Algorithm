import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Study_P11404 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N , M;
	static int distance[][];
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) { // 인접 행렬 초기화하기
			for (int j= 1; j<= N; j++) {
				if (i == j)
					distance[i][j] = 0;
				else
					distance[i][j] = 10000001;// 충분히 큰 수로 저장하기
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt (st.nextToken());
			int v = Integer.parseInt (st.nextToken());
			if (distance[s][e] > v) distance[s][e] = v;
		}
		for (int k = 1; k <= N; k++) { // 플로이드-워셜 알고리즘 수행하기
			for (int i = 1; i <= N; i++) {
				for (int j= 1; j <= N; j++) {
					if (distance[i][j] > distance[i][k] + distance [k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j= 1; j <= N; j++) {
				if (distance[i][j] == 10000001)System.out.print("0 ");
				else System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}




