import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set; // row * 10 + col 저장. 여기 저장된 좌표들은 비숍 놓을 수 없음
    static List<Integer> isPos; // row * 10 + col. 비숍 놓을 수 있는 좌표 List
    static boolean[] diag1; // 오른쪽 위로 가는 대각선, row + col 일정, true면 뭔가 있다는 것
    static boolean[] diag2; // 오른쪽 아래로 가는 대각선, row - col + N 일정, true면 뭔가 있다는 것
    static int max = 0;
    static int N;
    static int[] dr = { -1, +1, -1, +1 };
    static int[] dc = { -1, -1, +1, +1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isPos = new ArrayList<>();
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];
        set = new HashSet<>();

        ArrayList<Integer> isPosBlack = new ArrayList<>();
        ArrayList<Integer> isPosWhite = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {// 1이면 비숍을 놓을 수 있음 -> isPos 좌표 저장
                    if ((i + j) % 2 == 1) {// 흑색 칸
                        isPosBlack.add(i * 10 + j);
                    } else { // 백색 칸
                        isPosWhite.add(i * 10 + j);
                    }
                }
            }
        }
        isPos = isPosWhite;
        backtrack(0, 0);
        int result = max;
        
        max = 0;
        isPos = isPosBlack;
        backtrack(0, 0);
        result += max;

        System.out.println(result);
    }

    // [row][col]에 놓을 수 있나 확인하고 놓을 수 있다면 저장, 안놓는 경우도 무조건 탐색.
    static void backtrack(int count, int idx) {
        if (count + (isPos.size() - idx) <= max)
            return;
        if (idx < isPos.size()) {
            int row = isPos.get(idx) / 10;
            int col = isPos.get(idx) % 10;
            if (!diag1[row + col] && !diag2[row - col + N]) {// idx꺼 놓을 수 있을때, 놓는 상황
                set.add(row * 10 + col);
                diag1[row + col] = true;
                diag2[row - col + N] = true;
                backtrack(count + 1, idx + 1);
                set.remove(row * 10 + col);
                diag1[row + col] = false;
                diag2[row - col + N] = false;
            }
            backtrack(count, idx + 1); // 안놓는 경우도 무조건 탐색해야 함
        } else { // 마지막 idx 넘은 경우
            max = Math.max(max, count);
            return;
        }

    }
}
