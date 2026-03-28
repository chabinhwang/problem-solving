import java.util.*;
import java.io.*;

public class Main {
    static int[][] map; // 0은 빈칸, 1이 벽, 2가 바이러스
    static int[][] visit;
    static ArrayList<int[]> virous = new ArrayList<>();
    static ArrayList<int[]> empty = new ArrayList<>();
    static ArrayList<int[]> wall = new ArrayList<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if (input == 2) {
                    virous.add(new int[] { i, j });
                } else if (input == 1) {
                    wall.add(new int[] { i, j });
                } else {
                    empty.add(new int[] { i, j });
                }
            }
        }

        int max = 0;
        int size = empty.size();
        // 조합
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {

                    // 벽 세우기
                    int[] a = empty.get(i);
                    int[] b = empty.get(j);
                    int[] c = empty.get(k);

                    int[][] copy = new int[N][M];
                    for (int l = 0; l < N; l++) {
                        copy[l] = map[l].clone();
                    }
                    copy[a[0]][a[1]] = 1;
                    copy[b[0]][b[1]] = 1;
                    copy[c[0]][c[1]] = 1;

                    q.clear();
                    q.addAll(virous);
                    // BFS 실행
                    while (!q.isEmpty()) {
                        int[] v = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = v[0] + dr[d];
                            int nc = v[1] + dc[d];

                            // 범위 체크
                            if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                                continue;

                            // 빈칸일 때만 퍼짐
                            if (copy[nr][nc] == 0) {
                                copy[nr][nc] = 2; // 감염
                                q.add(new int[] { nr, nc });
                            }
                        }
                    }
                    int safe = 0;
                    for (int x = 0; x < N; x++) {
                        for (int y = 0; y < M; y++) {
                            if (copy[x][y] == 0)
                                safe++;
                        }
                    }
                    max = Math.max(max, safe);
                }
            }
        }
        System.out.println(max);
    }
}
