import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][M];
        
        for(int i = 0; i < N; i ++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                arr[i][j] = c[j] - '0';
            }
        }

        int[] dr = {-1, 0 , 1, 0};
        int[] dc = {0, -1, 0, 1};

        boolean[][] visit = new boolean[N][M];
        int[][] dist = new int[N][M]; // 칸 수 저장
        visit[0][0] = true;
        dist[0][0] = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] ar = q.poll();
            int r = ar[0];
            int c = ar[1];
            for(int i = 0 ; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && arr[nr][nc] != 0){
                    visit[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}
