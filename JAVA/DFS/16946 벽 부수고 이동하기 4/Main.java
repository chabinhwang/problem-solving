import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] areaArr = new int[N][M]; // 해당 위치가 어느 영역에 해당하는지 '영역숫자'를 저장하기 위함. -1일경우 할당안됨.
        Map<Integer,Integer> areaMap = new HashMap<Integer,Integer>(); // 영역숫자와 영역크기 map


        for(int i=0; i<N; i++){
            Arrays.fill(visited[i],false);
            Arrays.fill(areaArr[i],-1);
            String s = br.readLine();
            for(int j=0; j<M; j++){
                mapArr[i][j]=s.charAt(j)-'0';
            }
        }

        
        // 위, 아래, 왼쪽, 오른쪽 탐색(확인)위해 DR,DC 인덱스 0 ~ 3 까지 탐색하면 됨.
        int[] NR = {-1, 1, 0, 0};   
        int[] NC = {0, 0, -1, 1};

        ArrayDeque<Integer> stack = new ArrayDeque<>(); // DFS나 BFS나 같은 결과
        int areaNum = 0;

        ArrayList<Integer> idxList = new ArrayList<Integer>(); // mapArr에서 1이 저장된 부분만 저장 (row*M+col)
        
        // 영역숫자-영역넓이 구하기 위함
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(mapArr[i][j]==1){
                    idxList.add(i * 1001 + j);
                }

                if(mapArr[i][j] == 0 && !visited[i][j]){ // 0의로 이루어진 영역들을 탐색하기 위함

                    stack.push(i * 1001 + j);
                    int count = 1;

                    while(!stack.isEmpty()){
                        int idx = stack.pop();
                        int row = idx/1001;
                        int col = idx%1001;
                        
                        visited[row][col] = true;
                        areaArr[row][col] = areaNum;

                        for(int dir = 0; dir<4; dir++){
                            int nRow = row + NR[dir];
                            int nCol = col + NC[dir];

                            if(nRow>=0 && nRow < N && nCol>=0 && nCol < M && !visited[nRow][nCol] && mapArr[nRow][nCol] == 0){ // 이어진 0인 경우
                                count++;
                                visited[nRow][nCol]=true;
                                areaArr[nRow][nCol] = areaNum;
                                stack.push(nRow * 1001 + nCol);
                            }
                        }
                    }
                    areaMap.put(areaNum,count); // areaNum와 count map에 더하기
                    areaNum++;
                }

            }
        }
        Set<Integer> set= new HashSet<Integer>();
        for(int i = 0; i<idxList.size(); i++){
            int idx = idxList.get(i);
            int row = idx/1001;
            int col = idx%1001;
            for(int dir = 0; dir<4; dir++){
                int nRow = row + NR[dir];
                int nCol = col + NC[dir];
                if(nRow>=0 && nRow < N && nCol>=0 && nCol < M && areaArr[nRow][nCol]!=-1){
                    set.add(areaArr[nRow][nCol]);
                }
            }
            int count = 0;
            for(int area : set){
                count+=areaMap.get(area);
            }
            set.clear();
            mapArr[row][col] = (1 + count)%10;
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bw.write(String.valueOf(mapArr[i][j]));
            }
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}
