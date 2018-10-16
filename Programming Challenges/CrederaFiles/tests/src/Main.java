// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int i = 0;
        int count = 1;
        boolean pos = false;
        while(i < A.length) {

            if(A[i] == count) {
                count++;
                i = 0;
                pos = false;
            }
            else {
                pos = true;
                i++;
            }

        }
        if(!pos) {
            return 1;
        }
        return count;
    }
}

public class Main{
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        Solution s = new Solution();
        s.solution(A);
    }
}