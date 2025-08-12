import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] gems = new int[N][2];
        int[] bags = new int[K];

        for(int i = 0; i < N; i++){ // 보석
            String temp = br.readLine();
            String[] temps = temp.split(" ");
            int mi = Integer.parseInt(temps[0]);
            int vi = Integer.parseInt(temps[1]);
            gems[i][0] = mi; // 무게
            gems[i][1] = vi; // 가격
        }
        for(int i = 0; i < K; i++){ // 가방
            bags[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(gems,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }return a[0]-b[0];
        }); // 1. 무게, 2. 가격 ASC 정렬
        Arrays.sort(bags);


        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[1]-a[1]); // pq는 가격 기준으로 DESC 정렬
        long result = 0;

        int i = 0;

        for (int cap : bags) {
            while (i < N && gems[i][0] <= cap) { // 가방에 들어갈 수 있는 보석들 추가
                pq.offer(gems[i]);
                i++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll()[1];
            }
        }


        System.out.println(result);

    }
}