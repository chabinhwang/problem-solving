import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] qList = new int[N]; //row * 15 + col 값 저장
        Arrays.fill(qList,-1);
        int count = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // row * 15 + col 값 저장

        stack.push(0*15+0);
        
        while(!stack.isEmpty()){
            int temp = stack.pop();
            int row = temp / 15;
            int col = temp % 15;

            if(col >= N) continue; // col이 범위를 벗어나면 버림
            if(col+1<N)stack.push(row*15+col+1);

            // 대각선 혹은 같은 행에 Queen이 존재하는지 
            boolean flag = false;
            for (int i = 0; i < row; i++) {
                int qRow = i;
                int qCol = qList[i] % 15;
                if (qCol == col || Math.abs(qCol - col) == (row - qRow)) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }else{  // 배치 가능한 경우
                if(row == N-1){
                    count++;
                }else{
                    qList[row] = row * 15 + col;
                    stack.push((row+1)*15+0);
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
        bw.close();

    }
}