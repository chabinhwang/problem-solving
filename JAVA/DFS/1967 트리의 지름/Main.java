import java.util.*;
import java.io.*;

public class Main {
    public static Map<Integer,ArrayList<Edge>> vMap;
    public static StringTokenizer st;
    public static BufferedReader br;
    public static int vNum;
    public static int max = -1;
    public static boolean[] visited;
    public static void main(String[]args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        vMap = new HashMap<>();
        read();
        int n = parseTokenToInt();
        for(int i = 0 ; i < n-1 ; i++){
            read();
            int vertex = parseTokenToInt();
            int destVertex = parseTokenToInt();
            int cost = parseTokenToInt();
            vMap.computeIfAbsent(vertex,k->new ArrayList<Edge>());
            vMap.computeIfAbsent(destVertex,k->new ArrayList<Edge>());
            vMap.get(vertex).add(new Edge(destVertex, cost));
            vMap.get(destVertex).add(new Edge(vertex, cost));
        }
        // 트리의 지름이므로 가장 먼 곳 DFS 한 다음, 다시 찾으면 가장 큰 값 나옴
        visited = new boolean[n+1];
        Arrays.fill(visited,false);
        DFS(1,0);
        
        visited = new boolean[n+1];
        Arrays.fill(visited,false);
        DFS(vNum,0);

        System.out.println(max);
        

    }

    public static void DFS(int vertex, int cost){
        if(cost>max){
            max = cost;
            vNum = vertex;
        }visited[vertex] = true;
        if(!vMap.containsKey(vertex)){
            return;
        }
        ArrayList<Edge> ar = vMap.get(vertex);
        for(int i = 0; i < ar.size(); i++){
            Edge edge = ar.get(i);
            if(!visited[edge.dest]){
                DFS(edge.dest,cost+edge.cost);
            }
        }
    }


    public static int parseTokenToInt(){
        return Integer.parseInt(st.nextToken());
    }

    public static void read()throws IOException{
        st = new StringTokenizer(br.readLine());
    }

    static class Edge{
        int dest;
        int cost;

        public Edge(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
}
