/**
 * Created by ashi on 9/5/17.
 */
public class ReverseString {
    String stringToReverse;
    public ReverseString(String stringToReverse){
        this.stringToReverse = stringToReverse;
    }

    public char[] getReversedString(){
        char[] reversedCharArray = stringToReverse.toCharArray();
        int j = reversedCharArray.length-1;
        for (int i = 0; i<j ; i++,j--) {
            char temp = reversedCharArray[i];
            reversedCharArray[i] = reversedCharArray[j];
            reversedCharArray[j] = temp;
        }
       return reversedCharArray;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString("abcd");
        System.out.println(reverseString.getReversedString());
    }
}
