import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];// [시작일, 종료일], [시작일, 종료일]...

        // 0301~1130 채워야 함. 
        // 이어진 꽃들 중 '가장 수명이 긴' 꽃들을 선택해 나아가기

        for(int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            String startMonth = st.nextToken();
            String startDay = st.nextToken();
            if(startMonth.length()<2)startMonth = "0" + startMonth;
            if(startDay.length()<2)startDay = "0" + startDay;

            String endMonth = st.nextToken();
            String endDay = st.nextToken();
            if(endMonth.length()<2)endMonth = "0" + endMonth;
            if(endDay.length()<2)endDay = "0" + endDay;

            arr[i][0]=Integer.parseInt(startMonth+startDay);
            arr[i][1]=Integer.parseInt(endMonth+endDay);
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });

        int start = 301;
        int tempStart = 0;
        int tempLast = 0;
        int greatLast = 301;
        int count = 0;
        
        for(int i = 0; i<N ; i++){
            tempStart = arr[i][0];
            tempLast = arr[i][1];

            if(tempStart > start){ // 꽃 배치해야 할 때
                start = greatLast;
                count++;
            }

            if(tempLast >= greatLast && start >= tempStart){ // 현재 최대 범위 꽃보다 더 오래 살아남을 경우 업데이트
                greatLast = tempLast;
            }

            if(greatLast>1130)break; // 1130을 넘겼음면, 더이상 확인할 필요 없음

        }
        count++;
        if (greatLast<=1130)count=0;
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}