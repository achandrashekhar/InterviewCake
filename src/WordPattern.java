import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashi on 9/11/17.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> patternMap = new HashMap<>();
        String[] words=str.split("\\s");//splits the string based on whitespace
        System.out.println(words[0]);
        System.out.println(words.length);
        char[] patternChar = pattern.toCharArray();
        if(words.length!=patternChar.length) return false;
//using java foreach loop to print elements of string array
        int i =0; //track the words array
        for(char c:patternChar) {
            if(!patternMap.containsKey(c)){
                if(patternMap.containsValue(words[i])) {

                }
                patternMap.put(c,words[i]);
            } else {
                if(!(patternMap.get(c).equals(words[i]))){
                    return false;
                }
            }
            i++;
        }
            return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        if(wordPattern.wordPattern("abc", "cat dog dog")){
            System.out.println("Match!");
        } else {
            System.out.println("Nope!");
        }
    }
}
