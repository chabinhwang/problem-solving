import java.util.*;
import java.io.*;

public class Main {
    public static int[] parent;// 인덱스 n의 부모는 누구인지 저장. 부모가 같으면 같은 union
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1]; // 0부터 n까지
        
        for(int i = 0; i < N + 1; i++){// 0부터 N까지 넣어야 함
            parent[i] = i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int direct = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(direct == 0){ // a 집합에 b 집합 편입
                union(a,b);
            }else if(direct == 1){// a와 b가 같은 집합인지(같은 부모인지)
                bw.write(findParent(a) == findParent(b)? "YES" : "NO");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    public static int findParent(int n){
        if(n == parent[n]){
            return n;
        }else{
            return findParent(parent[n]);
        }
    }

    // a집합으로 b집합 편입
    public static void union(int a, int b){
        // b의 parent의 parent를 a의 parent로 초기화(같은 집합)
        int aParent = findParent(a);
        int bParent = findParent(b);
        parent[bParent] = aParent;
    }
}
