import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree; // tree[부모노드] = {자식노드, 자식노드..}
    static boolean[] removed; // 지워진 노드 여부
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[N];
        removed = new boolean[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = 0; // 루트 노드
        for (int i = 0; i < N; i++) {
            // i는 노드, n은 부모노드
            int n = Integer.parseInt(st.nextToken());
            if (n != -1) {
                tree[n].add(i);
            }else if(n == -1){
                root = i;
            }

        }

        int erase = Integer.parseInt(br.readLine());
        removed[erase] = true; // erase 노드도 삭제한 노드니까 true

        if (!removed[root])
            DFS(root);
        System.out.println(result);
    }

    static void DFS(int n) {

        int child = 0;

        for (int nn : tree[n]) {
            if (removed[nn])
                continue;

            child++;
            DFS(nn);
        }

        if (child == 0)
            result++;
    }
}