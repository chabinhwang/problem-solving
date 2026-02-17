import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        boolean[][] appleArr = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            appleArr[x - 1][y - 1] = true;
        }

        int L = Integer.parseInt(br.readLine());
        String[][] logArr = new String[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            logArr[i][0] = st.nextToken();
            logArr[i][1] = st.nextToken();
        }

        // 오른쪽 → 아래 → 왼쪽 → 위 (시계방향)
        int[] dR = { 0, 1, 0, -1 };
        int[] dC = { 1, 0, -1, 0 };

        int logIdx = 0;
        int dIdx = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] isSnake = new boolean[N][N];

        int x = 0;
        int y = 0;
        int time = 0;

        q.offer(new int[] { x, y });
        isSnake[x][y] = true;

        while (true) {
            time++;

            int nextX = x + dR[dIdx];
            int nextY = y + dC[dIdx];

            // 벽 충돌
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                System.out.println(time);
                return;
            }
            boolean hasApple = appleArr[nextX][nextY];
            // 자기 몸 충돌
            if (isSnake[nextX][nextY]) {
                System.out.println(time);
                return;
            }
            // 사과 없으면 꼬리 제거
            if (!hasApple) {
                int[] tail = q.poll();
                isSnake[tail[0]][tail[1]] = false;
            }



            // 머리 추가
            q.offer(new int[] { nextX, nextY });
            isSnake[nextX][nextY] = true;
            x = nextX;
            y = nextY;
            if (hasApple) {
                appleArr[nextX][nextY] = false;
            }
            // 이동 끝난 뒤 방향 전환
            if (logIdx < L && Integer.parseInt(logArr[logIdx][0]) == time) {
                if (logArr[logIdx][1].equals("L")) {
                    dIdx = (dIdx == 0) ? 3 : dIdx - 1;
                } else {
                    dIdx = (dIdx == 3) ? 0 : dIdx + 1;
                }
                logIdx++;
            }
        }
    }
}