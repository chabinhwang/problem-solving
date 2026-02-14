import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Long> ar;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ar = new ArrayList<>();
        for (int i = 0; i <= 9; i++) recursive(i, i);
        Collections.sort(ar);
        if(N >= ar.size()) System.out.println(-1);
        else System.out.println(ar.get(N));
    }

    public static void recursive(long num, int digit){// digit = 다음에 붙일 수 있는 숫자 상한
        ar.add(num);
        for(int next = 0; next < digit; next++){
            recursive(num * 10 + next, next);
        }
    }
}
