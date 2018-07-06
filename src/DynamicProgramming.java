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

    public static void main(String[] args) {
        int[] publicCost = {1,5,8,9,10,17,17,20};
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        dynamicProgramming.rodcutting(publicCost,8);
    }
}
