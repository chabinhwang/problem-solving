import java.util.*;
import java.io.*;

public class Main{
    public static Map<Integer,ArrayList<Integer>> tree;
    public static int result;
    public static int[] cost;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new HashMap<>(); // key에 노드, arraylist에 자식 노드
        cost = new int[N];

        st.nextToken();
        for(int i = 1; i < N; i++){ // 1부터 N-1까지 탐색
            int child = i;
            int root = Integer.parseInt(st.nextToken());

            tree.computeIfAbsent(root,k->new ArrayList<Integer>());
            tree.get(root).add(child);
        }
        DFS(0);
        System.out.println(cost[0]-1);
    }
    public static void DFS(int node){
        ArrayList<Integer> ar;
        if(tree.containsKey(node)){// 리프 노드가 아니라면
            ar = tree.get(node);
            for(int i=0;i<ar.size();i++){
                DFS(ar.get(i));
            }
        }else{ // 리프인 경우, 전달에 걸리는 시간은 1분
            cost[node] = 1;
            return;
        }

        ArrayList<Integer> childCosts = new ArrayList<>();
        for (int child : ar) {
            childCosts.add(cost[child]);
        }
        
        Collections.sort(childCosts, Collections.reverseOrder());

        int childMax = childCosts.get(0);
        if(childCosts.size()>1){
            for(int i = 1; i < childCosts.size(); i++){ // 1 2 3 3 5 라면, 여기서 걸리는 시간은 5가 아니라 6임. 또한, 마지막에 1 추가해야함(현재노드 할당시간 1분)
                if(i + childCosts.get(i) > childMax){ // 지나간 시간+사용해야 하는 시간이 최대 시간보다 큰 경우
                    childMax = i + childCosts.get(i);
                }
            }
        }
        cost[node] = childMax + 1;
    }
}