import java.io.*;

public class Main {
    static int N;
    static int result = 0;
    static int[] col; // col[i] = i행의 퀸이 놓인 열 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];// col[i]=j 는 i행 j열에 퀸이 있다는 뜻

        backtrack(0); // 0번째 행부터 시작
        System.out.println(result);
    }

    // depth: 현재 행
    static void backtrack(int depth) {
        if(depth==N){
            result++;
            return;
        }
        for(int i = 0; i<N; i++){
            col[depth]=i;
            if(isValid(depth)){
                backtrack(depth+1);
            }
        }
    }

    // 퀸을 놓을 수 있는 자리인지 검사
    static boolean isValid(int row) {
        for(int i=0;i<row;i++){
            if(col[i]==col[row])return false;
            if(Math.abs(col[i]-col[row])==Math.abs(row-i))return false;
        }return true;
    }
}