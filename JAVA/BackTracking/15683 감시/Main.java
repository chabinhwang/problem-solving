import java.util.*;
import java.io.*;

public class Main {
    static int[][][] dir = {
            {}, // dummy
            { { 0 }, { 1 }, { 2 }, { 3 } }, // 1번 CCTV
            { { 0, 2 }, { 1, 3 } }, // 2번 CCTV
            { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3번 CCTV
            { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } }, // 4번 CCTV
            { { 0, 1, 2, 3 } } // 5번 CCTV
    };
    // 0 위, 1 오른, 2 아래, 3 왼
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static int[][] arr;// 0 빈칸, 6 벽, 1~5 CCTV(90도 회전 가능)
    static int count = Integer.MAX_VALUE; // 안 가려지는 부분 최댓값 저장(CCTV 위치도 포함)
    static ArrayList<int[]> cctv; // cctv 배열
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        arr = new int[N][M];
        cctv = new ArrayList<>();

        // 입력받고, cctv의 경우 따로 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                if (n > 0 && n < 6)
                    cctv.add(new int[] { i, j });
            }
        }

        int[][] map = copy(arr); // 백트래킹용 array(복사해서 사용, 사각지대는 0)
        DFS(0, map);
        System.out.println(count);
    }

    // depth: cctv 인덱스. 해당 idx의 cctv를 회전시키는 모든 경우의 수로 배치한 뒤 재귀 DFS.
    static void DFS(int depth, int[][] map) {
        if(depth == cctv.size()){
            count(map);
            return;
        }
        int[] rc = cctv.get(depth);
        // cctv 놓인 row,col
        int row = rc[0];
        int col = rc[1];
        int type = arr[row][col];
        for(int[] dest : dir[type]){
            int[][] cloneMap = copy(map);
            for(int d: dest){
                watch(row,col,d,cloneMap);
            }
            DFS(depth + 1, cloneMap);
        }

    }

    // map 복사해서 사용 -> 백트래킹 시 복원 안해도 되게끔
    static int[][] copy(int[][] map) {
        int[][] cloneMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }
        return cloneMap;
    }

    // map -1은 감시중인 지역
    static void watch(int r, int c, int d, int[][] map) {
        while (true) {
            r += dr[d];
            c += dc[d];
            if (r < 0 || c < 0 || r >= N || c >= M)
                break;
            if (arr[r][c] == 6)
                break;
            if (map[r][c] == 0)
                map[r][c] = -1;
        }
    }

    static void count(int[][] map) {
        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    n += 1;
                }
            }
        }
        count = Math.min(count,n);
    }

}
