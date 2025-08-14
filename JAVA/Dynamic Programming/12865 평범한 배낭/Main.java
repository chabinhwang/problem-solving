import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        int[][] knapsack = new int[N+1][K+1]; // 인덱스가 N까지, 무게가 K까지여야 함.'가치' 저장함.
        int[][] stuff = new int[K][2];//[k][0]은 무게, [1]은 가치
        
        for(int n = 0; n < N; n++){
            temp = br.readLine().split(" ");
            stuff[n][0] = Integer.parseInt(temp[0]);
            stuff[n][1] = Integer.parseInt(temp[1]);
        }

        for(int i = 0; i < N+1; i++){
            Arrays.fill(knapsack[i],0);
        }
        
        for(int n = 1; n < N+1; n++){
            for(int k = 1; k < K+1; k++){
                if(k<stuff[n-1][0]){ // 가방의 최대 무게 k보다, i번째 물건의 무게가 더 무거운 경우 - 물건 더 추가 불가
                    knapsack[n][k] = knapsack[n-1][k];
                }else{ // 추가 가능할 수 있는 경우 - knapsack[i-1][k]과 knapsack[i-1][k-물건 무게]+ 물건 가치 중 최대값
                    knapsack[n][k] = Math.max(knapsack[n-1][k],knapsack[n-1][k-stuff[n-1][0]]+stuff[n-1][1]);
                }
            }
        }
        System.out.println(knapsack[N][K]);
    }
}