

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



public class Study_P11403 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N ;
	static int distance[][];
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		distance = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt (st.nextToken());
				distance[i][j] = v;
			}
		}
		for (int k = 0; k < N; k++) { 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
				if (distance[i][k] == 1 && distance [k][j] == 1) distance[i][j] = 1;
				}
			}
		}
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N ; j++) {
				 System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}





