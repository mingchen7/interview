import java.io.*;
import java.util.*;

public class Solution {
    public ArrayList<Integer> bfs(HashMap<Integer, HashMap<Integer, Integer>> graph, int n, int source) {
        HashMap<Integer, Integer> distances = new HashMap<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        
        distances.put(source, 0);
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            // System.out.println("current: " + current);
            
            if (graph.containsKey(current)) {
                for (Integer neighbor: graph.get(current).keySet()) {
                    if (distances.get(neighbor) == Integer.MAX_VALUE) {
                        // update
                        int alt = distances.get(current) + graph.get(current).get(neighbor);
                        distances.put(neighbor, alt);
                        queue.offer(neighbor);
                    }
                }    
            }            
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <=n; i++) {
            if (i == source) {
                continue;
            }
            
            if (distances.get(i) != Integer.MAX_VALUE) {
                res.add(distances.get(i));
            }
            else {
                res.add(-1);
            }
        }
        
        return res;
    }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution sol = new Solution();
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            int numQueries = Integer.parseInt(input.readLine());
            
            for (int i = 0; i < numQueries; i++) {
                String row = input.readLine();
                String[] params = row.split(" ");
                int n = Integer.parseInt(params[0]);
                int m = Integer.parseInt(params[1]);
                
                // System.out.println("Nodes: " + n);
                // System.out.println("Edges: " + m);
                
                HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
                for (int j = 0; j < m; j++) {
                    row = input.readLine();
                    String[] edge = row.split(" ");
                    int from = Integer.parseInt(edge[0]);
                    int to = Integer.parseInt(edge[1]);
                    
                    if (!graph.containsKey(from)) {
                        graph.put(from, new HashMap<>());                        
                        graph.get(from).put(to, 6);
                    }
                    else {
                        graph.get(from).put(to, 6);
                    }
                    
                    if (!graph.containsKey(to)) {
                        graph.put(to, new HashMap<>());
                        graph.get(to).put(from, 6);
                    }
                    else {
                        graph.get(to).put(from, 6);
                    }                    
                }    
                
                int source = Integer.parseInt(input.readLine().trim());
                // System.out.println("Source: " + source);
                
                ArrayList<Integer> distances = sol.bfs(graph, n, source);
                    
                for (Integer distance:distances) {
                    System.out.print(distance + " ");                        
                }
                System.out.print("\n");                                        
                
            }
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        
    }
}