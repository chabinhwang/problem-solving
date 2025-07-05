import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
        int K = Integer.parseInt(st.nextToken()); // 전기 용품의 총 사용횟수

        // int[] arr = new int[K]; // 해당 제품 몇번 남았는지 확인하기 위함
        // Arrays.fill(arr,0);
        Map<Integer, Integer> map = new HashMap<>(); // 해당 제품 몇번 남았는지 확인하기 위함

        ArrayList<Integer> list = new ArrayList<Integer>(); // 순서대로 저장용

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int product = Integer.parseInt(st.nextToken());
            // arr[product-1] = arr[product-1]+1;

            if(map.containsKey(product)){
                map.put(product,map.get(product)+1);
            }else{
                map.put(product,1);
            }

            list.add(product);
        }
        int result = 0;
        ArrayList<Integer> plugList = new ArrayList<Integer>(); // 플러그에 들어가는 제품 리스트
        for (int i = 0 ; i < K ; i++){
            int product = list.remove(0);
            if(plugList.contains(product)){ // 플러그에 이미 꽃혀있는 경우
                map.put(product,map.get(product)-1);
            }else if(plugList.size()<N){ // 플러그가 여유있는 경우
                plugList.add(product);
                map.put(product,map.get(product)-1);
            }
            else{ // 플러그에 여유 없는 경우
                boolean flag = false;
                int useless = 0 ;
                int oldestProduct = 0;
                int old = 0;
                for(int p : plugList){
                    int nextIdx = list.indexOf(p);  // 각 제품들의 '다음 첫 번째 사용 index', 가장 큰 값 제거
                    if(nextIdx>=old){
                        oldestProduct = p;
                        old = nextIdx;
                    }
                    
                    if(map.get(p)==0){ // plugList 중 남은 사용횟수 0 있는지 여부
                        flag = true;
                        useless = p;
                    }
                }

                result++;
                if (flag){ // 남은 사용횟수 0 존재(map.get(useless)==0, 건들 필요 x)

                    plugList.remove(Integer.valueOf(useless));
                    plugList.add(product);
                    map.put(product,map.get(product)-1);

                }else{// 남은 사용횟수 0 존재하지 않음, 가장 늦게 사용하는 제품부터 제외 시도

                    plugList.remove(Integer.valueOf(oldestProduct));
                    plugList.add(product);
                    map.put(product,map.get(product)-1);
                }

            }
        }
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
        bw.close();

    }
}