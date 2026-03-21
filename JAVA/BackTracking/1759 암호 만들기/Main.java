import java.util.*;
import java.io.*;

public class Main {
    static char[] moum = { 'a', 'e', 'i', 'o', 'u' };
    static String[] inputs;
    static ArrayList<String> result = new ArrayList<>();
    static int L;// 암호 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        inputs = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            inputs[i] = st.nextToken();
        }
        Arrays.sort(inputs);

        DFS(0, "");

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
    // inputs의 idx부터 시작
    static void DFS(int idx, String code) {
        // 모음 최소 1개, 자음 최소 2개인 경우만 result 에 추가
        if (code.length() == L) { 
            if(isCode(code)){
                result.add(code);
            }
            return;
        }
        // 남은 문자 다 넣어도 L이 안되는 경우 return
        if (inputs.length - idx + code.length() < L) {
            return;
        }

        // 안넣고 idx만 올려서 DFS돌리거나, 넣어서 DFS
        DFS(idx + 1, code);
        DFS(idx + 1, code + inputs[idx]);

    }
    static boolean isCode(String code){
        boolean hasMoum = false;
        int countMoum = 0;
        char[] codeArr = code.toCharArray();
        for(int i = 0; i < codeArr.length; i++){
            char c = codeArr[i];
            for(int j = 0; j < moum.length; j++){
                if(c == moum[j]){
                    hasMoum = true;
                    countMoum += 1;
                }
            }
        }
        if(hasMoum && codeArr.length - countMoum >= 2){
            return true;
        }else{
            return false;
        }
    }
}
