import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 크레인 수
        ArrayList<Integer> tool = new ArrayList<>(); // 크레인 무게 한도 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            tool.add(t);
        }

        ArrayList<Integer> box = new ArrayList<>(); // 박스 무게 배열
        int M = Integer.parseInt(br.readLine()); // 박스 수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int t = Integer.parseInt(st.nextToken());
            box.add(t);
        }

        Collections.sort(tool, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (box.get(0) > tool.get(0)) {// 최고 크레인보다 물건이 더 무거운 경우 -1출력하고 끝.
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!box.isEmpty()) {
            int boxIdx = 0;
            int toolIdx = 0;
            while (toolIdx < N && boxIdx < box.size()) {
                if (tool.get(toolIdx) >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    toolIdx += 1;
                } else {
                    boxIdx += 1;
                }
            }
            time += 1;
        }
        System.out.println(time);
    }

}
