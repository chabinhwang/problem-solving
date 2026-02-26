import java.io.*;
import java.util.*;

public class Main {
    static int K; // 등수 차이, K 등수 차이를 넘으면 좋은 친구 탈락
    static long result = 0; // 좋은 친구 수

    // 학생 글자수별 queue 운영(2글자 ~ 20글자 이므로, 총 19개면 됨). idx는 0 은 2글자, 1은 3글자..
    static ArrayDeque<Integer>[] q; // 각 q별 저장하는 값은 "해당 친구 등수"

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 반 학생의 이름(성적순) 수
        K = Integer.parseInt(st.nextToken());

        q = new ArrayDeque[19];
        for (int i = 0; i < 19; i++) {
            q[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int len = s.length();
            count(i, len);
        }
        System.out.println(result);
    }

    static void count(int prizeNum, int len) {
        int qIdx = len - 2;// q는 0부터 시작하기 때문에, 2글자 이름이면 0
        if (q[qIdx].size() == 0) {
            q[qIdx].offer(prizeNum);
        } else {
            while (!q[qIdx].isEmpty()) {
                if (prizeNum - q[qIdx].peek() > K) { // q의 맨 앞 친구와 K 이상 차이나는 경우
                    q[qIdx].poll();
                } else { // q 안에 좋은 친구만 남은 경우
                    break;
                }
            }
            result += q[qIdx].size();
            q[qIdx].offer(prizeNum);
        }
    }
}
