import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2]; // [[짐 무게, 정렬 전 인덱스], ...]

        for(int i = 0; i < N ; i++){
            int lug = Integer.parseInt(br.readLine());
            arr[i][0]=lug;
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int[] visited = new int[N];
        
        Arrays.fill(visited,0);//0이면 미방문, 1이면 방문

        int price = 0;

        for(int i = 0; i < N; i++){
            if(visited[i]==1){
                continue;
            }else{
                int next = i;
                int cycle = 0;
                while(visited[next]==0){
                    price += arr[next][0];
                    visited[next]=1;
                    next = arr[next][1];
                    cycle += 1;
                }
                price += Math.min(arr[i][0] * (cycle - 2), arr[0][0] * (cycle+1) + arr[i][0]);
            }
        }
        bw.write(String.valueOf(price));
        bw.newLine();
        bw.flush();
        bw.close();


    }
}