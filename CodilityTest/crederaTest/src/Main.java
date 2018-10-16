// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public boolean possTriangle (int a, int b, int c) {
        if(a + b <= c) {
            return false;
        }
        else if(b + c <= a) {
            return false;
        }
        else if(a + c <= b) {
            return false;
        }
        else {
            return true;
        }
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int max = -1;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A.length; j++) {
                for(int k = 0; k < A.length; k++) {
                    if(i != j && i != k && j != k) {
                        if(possTriangle(A[i], A[j], A[k])){
                            int sum = (A[i] + A[j] +A[k]);
                            if(max < sum){
                                max = sum;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {10, 20, 30};
        double b = s.solution(A);
        System.out.print(b);
    }
}