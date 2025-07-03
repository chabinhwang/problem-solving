import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<int[]> meets = new ArrayList<>();

        for (int i = 0 ; i < n ; i++){
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        meets.add(new int[]{first,second});
        }

        meets.sort((a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);// 끝나는 시간이 같으면 시작시간 오름차순
            }
            return Integer.compare(a[1],b[1]); // 끝나는 시간 순으로 오름차순 정렬
        });
        
        int count = 0;
        int endTime = 0;
        for(int i = 0 ; i<meets.size();i++){
            int[] arr = meets.get(i);
            if(arr[0] >= endTime){
                count++;
                endTime = arr[1];
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
        bw.close();        
    }
}
