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

    public static void main(String[] args) {
        int[] array = {1,2,0,8,0,0,4,5,6};
        ArrayQuestions arrayQuestions = new ArrayQuestions();
        arrayQuestions.moveZeroesToTheFront(array);
        arrayQuestions.printArray(array);
    }

}
