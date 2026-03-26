import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visit; // 0이면 미방문, 1 혹은 2면 방문(이분 그래프 확인용)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1]; // 정점이 1부터 V까지임
            for(int l = 0; l < V + 1; l++){
                graph[l] = new ArrayList<>();
            }
            visit = new int[V + 1];
            int v = 0;
            int e = 0;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                v = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                graph[v].add(e);
                graph[e].add(v);
            }

            boolean result = true;
            for (int k = 1; k <= V; k++) {
                if (visit[k] == 0) {
                    visit[k] = 1; // v노드에 1로 색칠하고 시작
                    result = result ? DFS(k, 1) : result;
                }
            }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean DFS(int r, int color) {
        boolean result = true;

        for (int i = 0; i < graph[r].size(); i++) {
            int next = graph[r].get(i);
            if (visit[next] == 0 && result) {
                visit[next] = color == 1 ? 2 : 1;
                result = DFS(next, visit[next]);
            }
            if (visit[next] != 0 && result) {
                if (visit[next] == color) { // 방문한 인접한 노드가 색이 같다면 -> false
                    result = false;
                }
            }
        }
        return result;
    }
}
