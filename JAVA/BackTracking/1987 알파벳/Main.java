import java.util.*;
import java.io.*;

public class Main {

    static Set<String> set = new HashSet<>();
    static int max = 1;
    static String[][] arr;
    static int R;
    static int C;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];

        for(int i = 0; i < R; i++){
            arr[i] = br.readLine().split("");
        }

        // 시작점은 항상 arr[0][0]
        // "온" 방향 0: 상단, 1: 우단, 2: 하단, 3: 좌단
        DFS(0,0,3);
        DFS(0,0,0);
        System.out.println(max);

    }


    // dirction이 "온 방향" 말함. 0: 상단, 1: 우단, 2: 하단, 3: 좌단
    public static void DFS(int row, int col, int direction){
        // 현재 위치로 못 오는 경우 그냥 return
        int prevSize = set.size();
        set.add(arr[row][col]);
        if(prevSize == set.size()){
            return;
        }
        // direction 방향 빼고, 나머지 방향으로만 가야 함

        if(direction != 0 && row - 1 >= 0){// 상단으로 갈 수 있는 경우
            DFS(row - 1, col,2);
        }
        if(direction != 2 && row + 1 < R){// 하단으로 갈 수 있는 경우
            DFS(row + 1, col, 0);
        }if(direction != 3 && col - 1 >= 0){// 좌단으로 갈 수 있는 경우
            DFS(row, col - 1, 1);
        }
        if(direction != 1 && col + 1 < C){// 우단으로 갈 수 있는 경우
            DFS(row, col + 1, 3);
        }
        // 더 이상 갈 수 있는 곳이 없다면 1. max 업데이트 - set 길이로
        // 2. set에서 arr[row][col] 문자 제외하기 - DFS임
        max = Math.max(max, set.size());
        set.remove(arr[row][col]);

    }
}
