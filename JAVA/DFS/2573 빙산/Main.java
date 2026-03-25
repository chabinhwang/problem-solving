import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static ArrayList<Integer> list = new ArrayList<>(); // row * 300 + col 이 저장되어 있음. 녹으면
                                                        // list.remove(Integer.valueOf(3))으로 값 삭제.
    static int year = 0;
    static boolean[][] visit;
    static int N;
    static int M;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                arr[i][j] = t;
                if (t != 0) { // 빙산인 경우 list에도 추가
                    list.add(i * 300 + j);
                }
            }
        }
        progress();
    }

    static void progress() {
        year += 1;

        int[][] nextArr = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            nextArr[i] = arr[i].clone();
        }
        ArrayList<Integer> removeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int target = list.get(i);
            int r = target / 300;
            int c = target % 300;
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];
                // 주변에 바닷물이 있는 경우
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] == 0 && nextArr[r][c] > 0) {
                    nextArr[r][c] -= 1;
                    if (nextArr[r][c] == 0) {
                        removeList.add(Integer.valueOf(r * 300 + c));
                        break;
                    }
                }
            }
        }
        list.removeAll(removeList);

        // 만일 list.size()가 0인데도 안나뉘었다면 0 출력
        if (list.size() == 0) {
            System.out.println(0);
            return;
        } else {
            // list의 첫번째 값으로 DFS돌았을 때, DFS결과가 list.size()와 다르면 나뉜 것.
            arr = nextArr;
            int init = list.get(0);
            int r = init / 300;
            int c = init % 300;

            visit = new boolean[N][M];
            visit[r][c] = true;
            if (DFS(r, c) != list.size()) {
                System.out.println(year);
                return;
            } else {
                progress();
            }
        }
    }

    // 2개로 나뉘었는지 확인
    static int DFS(int r, int c) {
        int result = 1;
        for (int j = 0; j < 4; j++) {
            int nr = r + dr[j];
            int nc = c + dc[j];
            // 주변에 바닷물이 있는 경우
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] != 0 && !visit[nr][nc]) {
                visit[nr][nc] = true;
                result += DFS(nr, nc);
            }
        }
        return result;
    }
}
