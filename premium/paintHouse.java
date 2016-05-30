// 256. Paint House

// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

// Note:
// All costs are positive integers.

// Show Company Tags
// Show Tags
// Show Similar Problems


// LinkedIn

public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] sumCosts = new int[n][3];
        for(int j=0;j<3;j++){
            sumCosts[0][j] = costs[0][j];
        }
        
        for(int i=1;i<costs.length;i++){
            sumCosts[i][0] = costs[i][0] + Math.min(sumCosts[i-1][1],sumCosts[i-1][2]); //red
            sumCosts[i][1] = costs[i][1] + Math.min(sumCosts[i-1][0],sumCosts[i-1][2]); //green
            sumCosts[i][2] = costs[i][2] + Math.min(sumCosts[i-1][0],sumCosts[i-1][1]); //blue
        }
        
        return Math.min(sumCosts[n-1][0] < sumCosts[n-1][1]? sumCosts[n-1][0]: sumCosts[n-1][1], sumCosts[n-1][2]);
    }
}