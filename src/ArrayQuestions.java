import java.util.*;

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


    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                System.out.println("yes"+ numbers[i]);
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            System.out.println("No"+numbers[i]);
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public int[] threeSum(int[]numbers, int target){
        int[] result = new int[3];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<numbers.length;i++){
            for(int j= i+1;j<numbers.length;j++){
                if(map.containsKey(target-(numbers[i]+numbers[j]))){
                    result[2] = j+1;
                    result[1] = i+1;
                    result[0] = map.get(target-(numbers[i]+numbers[j]));
                }
                map.put(numbers[j],j+1);
            }
            map.put(numbers[i],i+1);
        }
        return result;
    }


    int partition(int arr[], int low, int high)
    {
        int pIndex = low;
        int pivot = arr[high];
        for (int i = low; i < low-1; i++) {
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        // swap arr[high] and arr[pIndex]
        int temp = arr[pIndex];
        arr[pIndex] = arr[high];
        arr[high] = temp;
        return pIndex;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


    public void printArrayDiagonally(int[][] arr,int rows,int columns){
        int j;
        for(int i=0;i<rows;i++){
            int temp = i;
            for(j=0;j<columns;j++){
                if(temp<0){
                    break;
                }
                System.out.print(arr[temp][j]);
                temp--;
            }
            System.out.print("\n");
        }

            for(j = 1;j<columns;j++){
                int temp = rows-1;
                int tempj = j;
                while(tempj<columns){
                    System.out.print(arr[temp][tempj]);
                    temp--;
                    tempj++;
                }
                System.out.print("\n");

            }

    }

    //Given an array of n distinct elements and a number x, arrange array elements
    // according to the absolute difference with x, i. e., element having minimum difference comes first and so on.
    // input : int [] arr = {10, 5, 3, 7, 2};
    //x = 7
    // output: {7,5,10,3,2}
    public void sortAbsoluteDifference(int arr[], int x){

        TreeMap<Integer,Integer> absoluteDifferences = new TreeMap<>();
        for (int i = 0; i <arr.length ; i++) {
            int abs = Math.abs(x-arr[i]);
            absoluteDifferences.put(abs, i);
        }

        for (Map.Entry<Integer, Integer> entry : absoluteDifferences.entrySet()) {
            //System.out.println(entry.getKey()+" "+entry.getValue());
            System.out.println(arr[entry.getValue()]);
        }

    }

    public void rotateArray(int arr[],int d, int n){
        for(int i = 0;i<d;i++){
            int firstNumber = arr[0];
            rotateArrayByOne(arr,n);
            arr[n] = firstNumber;
        }

    }

    public void rotateArrayByOne(int arr[], int n){
        for (int i = 1; i <= n ; i++) {
            arr[i-1] = arr[i];
        }
    }

    public void reverseArray(int arr[],int start, int n){
        int i = start;
        int j = n;
        int temp;
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    /* Algorithm:
        1. split Array A = arr[0..d] B = arr[d+1...n]
        2. Reverse A
        3. Reverse B
        4. Reverse entire array
     */
    public void rotateArrayByReversal(int arr[], int d, int n){
        reverseArray(arr,0,d-1);
        reverseArray(arr,d,n);
        reverseArray(arr,0,n);
    }

    public int maximumContiguousSubArray(int arr[]){
        int n = arr.length-1;
        int currentMax = 0;
        int maximumHere = 0;
        for(int i=0;i<=n;i++){
            maximumHere = maximumHere+arr[i];
            if(maximumHere<0)
                maximumHere = 0;
            currentMax = Math.max(maximumHere,currentMax);
        }
        return currentMax;
    }

    /*
     Replace every element with the greatest element on the subarray to its right side
     the last element is to be replaced with -1 since there will be nothing next to it
     */
    public void replaceWithGreatestOnRight(int arr[]){
        int n = arr.length-1;
        int temp ;
        int max = arr[n];
        arr[n] = -1;
        for(int i = n-1;i>=0;i--){
            temp = arr[i];
            arr[i] = max;
            if(max<temp)
                max = temp;

        }
    }

    public void replaceArray(int arr[]){
        int temp;
        for(int i=0;i<arr.length;i++){
            temp = arr[i];
            arr[temp] = i;
        }

    }

    //{1,2,3,-3,-4,-5,-6,-7}
    //[1,2]

    public int[] largestIncreasingSubSequence(int arr[]){
        int sequence[] = new int[arr.length];
        for(int j = 0;j<arr.length;j++){
            sequence[j] = 0;
        }
        int temp = arr[0];
        sequence[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>temp) {
                sequence[i] = sequence[i - 1] + 1;
                temp = arr[i];
            }else {
                sequence[i] = 1;
                temp=arr[i];
            }
        }
        System.out.println(sequence.length);
        return sequence;
    }

    public void segregateEvenAndOdd(int[] arr){
        System.out.println("lol");
        int len = arr.length;
        int left =0;
        int right = len-1;
        while(left<right){
            while(arr[left]%2==0 && left<right){
                left++;
            }
            while(arr[right]%2!=0 && left < right){
                right--;
            }
            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        printArray(arr);
    }


    public static void rearrangeArr(int arr[],
                                    int n)
    {
        // total even positions
        int evenPos = n / 2;

        // total odd positions
        int oddPos = n - evenPos;

        int[] tempArr = new int [n];

        // copy original array in an
        // auxiliary array
        for (int i = 0; i < n; i++)
            tempArr[i] = arr[i];

        // sort the auxiliary array
        Arrays.sort(tempArr);

        int j = oddPos - 1;

        // fill up odd position in
        // original array
        for (int i = 0; i < n; i += 2) {
            arr[i] = tempArr[j];
            j--;
        }

        j = oddPos;

        // fill up even positions in
        // original array
        for (int i = 1; i < n; i += 2) {
            arr[i] = tempArr[j];
            j++;
        }

        // display array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public void evenNumbersOnEvenPosOddNumbersOnOddPos(int[] arr){
        int i =0;
        int j = 1;
        while(i<arr.length && j<arr.length){
            if(arr[i]%2==0){
                i+=2;
            } else if(arr[j]%2!=0){
                j+=2;
            }
            else if(arr[i]%2!=0 && arr[j]%2==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i+=2;
                j+=2;
            }

        }
    }

    public int maximumProductSubArray(int[] arr){
        int maxProduct = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]!=0)
                maxProduct = Math.max(maxProduct,maxProduct*arr[i]);

        }
        return maxProduct;
    }

    public  void reverseMatrixColumns(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            reverseArray(matrix[i],0,matrix[i].length-1);
        }
    }

    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void merge(int[] left, int[] right, int[] arr){
        int i,j,k;
        i = j = k = 0;
        while(i<left.length && j< right.length){
            if(left[i]<right[j]){
                arr[k] = left[i];
                k++;
                i++;
            } else if(right[j]<left[i]){
                arr[k] = right[j];
                k++;
                j++;
            }

        }
        while(i<left.length){
            arr[k] = left[i];
            k++;
            i++;
        }

        while(j<right.length){
            arr[k] = right[j];
            k++;
            j++;
        }

    }

    public void mergeSort(int[] arr){
        int n = arr.length;
        if(n<2){
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int [] right = new int[n-mid];
        for (int i = 0; i <=mid-1; i++) {
            left[i] = arr[i];
        }
        int j = mid;
        for (int i = 0; i < n-mid; i++) {
            right[i] = arr[j];
            j++;
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }

    public int addOneToArray(int[] arr, int start, int size){
        int lengthMinusOne = size-1;
        if(start==lengthMinusOne){
            int t = arr[start]+1;
            if (t==10){
                arr[lengthMinusOne] = 0;
                return 1;
            } else {
                arr[start]+=1;
                return 0;
            }
        }
         int sm = addOneToArray(arr,++start,arr.length);
        if(start!=size-1&&sm==1) {
           int temp = arr[start] + sm;
           if(temp==10){
               arr[start] = 0;
           } else {
               arr[start] = temp;
           }
            return 1;
        }

        return sm;
    }

    public void addOneToArrayUtil(int arr[]){
        int answer = addOneToArray(arr,-1,arr.length);
        if(answer==1){
            int[] newArray = new int[arr.length+1];
            newArray[0]=1;
            for (int i = 1; i <= arr.length-1; i++) {
                newArray[i] = arr[i];
            }
            printArray(newArray);
        } else {
            printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,0,8,0,0,4,5,6};
        ArrayQuestions arrayQuestions = new ArrayQuestions();
//        arrayQuestions.moveZeroesToTheFront(array);
//        arrayQuestions.printArray(array);

        int[] array2 = {10,7,5,8,11,9};
        //int profit = arrayQuestions.companyStock(array2);
        //System.out.println("max profit is " + profit);

        int[] array3 = {1,10,-5,2,-100};
       //int highestproductOfThree =  arrayQuestions.highestOfThree(array3);
        //System.out.println(highestproductOfThree);

//        int[] result = arrayQuestions.twoSum(array3,2);
//        System.out.println(result[0]+" "+result[1]);

//        int [] result = arrayQuestions.threeSum(array3,6);
//        System.out.println(result[0]+" "+result[1] + " "+result[2]);

//        int [] arr = {7,1,2,5,6,3,4};
//        arrayQuestions.sort(arr,0,arr.length-1);
//        arrayQuestions.printArray(arr);

//        int [] arr = {10, 5, 3, 7, 2};
//        arrayQuestions.sortAbsoluteDifference(arr,7);
//
//        int [] arr = {1,2,3,4,5,6,7};
//        arrayQuestions.rotateArray(arr,3,arr.length-1);
//        arrayQuestions.printArray(arr);

//        int [] arr = {1,2,3,4,5,6,7};
//        arrayQuestions.rotateArrayByReversal(arr, 2,arr.length-1);
//        arrayQuestions.printArray(arr);

      // int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
       // System.out.println(arrayQuestions.maximumContiguousSubArray(arr));

//        int[] arr = {16, 17, 4, 3, 5, 2};
//        arrayQuestions.replaceWithGreatestOnRight(arr);
//        arrayQuestions.printArray(arr);

//        int[] arr = {1, 3, 0, 2};
//        arrayQuestions.replaceArray(arr);
//        arrayQuestions.printArray(arr);
    //    int[] arr = {1,2,3,-8,-4,-3,-2,-1,0};
      //  int re[] = arrayQuestions.largestIncreasingSubSequence(arr);
       // arrayQuestions.printArray(re);

//        int[][] arr = new int[][]{
//                {9,3,2},
//                {8,6,1},
//                {5,5,6},
//                {1,2,8}
//    };
//        arrayQuestions.printArrayDiagonally(arr,4,3);
      //  int[] arr = {12, 34, 45, 9, 8, 90, 3};
        //arrayQuestions.segregateEvenAndOdd(arr);
       // arrayQuestions.printArray(arr);

       // int[] arr = {10,9,7,18,13,19,4,20,21,14};
       // arrayQuestions.evenNumbersOnEvenPosOddNumbersOnOddPos(arr);
       // arrayQuestions.printArray(arr);

       // int arr[] = {-2, -3, 0, -2, -40};
       // System.out.println(arrayQuestions.maximumProductSubArray(arr));

//        arrayQuestions.reverseMatrixColumns(arr);
//        arrayQuestions.printMatrix(arr);

       // int[] arr = {-5,1,2,6,3,4,-7};
      //  arrayQuestions.mergeSort(arr);
       // arrayQuestions.printArray(arr);
        int[] arr = {9,9,9,9};
       arrayQuestions.addOneToArrayUtil(arr);
    }



}
