import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] graph; // graph[i]는 i 노드에 연결된 엣지들. [[상대노드, 가중치], ..]
    static int V; // 노드 수
    static int E; // 엣지 수
    static int K; // 시작 정점 번호
    static int[] dij; // 최소 비용 배열, [i]에 j가 저장되어 있다면 i로가는 최소 비용이 j라는 것
    static boolean[] visit; // 방문 여부
    static int count; // 방문 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            // (u,v,w) u에서 v로 w 가중치. 무방향그래프이므로 반대 방향에도 넣어야 함.
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] { v, w });
        }

        dij = new int[V + 1];
        Arrays.fill(dij, Integer.MAX_VALUE);
        visit = new boolean[V + 1];
        count = 0;

        // K 노드가 시작임
        int node = K;
        dij[node] = 0;
        while (count < V) {
            visit[node] = true;
            int nextNode = 0;

            // node와 연결된 node 및 가중치 확인
            for (int i = 0; i < graph[node].size(); i++) {
                int[] arr = graph[node].get(i);
                int v = arr[0]; // 상대 노드
                int w = arr[1]; // 가중치
                
                // 기존 연결 길이와, 시작->node까지 최소값(dij[node])+node->v까지 거리 합 중 최소값
                dij[v] = Math.min(dij[v], dij[node] + w);
            }

            // i를 아직 방문 안한 경우, 방문 후보 가능한지 확인(가장 작은 값 다음으로 설정함)
            for (int i = 1; i < V + 1; i++) {
                if (!visit[i] && dij[i] != Integer.MAX_VALUE) {
                    if (nextNode == 0 || dij[i] < dij[nextNode]) {
                        nextNode = i;
                    }
                }
            }if (nextNode == 0) break;
            count += 1;
            node = nextNode;
        }
        for (int i = 1; i < dij.length; i++) {
            System.out.println(dij[i] == Integer.MAX_VALUE ? "INF" : dij[i]);
        }

    }
}
