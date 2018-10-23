import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int test = 0; test < testCases; test++) {

            int n = scan.nextInt();
            int p = scan.nextInt();
            int r = scan.nextInt();

            int output = 0;
            int min = Math.min(p - 1, r - 1);
            int max = Math.max(p - 1, r - 1);
            for(int i = min; i < n - max; i++) {
                output += combination(n - 1, i) * permutation(i, min) * permutation(n - 1 - i, max );
            }
            System.out.print(output + "\n");

        }
    }


    static long[][] permutations = new long[13][13];

    long permutation(int n, int x) {
        if(permutations[n][x] != 0){
            return permutations[n][x];
        }
        if(x == 1){
            return permutations[n][x] = stuff(n-1);
        }
        if(n == x){
            return permutations[n][x] = 1;
        }
        if(x == 0){
            return 0;
        }
        long total = 0;
        int a = n-1;
        int b = x-1;
        for(int i = b; i<n; i++){
            total += combination(a,i)*stuff(a-i)*permutation(i,b);
        }
        return permutations[n][x] = total;
    }

    static long[] s = new long[12];

    long stuff(int l) {
        if(s[l] != 0) {
            return s[l];
        }
        if(l == 0) {
            return 1;
        }
        return s[l] = l * stuff(l -1);
    }

    //Found this code at url below, just changed permutation method to factorial as it is the accurate description of the method
    //https://stackoverflow.com/questions/6772521/calculating-combination-in-java
    static long[][] combos = new long[13][7];
    public long combination(int n, int k) {
        if (k > n / 2) {
            k = n - k;
        }
        if (combos[n][k] != 0) {
            return combos[n][k];
        }
        if (k == 1) {
            return combos[n][k] = n;
        }
        if (k == 0) {
            return combos[n][k] = 1;
        }
        if (n == 1) {
            return combos[n][k] = 1;
        }
        return combos[n][k] = combination(n - 1, k - 1) + combination(n - 1, k);
    }
}
