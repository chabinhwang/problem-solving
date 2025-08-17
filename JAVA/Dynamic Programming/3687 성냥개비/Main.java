import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[] nums = {6,2,5,5,4,5,6,3,7,6}; // 인덱스가 숫자, 값이 성냥개비 갯수
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[] minDp = new long[101];
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2]=1;
        minDp[3]=7;
        minDp[4]=4;
        minDp[5]=2;
        minDp[6]=6;
        minDp[7]=8;
        minDp[8]=10;

        for(int i = 9; i < 101; i++){
            for(int j = 0; j<10; j++){
                if(i>nums[j]){
                    minDp[i] = Math.min(minDp[i], minDp[i-nums[j]]*10+j);

                }
            }
        }

        for(int i = 0; i < N; i++){
            int count = Integer.parseInt(br.readLine());// 성냥개비 갯수(전부 사용해야 함)
            long minResult = minDp[count];
            String maxResult = "";
            int high = count / 2; // 몫.
            int low = count % 2; //홀수면 1, 짝수면 0
            for(int j = 0; j<high-1;j++){
                maxResult+="1";
            }
            maxResult = (low==1?"7":"1") + maxResult;
            bw.write(minResult+" "+maxResult);
            bw.newLine();
        }
        bw.flush();
        bw.close();

        
    }
}
