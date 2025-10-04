import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수
        
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        Set<Integer> truthSet = new HashSet<Integer>();
        for(int i = 0; i < truthNum; i++){
            truthSet.add(Integer.parseInt(st.nextToken()));
        }

        int oldSetSize = 0;

        int[][] partyArr = new int[M][N+1]; // [[사람 번호, 사람 번호 ..],[사람 번호, 사람 번호 ..]..]
        boolean[] partyFlag = new boolean[M]; // 파티 Flag, 말할 수 있는 파티만 true
        Arrays.fill(partyFlag,true);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            partyArr[i][0] = num;
            for(int j = 0; j < num; j++){
                partyArr[i][j+1]=Integer.parseInt(st.nextToken());
            }
        }
        while(truthSet.size() != oldSetSize){// truthSet 숫자가 바뀌지 않을 때 까지 순회.
            oldSetSize = truthSet.size();
            for(int i = 0; i < M; i++){

                int partyAttendance = partyArr[i][0];
                boolean flag = false;

                for(int j = 0; j < partyAttendance; j++){
                    int temp = partyArr[i][j+1];
                    if(truthSet.contains(temp)){ // 진실을 아는 사람이 이 파티에 존재하는경우
                        flag = true;
                        partyFlag[i]=false;
                    }
                }

                if(flag){ // flag가 true인 경우, 해당 파티 전 인원 추가.
                    for(int j = 0; j < partyAttendance; j++){
                        truthSet.add(partyArr[i][j+1]);
                    }
                }

            }

        }

        int result = M; // 기본값은 파티의 수로 초기화

        for(int i = 0; i < M; i++){
            if(!partyFlag[i]){
                result-=1;
            }
        }

        System.out.println(result);
    }
}
