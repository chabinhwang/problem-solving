import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){         // 스택에 X를 넣음
                int X = Integer.parseInt(st.nextToken());
                stack.push(X);
                continue;
            }else if(cmd.equals("pop")){    // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                if(stack.isEmpty())sb.append(-1);
                else sb.append(stack.pop());
            }else if(cmd.equals("size")){   // 스택에 들어있는 정수의 개수를 출력
                sb.append(stack.size());
            }else if(cmd.equals("empty")){  // 스택이 비어있으면 1, 아니면 0을 출력
                if(stack.isEmpty())sb.append(1);
                else sb.append(0);
            }else if(cmd.equals("top")){    // 스택의 가장 위에 있는 정수를 출력. 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                if(stack.isEmpty())sb.append(-1);
                else sb.append(stack.peek());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
