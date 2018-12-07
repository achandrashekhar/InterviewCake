import java.util.*;
import java.util.LinkedList;

/**
 * Created by ashi on 5/12/18.
 */
public class DynamicProgramming {

    public void rodcutting(int[] publicCost,int n){
        int[] B = new int[n+1];
        B[0] = 0;
        B[1] = publicCost[0];
        for(int i=1;i<=n;i++){
            int max = Integer.MIN_VALUE;
            for(int k = 0;k<i;k++){
                int tempCost = publicCost[k]+B[i-k-1];
                max = Math.max(max,tempCost);
            }
            B[i] = max;
        }
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }

    }

    public void findMinimumToReachEndOfArray(int[] array){
        int[] numJumps = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numJumps[i] = Integer.MAX_VALUE;
        }
        numJumps[0] = 0;

        for (int i = 0; i <array.length ; i++) {
            for (int j = 1; j <=i+array[i] && j<array.length; j++) {
                int newDistance = numJumps[i]+1;
                numJumps[j] = Math.min(newDistance,numJumps[j]);
            }
        }



        for (int i = 0; i < numJumps.length; i++) {
            System.out.println(numJumps[i]);
        }
    }

    public int coinChange(int[] coinArray, int n){
        int finalTable[] = new int[n+1];
        for(int k = 0;k<finalTable.length;k++){
            finalTable[k] = k; //fill up the coins such that if there was as coin of denomination 1, it would take as many coins
        }
        for(int i = 1;i<coinArray.length;i++){
            for(int j=1;j<=n;j++){
                int coini = coinArray[i];
                if(coini<=j){
                    finalTable[j] = Math.min(finalTable[j], 1+finalTable[j-coini]);
                }
            }
        }
        return finalTable[n];
    }

    public int minPalPartion(String str)
    {
        // Get the length of the string
        int n = str.length();

        /* Create two arrays to build the solution
           in bottom up manner
           C[i][j] = Minimum number of cuts needed
                     for palindrome partitioning
                     of substring str[i..j]
           P[i][j] = true if substring str[i..j] is
                     palindrome, else false
           Note that C[i][j] is 0 if P[i][j] is
           true */
        int[][] C = new int[n][n];
        boolean[][] P = new boolean[n][n];

        int i, j, k, L; // different looping variables

        // Every substring of length 1 is a palindrome
        for (i = 0; i < n; i++)
        {
            P[i][i] = true;
            C[i][i] = 0;
        }

        /* L is substring length. Build the solution in
         bottom up manner by considering all substrings
         of length starting from 2 to n. The loop
         structure is same as Matrx Chain Multiplication
         problem (
        See https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/ )*/
        for (L = 2; L <= n; L++)
        {
            // For substring of length L, set different
            // possible starting indexes
            for (i = 0; i < n - L + 1; i++)
            {
                j = i + L - 1; // Set ending index

                // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
                if (L == 2)
                    P[i][j] = (str.charAt(i) ==
                            str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) ==
                            str.charAt(j)) && P[i+1][j-1];

                // IF str[i..j] is palindrome, then
                // C[i][j] is 0
                if (P[i][j] == true)
                    C[i][j] = 0;
                else
                {
                    // Make a cut at every possible
                    // localtion starting from i to j,
                    // and get the minimum cost cut.
                    C[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++)
                        C[i][j] = Math.min(C[i][j],
                                C[i][k] + C[k+1][j] + 1);
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return C[0][n-1];
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q =  new java.util.LinkedList<Integer>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }



    public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * ((i-1) - stack.peekFirst());
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * ((i-1) - stack.peekFirst());
            }
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] publicCost = {1,5,8,9,10,17,17,20};
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        // dynamicProgramming.rodcutting(publicCost,8);

        int [] coinArray = {2,3,5}; // this input needs to be sorted
        //System.out.println(        dynamicProgramming.coinChange(coinArray,5));

        int input[] = {1,2,3,4,5,3,3,2};
        //System.out.println(dynamicProgramming.maxHistogram(input));
//        String str = "abaab";
//        System.out.println(dynamicProgramming.minPalPartion(str));
        int arr1[] = {2,3,1,1,4};

        dynamicProgramming.findMinimumToReachEndOfArray(arr1);
    }
}
