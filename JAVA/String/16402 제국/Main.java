import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());// 왕국 갯수
        int M = Integer.parseInt(st.nextToken());// 전쟁 결과 갯수

        Map<String,List<String>> group = new HashMap<>(); // <종주국,{속국1,속국2}>
        Map<String,String> depend = new HashMap<>(); // <본인, 소속 그룹의 종주국> - 종주국 본인은 <A,A>와 같이 저장함.

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            String[] tokens = temp.split(" ");
            String kd = tokens[2];
            group.put(kd,new ArrayList<String>(List.of(kd)));
            depend.put(kd,kd); 
        }
        
        for(int i = 0; i < M; i++){
            String temp = br.readLine();
            String[] tokens = temp.split(",");
            String kd1 = tokens[0].split(" ")[2];
            String kd2 = tokens[1].split(" ")[2];
            int win = Integer.parseInt(tokens[2]);

            String winKd = (win == 1)?kd1:kd2;
            String loseKd = (win == 2)?kd1:kd2;

            // 새 그룹의 종주국 = if 이긴 그룹의 종주국과, 진 그룹의 종주국이 같을 경우 winKd / else winKd의 종주국
            String leadKd = (depend.get(winKd).equals(depend.get(loseKd)))?winKd:depend.get(winKd);
            // winKd, loseKd가 종주국이든 아니든, depend의 value에는 종주국이 적혀있음.

            List<String> kdListA = group.get(depend.get(winKd)); // 같은 그룹이든 다른 그룹이든, 이긴놈 그룹
            // 같은 그룹이면 빈 array, 다른 그룹이면, 진 그룹 배열 전체
            List<String> kdListB = (depend.get(winKd).equals(depend.get(loseKd)))?new ArrayList<String>():group.get(depend.get(loseKd)); 
            
            kdListA.addAll(kdListB);

            // kdListA에서 winKd, loseKd 넣고, leadKd 빼기
            kdListA.add(winKd);
            kdListA.add(depend.get(winKd));
            kdListA.add(loseKd);
            kdListA.add(depend.get(loseKd));
            kdListA.remove(leadKd);

            //kdListA에 있는 값들을 depend에서 찾고, value를 모두 leadKd로 바꾸기
            for(int j = 0 ; j<kdListA.size(); j++){
                depend.put(kdListA.get(j),leadKd);
            }
            // group 정리
            group.remove(depend.get(loseKd));
            group.put(leadKd,kdListA);
        }
        List<Map.Entry<String,String>> entrySet = new ArrayList<>(depend.entrySet());
        List<String> resultList = new ArrayList<>();
        for(Map.Entry<String,String> i : entrySet){
            if(i.getKey().equals(i.getValue())){
                resultList.add(i.getKey());
            }
        }
        bw.write(String.valueOf(resultList.size()));bw.newLine();
        resultList.sort((a,b)->a.compareTo(b));

        for(int i = 0 ; i < resultList.size();i++){
            bw.write("Kingdom of "+resultList.get(i));bw.newLine();
        }
        bw.flush();bw.close();
    }

}