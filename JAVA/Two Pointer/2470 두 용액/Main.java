import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // -99 -2 -1 2 98

        int left = 0;
        int right = N - 1;
        long property = 0;
        long min = Long.MAX_VALUE;
        int rL = left; // min이 업데이트될때 left
        int rR = right; // min이 업데이트될때 right
        while(left < right){
            property = arr[left] + arr[right];
            if(min - 0 > Math.abs(property)){ // 0으로부터 거리가 property가 더 가까울 때
                rL = left;
                rR = right;
                min = Math.abs(property);
            }
            if(property > 0){
                right -= 1;
            }else if(property < 0){
                left += 1;
            }else{
                break;
            }
        }
        System.out.println(arr[rL]+" "+arr[rR]);
    }
}
