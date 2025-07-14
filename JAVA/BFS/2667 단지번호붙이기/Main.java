import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i],false);
        }

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = temp.charAt(j)-'0'; // char->int를 위함. 0과 1은 UTF-16기준 1 차이 남.
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){ // arr [i][j]부터 탐색해 나아감.
                if(arr[i][j]==1 && !visited[i][j]){ // 한번도 방문 안한 곳+집이 있는 경우
                    //System.out.println("queue실행, 시작 row, col : "+i+", "+j);
                    visited[i][j]=true;
                    queue.offer(25*i+j);
                    int count = 1;

                    while(!queue.isEmpty()){ // 단지 탐색 시작. 4개 방향으로 탐색
                        int house = queue.poll();
                        int row = house/25;
                        int col = house%25;
                        if(row==0){ // row 만 +1 탐색
                            if(!visited[row+1][col]&&arr[row+1][col]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row+1)+col);
                                visited[row+1][col] = true;
                            }
                        }else if(row==N-1){// row 만 -1 탐색
                            if(!visited[row-1][col]&&arr[row-1][col]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row-1)+col);
                                visited[row-1][col] = true;
                            }
                        }else{ // row 만 +1 -1 탐색
                            if(!visited[row+1][col]&&arr[row+1][col]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row+1)+col);
                                visited[row+1][col] = true;
                            }
                            if(!visited[row-1][col]&&arr[row-1][col]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row-1)+col);
                                visited[row-1][col] = true;
                            }
                        }

                        if(col==0){ // col 만 +1 탐색
                            if(!visited[row][col+1]&&arr[row][col+1]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row)+col+1);
                                visited[row][col+1] = true;
                            }
                        }else if(col==N-1){ // col 만 -1 탐색
                            if(!visited[row][col-1]&&arr[row][col-1]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row)+col-1);
                                visited[row][col-1] = true;
                            }                        
                        }else{ // col 만 +1 -1 탐색
                            if(!visited[row][col+1]&&arr[row][col+1]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row)+col+1);
                                visited[row][col+1] = true;
                            }
                            if(!visited[row][col-1]&&arr[row][col-1]==1){// 미탐색+이어진 경우
                                count +=1;
                                queue.offer(25*(row)+col-1);
                                visited[row][col-1] = true;
                            }
                        }
                    }

                    ans.add(count);
                }
            }
        }
        ans.sort((a,b)->a-b);
        bw.write(String.valueOf((ans.size())));
        for(int i = 0; i < ans.size(); i++){
            bw.newLine();
            bw.write(String.valueOf(ans.get(i)));
        }
        bw.flush();
        bw.close();

    }
}
