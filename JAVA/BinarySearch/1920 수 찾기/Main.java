import java.io.*;
import java.util.*;

public class Main {
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (isIncluded(target))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    // n이 arr 1에 존재하는지 BinarySearch로 찾기
    static boolean isIncluded(int n) {
        int mid;
        int low = 0;
        int high = arr1.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr1[mid] == n) return true;
            else if (arr1[mid] > n) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
