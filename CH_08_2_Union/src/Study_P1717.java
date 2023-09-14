import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study_P1717 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            parents[i] = i;
        }
        StringBuilder sb  = new StringBuilder();
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

        	if(cmd == 0) {
        		union(a, b); 
        	}else {
        		if(isUnion(a, b)) {
        			System.out.println("YES");
        		}else {
        			System.out.println("NO");
        		}
        	}
        }
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
    static boolean isUnion(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return true;
        return false;
    }
}