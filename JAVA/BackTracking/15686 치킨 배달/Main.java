import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> home = new ArrayList<>(); // 집 위치. row, col
    static List<int[]> chick = new ArrayList<>(); // 치킨집 위치. row + col
    static int[][] allChickDist; // [homeIdx][chickIdx], 치킨 거리를 value로
    static int min = Integer.MAX_VALUE; // 최소 치킨 거리
    static int M; // 살리는 치킨집 최대 갯수
    static int[] pickedChickIdxArr;

    // start는 start까지 탐색했다. dept는 dept개 탐색했다.
    static void comb(int start, int dept) {
        // pickedChickIdxArr 배열을 다 채운 경우
        if (dept == M) {
            int result = 0;
            for (int i = 0; i < home.size(); i++) {
                int iChickDist = Integer.MAX_VALUE;
                for (int j = 0; j < dept; j++) {
                    // i번째 home과, pricked arr의 j번째를 비교하면서 i번째 home의 치킨 거리
                    iChickDist = Math.min(iChickDist, allChickDist[i][pickedChickIdxArr[j]]);
                }
                result += iChickDist;
            }
            min = Math.min(min, result);
            return;
        }

        // start 인덱스부터, chick 끝까지 중에 하나 dept 인덱스에 넣기.
        for (int i = start; i < chick.size(); i++) {
            pickedChickIdxArr[dept] = i;
            comb(i + 1, dept + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 2 ~ 50
        M = Integer.parseInt(st.nextToken()); // 1 ~ 13
        pickedChickIdxArr = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int[] locate = new int[] { i, j };
                String s = st.nextToken();
                if (s.equals("1")) {
                    home.add(locate);
                } else if (s.equals("2")) {
                    chick.add(locate);
                }
            }
        }

        allChickDist = new int[2 * N][chick.size()]; // 최대 크기가 집 위치는 2N개, 치킨집은 M

        for (int i = 0; i < home.size(); i++) {
            for (int j = 0; j < chick.size(); j++) {
                // i번째 집 위치와, j번째 치킨집 위치 거리 계산해서 allChickDist에 저장
                int[] homes = home.get(i);
                int[] chicks = chick.get(j);
                int homRow = homes[0];
                int homCol = homes[1];
                int chickRow = chicks[0];
                int chickCol = chicks[1];
                allChickDist[i][j] = Math.abs(homRow - chickRow) + Math.abs(homCol - chickCol);
            }
        }
        comb(0, 0);
        System.out.println(min);
    }

}
