import java.util.*;
import java.io.*;

public class Main{
    static int[] monthArr = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 }; // 2월이면 31(인덱스1번째)더하면 됨. 시간은 1월 1일부터 얼마나 지났는지를 측정.
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정보 갯수
        String L = st.nextToken(); // L 을 parsing해서 대여기간 저장해야 함
        int lDays = Integer.parseInt(L.substring(0,3));
        int lMin = lDays * 1440 + Integer.parseInt(L.substring(4,6)) * 60 + Integer.parseInt(L.substring(7,9));
        // lMin : 대여 가능 시간(단위 - 분)
        int F = Integer.parseInt(st.nextToken()); // 벌금
        
        Map<String, Integer> prodTime = new HashMap<String, Integer>(); // 물건 빌려간 시간 저장 Map<물건유저, 시간(분)>
        Map<String,Long> finMap = new HashMap<String,Long>(); // 벌금 기록용 Map<유저명, 벌금>
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            int month = Integer.parseInt(date.substring(5,7));
            int day = Integer.parseInt(date.substring(8,10));
            String hourAndMin = st.nextToken();
            int min = Integer.parseInt(hourAndMin.substring(0,2))*60+Integer.parseInt(hourAndMin.substring(3,5));

            String prod = st.nextToken();
            String user = st.nextToken();

            int time = dayToMinute(month,day,min);
            // [추가] 같은 부품이 2개 있을수 있음. 예를들어 부품A,부품A,부품B 이렇게.
            if(prodTime.containsKey(prod+user)){ // 목록에 제품이 이미 있다면, 현재 반납 단계
                int startTime = prodTime.get(prod+user);
                int endTime = time;
                int period = endTime - startTime;
                if(period>lMin){ // 벌금 내는 경우
                    Long fin = (period-lMin)*F+0L;
                    finMap.put(user,finMap.getOrDefault(user,0L)+fin);
                }
                prodTime.remove(prod+user);


            }else{ // 목록에 제품이 없다면, 현재 대여 단계. 
                prodTime.put(prod+user,time);
            }
        }


        if(finMap.isEmpty()){
            System.out.println(-1);
        }        
        
        List<Map.Entry<String,Long>> entryList = new ArrayList<>(finMap.entrySet());
        entryList.sort((e1,e2)->e1.getKey().compareTo(e2.getKey()));// 키를 기준으로 정렬
        for(Map.Entry<String,Long> entry : entryList){
            bw.write(entry.getKey()+" "+entry.getValue());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int dayToMinute(int month, int day, int min){
        int dayInMonth = monthArr[month-1]+day;
        return min + dayInMonth * 1440;
    }
}