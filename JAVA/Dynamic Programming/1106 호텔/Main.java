import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 목표 최소 고객 증가분
        int N = Integer.parseInt(st.nextToken());
        int[][] citys = new int[N+1][2]; // 도시 홍보 {비용, 고객 증가분}
        citys[0][0]=0;
        citys[0][1]=0;
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            citys[i][0] = Integer.parseInt(st.nextToken());
            citys[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[C+101]; // index는 유치하는 인원, value는 최소 비용
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int j = 1; j < citys.length; j++){ // city 인덱스
            int cost = citys[j][0];
            int value = citys[j][1];

            for(int i = value; i < dp.length; i++){ // dp 인덱스
                if(dp[i-value]!=Integer.MAX_VALUE){ // 인원(i)보다, 해당 city 최소 증가분이 작은 경우만 계산 가능
                    dp[i] = Math.min(dp[i-value]+cost,dp[i]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = C; i < dp.length; i++){
            result = Math.min(result,dp[i]);
        }
        System.out.println(result);
    }
}
