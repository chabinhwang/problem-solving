import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] tArr = br.readLine().toCharArray(); // 대상 문자열
        char[] bArr = br.readLine().toCharArray(); // 폭발 문자열
        int N = tArr.length;
        int M = bArr.length;

        char[] stack = new char[N];
        int top = 0; // stack 상단 가리킴
        for (int i = 0; i < N; i++) {
            stack[top++] = tArr[i];
            if (top >= M && tArr[i] == bArr[M - 1]) {// 폭발 문자열 마지막 글자가 나오면, stack에서 peek해서 후보가 맞나 확인
                boolean flag = true;
                for (int j = 0; j < M - 1; j++) {// j로 stack 순회하면서 폭발문자열 가능한지 확인, 불가능하면 flag =false
                    if(stack[top - M + j] != bArr[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    top -= M;
                }
            }
        }

        if (top == 0) System.out.println("FRULA");
        else System.out.println(new String(stack, 0, top));
    }
}
