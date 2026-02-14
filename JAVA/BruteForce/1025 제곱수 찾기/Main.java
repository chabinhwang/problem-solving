import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        int[][] sheet = new int[N][M];

        for(int i = 0; i < N; i++){
            String inputNums = br.readLine();
            String[] inputNumArr = inputNums.split("");
            for(int j = 0; j < M; j++){
                sheet[i][j] = Integer.parseInt(inputNumArr[j]);
            }
        }
        // 0,0부터 row, col 등차가 -k~k인 모든 경우 다 계산해서 제곱근이 정수(!-1)일때 그 제곱근 저장
        // x 기준, 0부터 9까지 있을때 3이면 등차 -3 ~ 6까지. 그리고 0이랑 9 안넘어가는지 확인하면 됨.
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // i,j 기준으로 탐색 시작. row좌표의 등차는 rn, col좌표의 등차는 cn이라고 함
                for(int rn = -i; rn < N-i; rn++){// 만약 N이 9, i가 3이면, 등차는 -3 ~ 5 가능(index여서 0~8까지임)
                    for(int cn = -j; cn < M-j; cn++){
                        if(rn == 0 && cn == 0) {
                            result = Math.max(result, sqrtInt(sheet[i][j]));
                            continue;
                        } // 공차가 둘다 0인경우 무한루프
                        int candidate = 0;// 제곱수 후보
                        int count = 0;// 등차 몇번 적용했는지

                        while(true){// rn과 cn을 전부 적용하면서, 둘 중 하나라도 범위 밖이면 break
                            int row = count * rn + i;
                            int col = count * cn + j;
                            if(row >= N || row < 0 || col >= M || col < 0) break;
                            candidate = candidate * 10 + sheet[row][col];
                            result = Math.max(result, sqrtInt(candidate));
                            count+=1;
                        }

                    }
                }


            }
        }
        if(result == -1){
            System.out.println(result);
        }else{
            System.out.println(result*result);
        }
    }

    // 제곱근이 정수인 경우 제곱근 반환, 정수가 아닌 경우 -1 반환
    public static int sqrtInt(int target){
        double sqrt = Math.sqrt(target);
        return sqrt == (int)sqrt ? (int)sqrt: -1;
    }
    
}
