import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();// 수열 저장하는 배열
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int i = 0;
        while(i < N){
            if(stack.isEmpty()){
                stack.push(i);
                i += 1;
            }else{
                // 스택에 뭐 있으면, peek로 확인한 맨 위 index 값이랑 i 값이랑 비교해야 함.
                // if 스택 peek의 숫자보다 i 인덱스의 숫자가 더 크면, 스택에서 pop한 뒤 arr[i]를 pop한 index에 초기화
                // else 스택 peek 숫자가 i 보다 크다면, stack에 i를 push
                if(arr[stack.peek()] < arr[i]) arr[stack.pop()] = arr[i];
                else{
                    stack.push(i);
                    i += 1;
                }
            }
        }
        while(!stack.isEmpty()) arr[stack.pop()] = -1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(i = 0; i < arr.length; i++){
            bw.write(String.valueOf(arr[i]));
            if(i < arr.length - 1) bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
