import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // col
        int M = Integer.parseInt(st.nextToken()); // row
        // 원래는 N - M 이 row - col 이지만, 이 문제는 반대로 제공, 근데 반대로 해석해서 꼬였음.
        ArrayDeque<ArrayList<int[]>> q = new ArrayDeque<>(); // [[row,col],[row,col]...]인 arrayList가 저장됨. 시간 계산 때문에.
        boolean[][] isNot = new boolean[M][N]; // 안익은 토마토 위치
        boolean[][] isVisit = new boolean[M][N]; // 방문 여부

        int countNot = 0;
        ArrayList<int[]> first = new ArrayList<>();
        for (int row = 0; row < M; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                int tomato = Integer.parseInt(st.nextToken());
                if (tomato == 1) { // 익은 토마토인 경우
                    first.add(new int[] { row, col });
                    isVisit[row][col] = true;
                } else if (tomato == -1) { // 빈칸인 경우
                    isNot[row][col] = true;
                    isVisit[row][col] = true;
                    countNot += 1;
                } // 나머지는 모두 안익은 토마토이므로, 따로 저장하지 않음.
            }
        }
        q.offer(first); // 처음 저장

        int countTomato = first.size(); // 익은 토마토 count

        // 만일 모든 토마토가 익었다면 0 출력
        if (countNot + countTomato == N * M) {
            System.out.println(0);
            return;
        }

        int time = 0;
        while (q.size() != 0) {
            ArrayList<int[]> targetList = q.poll(); // 전파할 기준 토마토 리스트
            ArrayList<int[]> ar = new ArrayList<>(); // 다음 대상 토마토 리스트

            for (int i = 0; i < targetList.size(); i++) {
                int[] arr = targetList.get(i);
                int row = arr[0];
                int col = arr[1];
                // 범위를 안 벗어나면서, 방문 안한 토마토에만 접근
                if (row + 1 < M && !isVisit[row + 1][col]) {
                    ar.add(new int[] { row + 1, col });
                    isVisit[row + 1][col] = true;
                    countTomato += 1;
                }
                if (col + 1 < N && !isVisit[row][col + 1]) {
                    ar.add(new int[] { row, col + 1 });
                    isVisit[row][col + 1] = true;
                    countTomato += 1;
                }
                if (row - 1 >= 0 && !isVisit[row - 1][col]) {
                    ar.add(new int[] { row - 1, col });
                    isVisit[row - 1][col] = true;
                    countTomato += 1;
                }
                if (col - 1 >= 0 && !isVisit[row][col - 1]) {
                    ar.add(new int[] { row, col - 1 });
                    isVisit[row][col - 1] = true;
                    countTomato += 1;
                }
                isVisit[row][col] = true;
            }
            if (ar.size() != 0) {
                q.offer(ar);
                time += 1;
            }
        }
        if(countTomato + countNot == N * M) System.out.println(time);
        else System.out.println(-1);
    }

}
