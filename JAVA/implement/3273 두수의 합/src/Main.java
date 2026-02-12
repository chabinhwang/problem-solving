import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();//n 버리기(아래 while)
        StringTokenizer st = new StringTokenizer(br.readLine());//나눠 읽고
        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {// 모든 토큰을 ArrayList에 추가
            list.add(Integer.parseInt(st.nextToken()));
        }
        int result=Integer.parseInt(br.readLine());//목표결과값
        list.removeIf(num->num>result);
        Collections.sort(list);
        int count=0;
        int first=0;
        int last=list.size()-1;
        int sum=0;
        while(first<last){
            sum=list.get(first)+list.get(last);
            if(sum==result){
                count++;
            }
            if(sum>result){
                last--;
            }else{
                first++;
            }
        }
        System.out.println(count);
    }
}