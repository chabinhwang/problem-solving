import java.io.*;
import java.util.*;

public class Main {
    static int W, N;
    static int[][] ev;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        W = Integer.parseInt(br.readLine().trim());
        N = Integer.parseInt(br.readLine().trim());
        ev = new int[N+1][2];
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            ev[i][0] = Integer.parseInt(st.nextToken());
            ev[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp[a][b] = 사건 max(a,b)까지 처리,
        // 1번차 마지막=a, 2번차 마지막=b 일 때의 누적 최소 이동거리
        int[][] dp = new int[N+1][N+1];
        for(int[] row: dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        // 경로 복원을 위한 parent와 담당자 기록
        // parA[a][b], parB[a][b] = (a,b) 상태의 직전 상태
        // who[a][b] = 이 상태로 올 때 사건 t를 맡은 경찰 (1 또는 2)
        int[][] parA = new int[N+1][N+1];
        int[][] parB = new int[N+1][N+1];
        int[][] who  = new int[N+1][N+1];
        for(int[] r: parA) Arrays.fill(r, -1);
        for(int[] r: parB) Arrays.fill(r, -1);
        for(int[] r: who)  Arrays.fill(r,  0);

        for(int a=0; a<=N; a++){
            for(int b=0; b<=N; b++){
                int cur = dp[a][b];
                if(cur == INF) continue;
                int t = Math.max(a, b) + 1;
                if(t > N) continue;

                // 사건 t를 1번차가 처리 -> (t, b)
                int cost1 = cur + dist1(a, t);
                if(cost1 < dp[t][b]){
                    dp[t][b] = cost1;
                    parA[t][b] = a;
                    parB[t][b] = b;
                    who[t][b]  = 1;
                }

                // 사건 t를 2번차가 처리 -> (a, t)
                int cost2 = cur + dist2(b, t);
                if(cost2 < dp[a][t]){
                    dp[a][t] = cost2;
                    parA[a][t] = a;
                    parB[a][t] = b;
                    who[a][t]  = 2;
                }
            }
        }
        // 최종 상태 선택 (max(a,b)=N 중 최솟값)
        int ans = INF;
        int endA = -1, endB = -1;
        for(int a=0; a<=N; a++){
            if(dp[a][N] < ans){
                ans = dp[a][N];
                endA = a; endB = N;
            }
        }
        for(int b=0; b<=N; b++){
            if(dp[N][b] < ans){
                ans = dp[N][b];
                endA = N; endB = b;
            }
        }
        // 경로 복원 (뒤에서부터)
        int[] assign = new int[N+1]; // assign[t] = 1 or 2
        int a = endA, b = endB;
        int t = Math.max(a, b);
        while(t > 0){
            assign[t] = who[a][b];
            int pa = parA[a][b];
            int pb = parB[a][b];
            a = pa; b = pb;
            t--;
        }
        // 출력
        bw.write(String.valueOf(ans));
        bw.newLine();
        for(int i=1;i<=N;i++){
            bw.write(String.valueOf(assign[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int dist1(int from, int to){ // 1번차 기준 거리: from==0이면 (1,1)
        int x1 = (from==0) ? 1 : ev[from][0];
        int y1 = (from==0) ? 1 : ev[from][1];
        int x2 = ev[to][0], y2 = ev[to][1];
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    static int dist2(int from, int to){ // 2번차 기준 거리: from==0이면 (W,W)
        int x1 = (from==0) ? W : ev[from][0];
        int y1 = (from==0) ? W : ev[from][1];
        int x2 = ev[to][0], y2 = ev[to][1];
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}