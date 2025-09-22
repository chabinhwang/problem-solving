import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] position = new int[N+1]; // index는 해당 숫자를 의미, value는 해당 숫자의 '순열에서의 위치'를 의미
        int[] permut = new int[N]; // 순열 저장
        boolean[] changed = new boolean[N]; // 변경 여부 저장. 인덱스는 '순열에서의 위치'를 의미
        Arrays.fill(changed, false);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            int target = Integer.parseInt(st.nextToken());
            position[target] = i;
            permut[i]=target;
        }
        for(int i = 0; i < N ; i++){
            int num = permut[i];// 순열 i 번째 숫자
            if(num>1){
                int n_1p = position[num-1];
                if(i < n_1p && !changed[i] && !changed[n_1p]){// i > n_1p : [5,3,4,2,1] 에서 5와 4의 관계. 둘의 위치 변경해야 함
                    changed[i]=true;
                    changed[n_1p]=true;
                    permut[i] = num-1;
                    permut[n_1p] = num;
                    position[num-1] = i;
                    position[num] = n_1p;
                }
            }
        }
        for(int i = 0; i < N; i++)bw.write(String.valueOf(permut[i])+" ");
        bw.flush();
        bw.close();
    }
}