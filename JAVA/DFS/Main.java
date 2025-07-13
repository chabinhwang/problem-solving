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
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        visited[1] = true;
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.println("node : "+node+ "방문");
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }

    }
}