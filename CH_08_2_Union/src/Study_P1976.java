import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study_P1976 {

	static int n,m;
	static int[] parents;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] target = new int[m];
		parents = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parents[i] = i;
		}
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num ==1) {
					union(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		for(int i=0; i<m-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(root != find(num)) { 
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return;
        parents[B] = A;
    }
}