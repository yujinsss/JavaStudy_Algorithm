import java.util.*;
import java.io.*;
public class Study_P1043 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] inputs=br.readLine().split(" ");

        int N=Integer.parseInt(inputs[0]);
        int M=Integer.parseInt(inputs[1]);

        boolean[] peopleKnow=new boolean[N+1];

        ArrayList<Integer>[] arr=new ArrayList[M+1];
        for(int i=1;i<=M;i++){
            arr[i]=new ArrayList<>();
        }

        inputs=br.readLine().split(" ");
        int knowNum=Integer.parseInt(inputs[0]);
        for(int i=1;i<=knowNum;i++){
            peopleKnow[Integer.parseInt(inputs[i])]=true;
        }

        parent=new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i]=i;
        }

        for(int i=1;i<=M;i++){
            inputs=br.readLine().split(" ");
            int partyNum=Integer.parseInt(inputs[0]);

            if(partyNum<=1){
                arr[i].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for(int j=1;j<partyNum;j++){
                int a=Integer.parseInt(inputs[j]);
                int b=Integer.parseInt(inputs[j+1]);

                if(find(a)!=find(b)){
                    union(a,b);
                }

                arr[i].add(a);
                arr[i].add(b);
            }
        }

        boolean[] visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(peopleKnow[i]&&!visited[i]){
                int parent=find(i);
                for(int j=1;j<=N;j++){
                    if(find(j)==parent){
                        peopleKnow[j]=true;
                        visited[j]=true;
                    }
                }
            }
        }

        int result=0;
        for(int i=1;i<=M;i++){
            boolean flag=false;
            for(int person:arr[i]){
                if(peopleKnow[person]){
                    flag=true;
                    break;
                }
            }

            if(!flag) result++;
        }

        System.out.println(result);
    }

    static int find(int x){
        if(parent[x]==x) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b){
        int parentB=find(b);
        parent[parentB]=a;
    }
}