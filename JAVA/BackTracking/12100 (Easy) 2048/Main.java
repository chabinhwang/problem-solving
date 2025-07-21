import java.util.*;
import java.io.*;

public class Main{
    static int[][] arr;
    static int result = 0;
    static int N;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(arr[i],0);
            for(int j = 0; j<N; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        result = Arrays.stream(arr).flatMapToInt(Arrays::stream).max().getAsInt();
        dfs(1,copy(arr));
        System.out.println(result);
        
    }

    static int[][] copy(int[][] original){
        int n = original.length;
        int[][] arr = new int [n][];
        for (int i = 0; i < n; i++) {
            arr[i] = original[i].clone(); // 깊은 복사
        }
        return arr;

    }

    static int[] working(ArrayList<Integer> aList){
        // aList를 정렬해서 더할 수 있는 값들 더한 뒤에 int[] 로 내보내기

        int[] arr = new int[N];
        Arrays.fill(arr,0);

        int idx = 0;
        int arrIdx = 0;

        while (idx < aList.size()) {
            int current = aList.get(idx);
            // 다음 숫자가 같으면 합치기
            if (idx + 1 < aList.size() && aList.get(idx + 1).equals(current)) {
                arr[arrIdx++] = current * 2;
                idx += 2;
            } else {
                arr[arrIdx++] = current;
                idx++;
            }
        }

        return arr;
    }

    static void dfs(int depth, int[][] array){
        if(depth==6){
            return;
        }
        // 4방향 시도, 각 방향마다 dfs 새로, 더하게 된다면 최대값 갱신하기
        int[][] newArr = new int[N][N];

        // 위
        for(int i=0; i<N;i++){// i는 몇 col인지 나타내는 것
            int index = 0;
            // 무조건 index와 합칠 대상은 index 보다 큰 값들이라고 생각하자. 또한, index와 합치는 데 성공했다면, 다음 index = 합친 대상 +1.
            ArrayList<Integer> aList = new ArrayList<Integer>();
            for(int j=0; j < N; j++){
                if(array[j][i]!=0){
                    aList.add(array[j][i]);
                }
            }
            int[] workArr = working(aList);
            for(int j = 0; j < N; j++){
                newArr[j][i] = workArr[j]; 
                result = Math.max(result,workArr[j]);
            }
        }
        if(!Arrays.deepEquals(array, newArr)){
            dfs(depth+1,copy(newArr));
        }

        // 아래
        newArr = new int[N][N];
        for(int i=0; i<N;i++){

            ArrayList<Integer> aList = new ArrayList<Integer>();
            for(int j=0; j < N; j++){
                if(array[N-1-j][i]!=0){// 뒤에서부터 탐색
                    aList.add(array[N-1-j][i]);
                }
            }
            
            int[] workArr = working(aList);
            for(int j = 0; j < N; j++){
                newArr[N-1-j][i] = workArr[j];
                result = Math.max(result,workArr[j]);
            }
        }
        if(!Arrays.deepEquals(array, newArr)){
            dfs(depth+1,copy(newArr));
        }

        // 왼쪽으로
        newArr = new int[N][N];
        for(int i=0; i<N;i++){
            ArrayList<Integer> aList = new ArrayList<Integer>();
            for(int j=0; j < N; j++){
                if(array[i][j]!=0){
                    aList.add(array[i][j]);
                }
            }
            
            int[] workArr = working(aList);
            for(int j = 0; j < N; j++){
                newArr[i][j] = workArr[j];
                result = Math.max(result,workArr[j]);
            }
        }
        if(!Arrays.deepEquals(array, newArr)){
            dfs(depth+1,copy(newArr));
        }
        
        
        // 오른쪽으로
        newArr = new int[N][N];
        for(int i=0; i<N;i++){
            ArrayList<Integer> aList = new ArrayList<Integer>();
            for(int j=0; j < N; j++){
                if(array[i][N-1-j]!=0){// 뒤에서부터 탐색
                    aList.add(array[i][N-1-j]);
                }
            }
            
            int[] workArr = working(aList);
            for(int j = 0; j < N; j++){
                newArr[i][N-1-j] = workArr[j];
                result = Math.max(result,workArr[j]);
            }
        }
        if(!Arrays.deepEquals(array, newArr)){
            dfs(depth+1,copy(newArr));
        }

    }



}