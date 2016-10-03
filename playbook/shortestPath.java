import java.io.*;
import java.util.*;

public class Solution {
    public ArrayList<Integer> shortestPaths (HashMap<Integer,HashMap<Integer,Integer>> graph, int source, int n) {        
        HashSet<Integer> visited = new HashSet<>();                
        HashMap<Integer, Integer> distance = new HashMap<>();                
        
        for (int i = 1; i <= n; i++) {
            distance.put(i, Integer.MAX_VALUE);                       
            visited.add(i);
        }
        
        distance.put(source, 0);
        
        while (!visited.isEmpty()) {            
            int node = extract_min(visited, distance);
            if (node == 0) {
                break;
            }
            visited.remove(node);                      
            
            for (Integer neighbor: graph.get(node).keySet()) {                               
                int alt = distance.get(node) + graph.get(node).get(neighbor);
                if (alt < distance.get(neighbor)) {
                    distance.put(neighbor, alt);                            
                }                    
            }                                        
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != source) {
                if (distance.get(i) != Integer.MAX_VALUE) {
                    res.add(distance.get(i));    
                }
                else {
                    res.add(-1);
                }                
            }
        }
        
        return res;
    }
    
    public int extract_min(HashSet<Integer> set, HashMap<Integer, Integer> distance) {
        int min_node = 0;
        int min_distance = Integer.MAX_VALUE;
        for (Integer node: set) {
            if (distance.get(node) < min_distance) {
                min_distance = distance.get(node);
                min_node = node;
            }
        }
                
        return min_node;
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            InputStreamReader in= new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            int numCases = Integer.parseInt(input.readLine());                        
                                    
            for (int k = 0; k < numCases; k++) {
                String row = input.readLine();
                String[] params = row.split(" ");
                int n = Integer.parseInt(params[0]);
                int m = Integer.parseInt(params[1]);
                
                HashMap<Integer, HashMap<Integer,Integer>> graph = new HashMap<>();    
                // constructing graph
                for (int i = 0; i < m; i++) {
                    row = input.readLine();
                    String[] edge = row.split(" ");
                    int from = Integer.parseInt(edge[0]);
                    int to = Integer.parseInt(edge[1]);
                    int distance = Integer.parseInt(edge[2]);
                    
                    // two-way network
                    if (!graph.containsKey(from)) {
                        graph.put(from, new HashMap<>());
                        
                        // get the minimum distance
                        if (!graph.get(from).containsKey(to)) {
                            graph.get(from).put(to, distance);                            
                        }
                        else {
                            int tmp = graph.get(from).get(to);
                            graph.get(from).put(to, Math.min(distance, tmp));
                        }                        
                    }
                    else {
                        if (!graph.get(from).containsKey(to)) {
                            graph.get(from).put(to, distance);                            
                        }
                        else {
                            int tmp = graph.get(from).get(to);
                            graph.get(from).put(to, Math.min(distance, tmp));
                        }                                                
                    }              

                    if (!graph.containsKey(to)) {
                        graph.put(to, new HashMap<>());
                        if (!graph.get(to).containsKey(from)) {
                            graph.get(to).put(from, distance);                            
                        }
                        else {
                            int tmp = graph.get(to).get(from);
                            graph.get(to).put(from, Math.min(distance, tmp));
                        }     
                    }
                    else {
                        if (!graph.get(to).containsKey(from)) {
                            graph.get(to).put(from, distance);                            
                        }
                        else {
                            int tmp = graph.get(to).get(from);
                            graph.get(to).put(from, Math.min(distance, tmp));
                        }     
                    }
                }

                int source = Integer.parseInt(input.readLine());
                // System.out.println("Source = " + source);

                Solution sol = new Solution();
                ArrayList<Integer> shortestDistances = sol.shortestPaths(graph, source, n);

                // print results
                for (Integer distance: shortestDistances) {
                    System.out.print(distance);
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }         
    }
}