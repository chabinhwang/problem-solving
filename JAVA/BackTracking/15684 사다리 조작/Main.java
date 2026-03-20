import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map; // map[r][c] = true면, c와 c+1을 잇는 사다리가 있다는 뜻
    static int min = 4;
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken()); // 이미 놓여있는 가로선 갯수
        H = Integer.parseInt(st.nextToken()); // 가로선
        map = new boolean[H + 1][N + 1]; // 1-start idx

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }
        // 가로선이 연속하거나 서로 접하면 안됨
        DFS(0, 0);
        System.out.println(min == 4 ? -1 : min);
    }

    static void DFS(int depth, int start) {
        if (depth >= min || depth > 3)
            return;
        boolean flag = false;
        for (int i = 1; i < N + 1; i++) {
            int target = i; // 세로선
            for (int j = 1; j < H + 1; j++) { // j 는 가로선
                if (map[j][target]) {
                    target++; // 오른쪽 이동
                } else if (target > 1 && map[j][target - 1]) {
                    target--; // 왼쪽 이동
                }
            }
            if (target != i) {
                flag = true;
                break;
            }
        }
        if (!flag) { // i번 세로선 결과가 전부 i번으로 나온다면
            min = Math.min(min, depth);
            return;
        } else { // i번 - i번으로 안나온다면
            for (int idx = start; idx < H * (N - 1); idx++) {
                int r = idx / (N - 1) + 1;
                int c = idx % (N - 1) + 1;

                if (map[r][c])
                    continue;
                if (c > 1 && map[r][c - 1])
                    continue;
                if (c < N && map[r][c + 1])
                    continue;

                map[r][c] = true;
                DFS(depth + 1, idx + 1);
                map[r][c] = false;
            }

        }

    }
}
