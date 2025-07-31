import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<String> loms = new ArrayList<String>(List.of("I","V","X","L","C","D","M"));
    static ArrayList<Integer> value = new ArrayList<Integer>(List.of(1,5,10,50,100,500,1000));
    // 기호	I	V	 X	 L	 C	 D	 M
    // 값  1   5	10	50	100	500	1000

    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        String fst = br.readLine();
        String snd = br.readLine();

        int N = fst.length();
        int result = 0;
        for(int i = 0; i < N; i++){
            String s = fst.substring(i,i+1); // i번째 글자 하나만 가져옴
            int sIdx = loms.indexOf(s);
            if(i + 1 != N){ // i가 마지막 글자가 아니라면
                String next = fst.substring(i+1,i+2);
                int nextIdx = loms.indexOf(next);
                if(nextIdx>sIdx){ // i번째 글자보다 i+1번째 글자가 큰 값인 경우 - 현재 값은 result에 음수로 더하기
                    result -= value.get(sIdx);
                }else{// 아닌경우
                    result += value.get(sIdx);
                }
            }else result+= value.get(sIdx);
        }
        N = snd.length();
        for(int i = 0; i < N; i++){
            String s = snd.substring(i,i+1); // i번째 글자 하나만 가져옴
            int sIdx = loms.indexOf(s);
            if(i + 1 != N){ // i가 마지막 글자가 아니라면
                String next = snd.substring(i+1,i+2);
                int nextIdx = loms.indexOf(next);
                if(nextIdx>sIdx){ // i번째 글자보다 i+1번째 글자가 큰 값인 경우 - 현재 값은 result에 음수로 더하기
                    result -= value.get(sIdx);
                }else{// 아닌경우
                    result += value.get(sIdx);
                }
            }else result+= value.get(sIdx);
        }
        String resultLom = "";
        String temp = String.valueOf(result);
        int len = temp.length();
        for(int i = 0; i < len; i++){
            String s = temp.substring(i,i+1);
            int sInt = Integer.parseInt(s);
            int multi = len - i; // len이 4고, i가 1이면 3번째 자릿수라는 뜻
            String up1  = "";
            String cur5 = "";
            if(multi<4){
                up1 = loms.get(multi * 2);
                cur5 = loms.get((multi-1) * 2 + 1);
            }
            String cur1 = loms.get((multi-1) * 2);
            if(sInt==9){ // 한단계 위 자릿수 1 가져오고, 현재 자릿수 1을 앞에서 빼야 함
                resultLom = resultLom + cur1 + up1;
            }else if(sInt>=5){ // 5 넣고, sInt-5만큼 1 넣어야 함
                int cnt1 = sInt - 5;
                resultLom = resultLom + cur5 + cur1.repeat(cnt1);
            }else if(sInt==4){ // 1 넣고, 5 넣기
                resultLom = resultLom + cur1 + cur5;
            }else{
                resultLom = resultLom + cur1.repeat(sInt);
            }
        }

        System.out.println(result);
        System.out.println(resultLom);

    }
}