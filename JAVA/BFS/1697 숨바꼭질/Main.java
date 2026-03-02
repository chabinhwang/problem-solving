import java.util.*;
import java.io.*;

public class Main {
    public static int time = Integer.MAX_VALUE;
    public static int dest;
    public static boolean[] visit;
    public static ArrayDeque<Integer> q; // 위치 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken()); // 목적지
        visit = new boolean[100_001];
        int[] dist = new int[100_001]; // idx 칸에 가는 데 걸리는 시간 최소값

        q = new ArrayDeque<>();
        q.offer(N); // 현재 위치 저장
        dist[N] = 0;
        visit[N] = true;
        if (N == dest) {
            System.out.println(0);
            return;
        }
        while (!q.isEmpty()) {
            // q에서 현 위치 꺼내서, 범위 확인 후에 +1 -1 *2 진행. 만약 맞다면 현재 시간을 time과 비교해서 최소값 저장. 틀리면 q에
            // 저장하고 시간값 +1
            int np = q.poll();

            // 다음 후보 3개
            int[] nArr = { np + 1, np - 1, np * 2 };

            for (int next : nArr) {
                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (visit[next])
                    continue;

                visit[next] = true;
                dist[next] = dist[np] + 1;
                q.offer(next);

                if (next == dest) {
                    System.out.println(dist[next]);
                    return;
                }
            }
        }
    }
}
