import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            if (DFS(i,1) >= 5) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    static int DFS(int n, int dept){
        int max = 1;
        if(visit[n]) return max;
        if(dept >= 5) return max;
        visit[n] = true;
        for(int i = 0; i < arr[n].size(); i++){
            if(!visit[arr[n].get(i)]){ // n과 i가 친구면서, i를 이전에 방문 안한 경우
                max = Math.max(max, DFS(arr[n].get(i), dept + 1) + 1);
            }
        }
        visit[n] = false;
        return max;
    }
}
