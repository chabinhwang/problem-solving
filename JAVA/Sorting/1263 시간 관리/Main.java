import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2]; // {[소모시한, 마감시한],....}
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] > b[1])
                return -1;
            else if (a[1] < b[1])
                return 1;
            else
                return 0;
        });
        
        int start = arr[0][1];// 현재 시작 시간
        int i = 0;
        while(start > 0 && i < N){
            // i 증가시키면서 계속 빼기
            if(start < arr[i][1]){
                start -= arr[i][0]; // arr[0] 만큼 시간 소모하기 때문임.
            }else{// 현재 차지된 시간대보다, i번째 업무 마감시간이 이를경우
                start = arr[i][1] - arr[i][0];
            }
            i += 1;
        }
        if(start < 0)System.out.println(-1);
        else System.out.println(start);

    }
}
