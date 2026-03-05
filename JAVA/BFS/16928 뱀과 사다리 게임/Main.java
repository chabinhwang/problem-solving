import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개 줄에 사다리 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            ladder.put(dep, dest);
        }

        // M개 줄에 뱀의 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            snake.put(dep, dest);
        }

        visited = new boolean[101];
        visited[1] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>(); // [몇번째 주사위인지, 위치는 어딘지]
        q.offer(new int[] { 0, 1 });
        while (!q.isEmpty()) {
            // q에 있는 위치부터, 주사위 1~6 나오는 경우 "이동 완료 후 위치" 전부다 q에 때려박기
            int[] arr = q.poll();
            int count = arr[0];
            int now = arr[1];
            for (int i = 1; i <= 6; i++) {
                int result = now + i;
                if (ladder.containsKey(result)) {       // 이동 완료 후 위치에 사다리 있는 경우
                    result = ladder.get(result);
                } else if (snake.containsKey(result)) { // 이동 완료 후 위치에 뱀 있는 경우
                    result = snake.get(result);
                }
                if(!visited[result]){
                    visited[result] = true;
                    q.offer(new int[] { count + 1, result });
                }
                if(result >= 100){
                    System.out.println(count+1);
                    return;
                }
            }
        }
    }
}
