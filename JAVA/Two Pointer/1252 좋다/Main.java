import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            arr[i] = target;
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int target = arr[i]; // 찾고자 하는 값
            int left = 0;
            int right = N - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    if (left == i) {
                        left++;
                    } else if (right == i) {
                        right--;
                    } else {
                        result++;
                        break;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(result);
    }
}