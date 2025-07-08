import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<N ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        if(N==1){
            bw.write(String.valueOf(0));
        }else if(N==2){
            bw.write(String.valueOf(pq.poll()+pq.poll()));
        }else{
            int result = 0;
            while(!pq.isEmpty()){
                int first = pq.poll();
                int second = pq.poll();
                result += first+second;
                if(!pq.isEmpty()){
                    pq.add(first+second);
                }
            }

            bw.write(String.valueOf(result));
        }
        bw.newLine();
        bw.flush();
        bw.close();
        

    }
}
