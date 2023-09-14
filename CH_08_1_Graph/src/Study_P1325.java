import java.util.*;
public class Study_P1325 {
 
    static int n,m,k,x;
    static int visited[];
    static ArrayList<Integer>[] graph;
    static List<Integer> ans;
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt(); // 노드 수
        m = sc.nextInt(); // 간선 수
        k = sc.nextInt(); // 목표 거리
        x = sc.nextInt(); // 시작점
        graph = new ArrayList[n+1]; // 그래프 데이터 저장
        ans = new ArrayList<>(); // 정답
 
        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>(); // 그래프 리스트의 ArrayList 초기화
            // 노드 개수만큼 ArrayList 생성
        }
 
        for (int i=1; i<=m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s].add(e);
        }
 
        visited = new int[n+1]; // 방문 배열 초기화
 
        for(int i=0; i<=n; i++){
            visited[i] = -1;
            // 방문 배열을 만듦
        }
        BFS(x); // 시작점부터 bfs 시작
 
        for (int i=0; i<=n; i++){
            if(visited[i]==k){
                ans.add(i);
            }
        }
 
        if (ans.isEmpty()) {
            System.out.println("-1"); //
        } else{
            Collections.sort(ans); // 정답을 오름차순으로 출력
            for (int temp : ans){
                System.out.println(temp);
            }
        }
    }
 
    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++; // visited 배열에 현재 노드 방문 기록하기
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
 
            for (int i : graph[now_node]){
 
                // 큐에 데이터 삽입하고 visited 배열에 방문 거리 기록
                if (visited[i]==-1){ 
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}