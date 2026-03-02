import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 목적지

        int[] dist = new int[100_001]; // idx 칸에 가는 데 걸리는 시간 최소값
        Arrays.fill(dist, Integer.MAX_VALUE); // 0-1 BFS이므로, 시간비교를 위해 최대값으로 초기화
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(N);
        dist[N] = 0;

        while(true){
            int cur = q.poll();
            if(cur == K){
                System.out.println(dist[cur]);
                return;
            }

            // +1이랑 -1은 시간 1초 추가해야 함
            int[] nArr = {cur + 1, cur - 1};
            for(int n : nArr){
                if(n >= 0 && n <= 100_000 && dist[n] > dist[cur] + 1){ // cur + 1초 보다 n가는게 더 걸리면, cur에서 1초 써서 n 가는게 더 빠르니 업데이트
                    dist[n] = dist[cur] + 1;
                    q.offer(n);
                }
            }

            // *2는 시간 소모 안함
            if(cur * 2 <= 100_000 && cur * 2 >= 0 && dist[cur * 2] > dist[cur]){
                dist[cur * 2] = dist[cur];
                q.offerFirst(cur * 2);
            }
        }
        

    }

}
