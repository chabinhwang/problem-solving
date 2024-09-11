import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());//나눠 읽고
        ArrayList<Integer> listt = new ArrayList<>();
        while (st.hasMoreTokens()) {// 모든 토큰을 ArrayList에 추가
            listt.add(Integer.parseInt(st.nextToken()));
        }
        int N=listt.get(0);
        int K=listt.get(1);
        List<Integer> list = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
        //list는[0,1,2...로 초기화되어있음]
        System.out.print("<");
        int temp = 0;
        int removeIndex=K-1;
        while(!list.isEmpty()) {
            temp++;
            if(list.size()==1){
                System.out.print(list.remove(removeIndex));
            }else{
                System.out.print(list.remove(removeIndex)+", ");
            }
            if(list.size()!=0){
                removeIndex=(removeIndex+K-1)%list.size();
            }
        }
        System.out.print(">");
    }
}