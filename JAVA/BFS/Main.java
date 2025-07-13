import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        int N = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2); graph.get(2).add(1);
        graph.get(1).add(3); graph.get(3).add(1);
        graph.get(2).add(4); graph.get(4).add(2);
        graph.get(3).add(5); graph.get(5).add(3);

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited,false);
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("node : "+node+ "방문");
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true; // 주의해야 하는 부분. 같은 노드가 큐에 여러 번 들어가는 것을 방지하기 위해, 큐에 넣는 순간 true.
                }
            }
        }

    }
}