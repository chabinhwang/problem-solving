import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxN = 0; // 최빈값
        int maxCount = 0;
        ArrayList<Integer> maxCandidate = new ArrayList<>(); // 최빈값 후보 리스트
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            int target = Integer.parseInt(br.readLine());
            sum += target;
            arr[i] = target;
            map.merge(target, 1, (oldValue, newValue) -> oldValue + newValue);

            if(map.get(target) > maxCount){
                maxN = target;
                maxCount = map.get(target);
                maxCandidate.clear();
                maxCandidate.add(maxN);
            }else if(map.get(target) == maxCount){ // 현재 최빈값과 갯수가 같다면, 최빈값 후보 리스트에 추가
                maxCandidate.add(target);
            }
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        if(maxCandidate.size() > 1){
            Collections.sort(maxCandidate);
            maxN = maxCandidate.get(1);
        }

        long avg = Math.round((double) sum / N);
        sb.append(avg).append("\n")                 // 산술평균
            .append(arr[(N - 1) / 2]).append("\n")  // 중앙값
            .append(maxN).append("\n")              // 최빈값
            .append(arr[N-1] - arr[0]);                 // 범위
        System.out.println(sb);
    }
}
