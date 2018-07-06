import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashi on 5/10/18.
 */
public class StringQuestions {


    void reverse(String str)
    {
        if ((str==null)||(str.length() <= 1))
            System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            reverse(str.substring(0,str.length()-1));
        }
    }

    String removeSpaces(String str){
        str = str.replaceAll("\\s","");
        return str;
    }

    public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= 48 && str.charAt(i) <= 58) {
            result = result * 10 + (str.charAt(i) - 48);
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public int returnASCIISum(String str){
        char[] chars = str.toCharArray();
        int result = 0;
        for(int j = 0;j<chars.length;j++) {
            int ascii = (int) chars[j];
            if(ascii==32){
                ascii=0; //do not include the spaces in the string, for now
            }
            result+=ascii;
        }
        return result;
    }



    public static void main(String[] args) {
        StringQuestions stringQuestions = new StringQuestions();
        String str = "Geeks for geeks";
       // stringQuestions.reverse(str);

       // System.out.println(stringQuestions.removeSpaces(str));
        //System.out.println(stringQuestions.atoi("-1")*5);
        Map<Integer,String> asciiList = new HashMap<>();
        System.out.println(stringQuestions.returnASCIISum("a b"));
    }
}
