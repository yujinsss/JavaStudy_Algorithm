import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Study_P1707 {
    static ArrayList<ArrayList<Integer>> graph; // 그래프
    static int[] group;
    static int k,v,e;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for(int i = 0; i < v+1; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            // 각 정점이 속한 그룹을 기록하는 배열
            group = new int[v+1];
            String answer = "YES";
            for(int i = 1; i < v+1; i++){
                // 아직 방문하지 않은 노드에 대해
                if(group[i] == 0){
                    if(!bfs(i)) answer = "NO";
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean bfs(int start){
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(start, 1));
        group[start] = 1;

        while(!q.isEmpty()){
            Node curr = q.pollFirst();
            for(Integer adj : graph.get(curr.index)){
                if(group[adj] == 0){
                    // 방문 표시를 하고 반대 그룹에 편성
                    group[adj] = -curr.group;
                    q.add(new Node(adj, -curr.group));
                }else{
                    // 이비 방문을 한 정점이 같은 그룹에 있으면 실패
                    if(group[adj] == curr.group){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    static class Node{
         int index, group;
         Node(int index, int group){
            this.index = index;
            this.group = group;
        }
    }
}