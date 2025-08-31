import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long[][][] dp = new long[101][101][101]; // 저장하는 값은 경우의 수

            dp[1][1][1]=1;
        for(int i = 2; i<N+1; i++){
            dp[i][i][1]=1;
            dp[i][1][i]=1;
            for(int j = 1; j<L+1; j++){
                for(int k = 1; k<R+1; k++){
                    dp[i][j][k] = (dp[i-1][j][k]*(i-2) + dp[i-1][j-1][k] + dp[i-1][j][k-1])%1000000007;
                }
            }
        }
        System.out.println(dp[N][L][R]);
    }
}
