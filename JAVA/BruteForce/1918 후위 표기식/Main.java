import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+")
                    || arr[i].equals("-")
                    || arr[i].equals("*")
                    || arr[i].equals("/")) { // 연산자의 경우
                if (stack.isEmpty()) {
                    stack.push(arr[i]);
                } else {
                    while (!stack.isEmpty() && priority(arr[i]) <= priority(stack.peek())) {
                        // 내 연산자보다, 이전 연산자가 우선순위 높은 경우 이전 연산자 출력 후 내 연산자 push
                        bw.write(stack.pop());
                    }
                    stack.push(arr[i]);
                }

            } else if (arr[i].equals("(")) {
                stack.push(arr[i]);
            } else if (arr[i].equals(")")) {
                // "(" 나올때까지 pop하면서 출력
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    bw.write(stack.pop());
                }
                stack.pop();
            } else {// 무조건 출력에 추가
                bw.write(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.newLine();
        bw.close();

    }

    public static int priority(String s) {
        if (s.equals("/") || s.equals("*")) {
            return 2;
        } else if (s.equals("+") || s.equals("-")) {
            return 1;
        }
        return 0;
    }
}