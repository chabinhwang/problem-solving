import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayDeque;

public class Main2 {
    static boolean[][] graph;
    static int N; // 정점의 갯수
    static int M; // 간선의 갯수
    static int V; // 탐색 시작 정점 번호
    static boolean[] visit; // visit[i] = i 노드 방문 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph[v][u] = true;
            graph[u][v] = true;
        }
        visit[V] = true;
        DFS(V);
        sb.append("\n");

        Arrays.fill(visit, false);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visit[V] = true;
        q.offer(V);
        while (!q.isEmpty()) {
            int n = q.poll();
            sb.append(String.valueOf(n) + " ");
            boolean[] b = graph[n];
            for (int i = 1; i < b.length; i++) {
                if (b[i] && !visit[i]) {
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }

        System.out.println(sb);
    }

    static void DFS(int n) {
        sb.append(String.valueOf(n) + " ");
        boolean[] b = graph[n];
        for (int i = 1; i < b.length; i++) {
            if (b[i] && !visit[i]) {
                visit[i] = true;
                DFS(i);
            }
        }
    }
}
