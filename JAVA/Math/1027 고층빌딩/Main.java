import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] building = new long[N];
        Map<Integer,Double> steep = new HashMap<Integer,Double>();
        building[0]=Long.parseLong(st.nextToken());
        for(int i = 1; i < N; i++){
            building[i]=Long.parseLong(st.nextToken());
            // j부터 i까지의 기울기 구해서 j*100+i를 key로 map 에 저장(무조건 왼쪽부터 오른쪽으로 계산한 기울기)
            for(int j = i-1 ; j > -1; j--){
                steep.put(j*100+i,(double)(building[i] - building[j])/(i - j));
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++){ // i 기준으로 왼/오 로 뻗어가면서, 기울기가 점점 작아/커지는 것들만 세기(최소/최대값 업데이트)
            double minSteep = 1000000001;
            int count = 0;
            for(int j = i-1; j > -1; j--){ // 왼
                double targetSteep = steep.get(j*100+i);
                if(targetSteep < minSteep){
                    minSteep = targetSteep;
                    count+=1;
                }

            }
            double maxSteep = -1000000001;
            for(int j = i+1; j < N; j++){ // 오
                double targetSteep = steep.get(i*100+j);
                if(maxSteep < targetSteep){
                    maxSteep = targetSteep;
                    count+=1;
                }
            }
            result=Math.max(result,count);
        }
        System.out.println(result);
    }    
}
