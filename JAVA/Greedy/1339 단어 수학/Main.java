import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char a = 'A'; // 기준값
        int N = Integer.parseInt(br.readLine());
        int[] alp = new int[26];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                int idx = c[j] - a;                              // 어느 영어 문자가 들어왔는지 인덱스
                alp[idx] += (int) Math.pow(10, c.length - 1 - j);  // 자릿수, 1의 자릿수(j=c.length-1)인 경우는 1
            }
        }
        // alphabat 배열 정렬해도 되는 이유 -> 어차피 10개 이하, 그리고 가장 큰 저장값부터 9 곱해주면 됨.
        Arrays.sort(alp);
        // 내림차순 정렬 안되기 때문에, 뒤에 값 10개 사용
        int result = 0;
        for (int i = 9; i >= 0; i--) {
            result += alp[25 - i] * (9 - i);
        }
        System.out.println(result);
    }
}