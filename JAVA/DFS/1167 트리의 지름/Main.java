import java.io.*;
import java.util.*;

public class Main {
    public static int edgeNode;
    public static boolean[] visited;
    public static Map<Integer,ArrayList<edge>> vMap;
    //public static int[][] vCostArr;
    public static int max = -1;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        //vCostArr = new int[V+1][V+1]; //[1][3]이면, vertex 1에서 3으로의 비용을 말함.
        vMap = new HashMap<>();
        StringTokenizer st;
        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int vNum = Integer.parseInt(st.nextToken()); 
            vMap.computeIfAbsent(vNum,k->new ArrayList<edge>());
            int targetVNum = Integer.parseInt(st.nextToken());
            int vCost;
            while(targetVNum !=-1){
                vCost = Integer.parseInt(st.nextToken());
                //vCostArr[vNum][targetVNum] = vCost;
                vMap.get(vNum).add(new edge(targetVNum, vCost));
                targetVNum = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[V+1];
        Arrays.fill(visited,false);
        DFS(1,0);
        visited = new boolean[V+1];
        DFS(edgeNode,0);
        System.out.println(max);
    }
    
    public static void DFS(int node, int cost){
        if(cost > max){
            max = cost;
            edgeNode = node;
        }visited[node] = true;
        ArrayList<edge> ar = vMap.get(node);
        for(int i = 0; i<ar.size(); i++){
            edge destEdge = ar.get(i);
            int destNode = destEdge.targetV;
            if(!visited[destNode]){
                visited[destNode] = true;
                int destCost = destEdge.cost;
                DFS(destNode,cost+destCost);
            }
        }
    }
    static class edge{
        int targetV;
        int cost;
        public edge(int targetV, int cost){
            this.targetV = targetV;
            this.cost = cost;
        }
    }
}
