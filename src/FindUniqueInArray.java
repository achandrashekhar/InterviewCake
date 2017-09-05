import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashi on 9/5/17.
 * Given the array of IDs, which contains many duplicate integers and one unique integer, find the unique integer.
 */
public class FindUniqueInArray {
    List<Integer> arrayWithOneUnique = new ArrayList();
    public void populateArray(int value){
        arrayWithOneUnique.add(value);
    }

    /*
        This algorithm uses bit manipulation. If we XOR a certain number with itself, it will cancel out and set everything to 0
        Hence, if there are duplicates, they all will cancel each other out, but if there is one unique integer, then that will be preserved
        since it does not have a copy to cancel it out. We hence start with a temporary variable uniqiqueId which is set to 0,
        iterate through the entire array and XOR it.
        Timing Complexity: O(n)
        Space Complexity: O(1)
     */
    public int findUnique(){
        int uniqueId = 0;
        for (int i:
             arrayWithOneUnique) {
            uniqueId^=i;
        }
        return uniqueId;
    }

    public static void main(String[] args) {
        FindUniqueInArray findUniqueInArray = new FindUniqueInArray();
        findUniqueInArray.populateArray(2);
        findUniqueInArray.populateArray(3);
        findUniqueInArray.populateArray(2);
        System.out.println(findUniqueInArray.findUnique()); //outputs 3
    }
}
