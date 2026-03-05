import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료 시간 추가
        int[][] arr = new int[N][2]; // [[시작시간, 종료시간]..]
        StringTokenizer st;
        int count = 1; // 강의실은 최소 1개 사용하기 때문에, count = 1
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < N; i++){
            int s = arr[i][0];
            int t = arr[i][1];
            if(pq.isEmpty()){ // 비어있다면, 종료 시간 추가
                pq.offer(t);
            }else{
                if(pq.peek() <= s){ // 현재 가장 빨리 끝나는 강의 이어서 i번째 강의 시작 가능한 경우 -> count 안올림
                    pq.poll();
                }else{
                    count += 1;
                }
                pq.offer(t);
            }
        }
        
        
        System.out.println(count);
    }
}
