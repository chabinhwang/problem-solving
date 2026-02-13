import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int r1 = Integer.parseInt(inputs[0]);
        int c1 = Integer.parseInt(inputs[1]);
        int r2 = Integer.parseInt(inputs[2]);
        int c2 = Integer.parseInt(inputs[3]);
        int[][] result = new int[r2 - r1 + 1][c2 - c1 + 1];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < r2 - r1 + 1; i++){
            for(int j = 0; j < c2 - c1 + 1; j++){
                result[i][j] = getInt(r1 + i, c1 + j);
                max = Math.max(max, result[i][j]);
            }
        }
        int width = String.valueOf(max).length();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%"+width+"d"+" ",result[i][j]);
            }
            System.out.println();
        }
    }

    private static int getInt(int r, int c){
        int n = Math.max(Math.abs(r), Math.abs(c));
        int standard;

        if(r >= c){//대각선 아래인 경우 (2n+2)^2 - 2n
            standard = (2 * n + 1) * (2 * n + 1) - (2 * n);
            if(c == -n){// 기준점 대비 y축 이동한 경우
                return standard - (n - r);
            }else{// 기준점 대비 x축 이동한 경우
                return standard + (c + n);
            }
        }else{//대각선 위인 경우 (2n+2)^2 + 2n
            standard =  (2 * n - 1) * (2 * n - 1) + (2 * n);
            if(c == n){// 기준점 대비 y축 이동한 경우
                return standard - (r + n);
            }else{// 기준점 대비 x축 이동한 경우
                return standard + (n - c);
            }
        }
    }



}