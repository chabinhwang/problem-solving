import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int prevTime = 0; // 이전 명령어 시간
        // a, ab, " ", a
        TreeMap<Integer, String> result = new TreeMap<>(); // 시간: 완성된 문자
        result.put(prevTime,"");
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            String[] inputArr = input.split(" ");
            String cmd = inputArr[0];
            String cmd2 = inputArr[1];
            int time = Integer.parseInt(inputArr[2]);
            if(cmd.equals("type")){
                result.put(time,result.get(prevTime)+cmd2);
            }else if(cmd.equals("undo")){
                int undoTime = Integer.parseInt(cmd2);
                if(undoTime >= time - 1){// 처음으로 돌아가기
                    result.put(time, "");
                }else{
                    int key = result.floorKey(time - undoTime - 1);// time - undoTime 보다 작은 값중에 가장 큰 값 - 우리가 되돌리려는 값이기 때문에 1 빼야 함.
                    result.put(time, result.get(key));
                }
            }
            prevTime = time;
        }
        System.out.println(result.get(prevTime));

    }
}