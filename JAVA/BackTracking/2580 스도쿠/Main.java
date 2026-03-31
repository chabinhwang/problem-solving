import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[9][9]; // 9 x 9
    static ArrayList<int[]> empty = new ArrayList<>();
    static ArrayList<Integer>[] notUse = new ArrayList[9]; // notUse[i]에 들어있는 숫자는, i row에서 사용하지 않는 숫자.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            notUse[i] = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if (input == 0) {
                    empty.add(new int[] { i, j });
                }
                notUse[i].remove(Integer.valueOf(input));
            }
        }
        DFS(0);
    }

    // empty의 idx번째 칸의 숫자 결정
    static void DFS(int idx){
        // 마지막인 경우
        if(idx == empty.size()){
            // 출력
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int[] rc = empty.get(idx);
        int row = rc[0];
        int col = rc[1];
        
        // 사용안된 숫자 하나씩 넣어보기(복구해야함, 백트래킹이라)
        for(int i = 0; i < notUse[row].size(); i++){
            int input = notUse[row].get(i);
            if(duplicateCheck(row, col,input)){ // 통과하면 아래 진행, 실패 시 다음 값
                notUse[row].remove(Integer.valueOf(input));
                map[row][col] = input;
                DFS(idx + 1);
                map[row][col] = 0;
                notUse[row].add(i, input);
            }

        }

    }
    
    // input 값이, 세로랑 정사각형 안에 있나 확인. -> 없으면(추가가능하면) true
    static boolean duplicateCheck(int row, int col, int input){
        // 세로 줄에서 input과 같은 값이 있는 경우 false
        for(int i = 0; i < 9; i++){
            if(map[i][col] == input){
                return false;
            }
        }
        // 정사각형안에서, input과 같은 값이 있는 경우 false
        int targetRow = (row / 3) * 3; // 4 -> 3에서, 1 -> 0에서, 8 -> 6에서
        int targetCol = (col / 3) * 3;
        for(int i = 0; i < 9; i++){
            int dr = i / 3;
            int dc = i % 3;
            if(map[targetRow + dr][targetCol + dc] == input){
                return false;
            }
        }
        return true;
    }
}
