/**
 * Created by ashi on 1/7/18.
 */
public class NumberQuestions {

    /*Swap two numbers without temp buffer*/
    public void swapWithoutTempBuffer(int a,int b){
       // 5,4
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("a is "+a+" and b is "+b);

    }


    public static void main(String[] args) {
        NumberQuestions numberQuestions = new NumberQuestions();
        numberQuestions.swapWithoutTempBuffer(-1,3);
    }
}


