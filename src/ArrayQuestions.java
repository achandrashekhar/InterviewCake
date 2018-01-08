import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashi on 1/6/18.
 */
public class ArrayQuestions {


    public void moveZeroesToTheFront(int[] array){
        int count = array.length-1;
        for (int i = array.length-1; i >=0 ; i--) {
            if(array[i]!=0){
               array[count--] = array[i];
            }

        }
        for (int j = 0; j<=count; j++) {
            array[j]=0;
        }
    }

    public void printArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    /*When to buy and sell stock */

    public int companyStock(int[] array){

      int maxProfit = array[1] - array [ 0];

      int minPrice = array[0];

      for(int i = 1; i <array.length;i++){
          int currentPrice = array[i];
          int potentialProfit = currentPrice-minPrice;

          maxProfit = Math.max(maxProfit,potentialProfit);
          minPrice = Math.min(currentPrice,minPrice);
      }

      return maxProfit;
    }

    /*Highest product of 3 */
    public int highestOfThree(int[] array){
        int highest = array[0];
        int lowest = array[1];
        int highestProductof2 = array[0] * array [1];
        int lowestProductof2 = array[0] * array[1];
        int highestProductof3 = array [0] * array[1] * array [2];

        for (int i = 2; i < array.length; i++) {
            int current = array[i];
            highestProductof3 = Math.max(highestProductof3,Math.max((current*highestProductof2),(current*lowestProductof2)));
            highestProductof2 = Math.max(highestProductof2,Math.max((current*lowest),(current*highest)));
            lowestProductof2 = Math.min(lowestProductof2,Math.min((current*lowest),(current*highest)));
            highest = Math.max(current,highest);
            lowest=Math.min(current,lowest);

        }

        return highestProductof3;
    }

    public static void main(String[] args) {
        int[] array = {1,2,0,8,0,0,4,5,6};
        ArrayQuestions arrayQuestions = new ArrayQuestions();
       // arrayQuestions.moveZeroesToTheFront(array);
        //arrayQuestions.printArray(array);

        int[] array2 = {10,7,5,8,11,9};
        //int profit = arrayQuestions.companyStock(array2);
        //System.out.println("max profit is " + profit);

        int[] array3 = {1,10,-5,1,-100};
       int highestproductOfThree =  arrayQuestions.highestOfThree(array3);
        System.out.println(highestproductOfThree);
    }

}