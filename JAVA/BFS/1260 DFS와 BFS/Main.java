import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> list;
    static boolean[] visit;
    static int V; // 시작 노드
    static int[][] graph; // [시작 노드][끝 노드]
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        V = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        // for(int i = 1 ; i < N + 1; i++){
        //     for(int j = 1; j < N + 1; j++){
        //         System.out.printf("%d ",graph[i][j]);
        //     }
        //     System.out.println();
        // }
        StringBuilder sb = new StringBuilder();

        // DFS
        visit = new boolean[N+1];
        list = new ArrayList<>();
        DFS(V);
        
        for(int i : list){
            sb.append(String.valueOf(i) + " ");
        }
        sb.append("\n");
        // -----

        // BFS
        visit = new boolean[N+1];
        list = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visit[V] = true;
        q.offer(V);

        while(!q.isEmpty()){
            int n = q.poll();

            list.add(n);

            int[] arr = graph[n];
            for(int i = 1; i < arr.length; i++){
                if(arr[i] == 1 && !visit[i]){
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
        // -----

        for(int i : list){
            sb.append(String.valueOf(i) + " ");
        }
        sb.append("\n");

        // 결과 출력
        System.out.println(sb);
        
    }

    static void DFS(int n){
        // 이전에 방문 한 노드라면, 방문처리 안하고 return
        if(visit[n]){
            return;
        }
        visit[n] = true;
        list.add(n); // 방문 순서대로 arr저장
        int[] arr = graph[n];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 1) {
                DFS(i);
            }
        }
        return;
    }


}
