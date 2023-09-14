import java.util.*;
public class Study_P18352 {
 
    static int n,k;
    static ArrayList<Integer>[] graph;
    static int ans[];
    static boolean[] visited;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	 
        n = sc.nextInt();
        k = sc.nextInt();
        graph = new ArrayList[n+1];
        ans = new int[n+1];
        

        for (int i=1; i<n+1; i++){
            graph[i] = new ArrayList<Integer>(); 
         
        }
 
        for (int i=0; i<k; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s].add(e);
        }
        
        
        for(int i=1; i<=n; i++){
        	visited = new boolean[n+1]; 
        	 BFS(i);
        }
        int max = 0;
        for(int i=1; i<=n; i++){
        	max = Math.max(max, ans[i]);
        }
        for(int i=1; i<=n; i++){
        	if(ans[i]==max) {
        		System.out.print(i + " ");
        	}
        }
    }
 
    private static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // visited 배열에 현재 노드 방문 기록하기
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : graph[node]){
            	if (!visited[i]){ 
                    visited[i] = true;
                    queue.add(i);
                    ans[i]++;
                }
            }
        }
    }
}