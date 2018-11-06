import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        while (l != 0) {
            int n = scan.nextInt();
            int[] cuts = new int[51];

            for(int i = 1; i <= n; i++) {
                cuts[i] = scan.nextInt();
            }
            cuts[0] = 0;
            cuts[++n] = l;

            int[][] costs = new int[51][51];

            for(int j = 1; j <= n; j++) {
                for(int i = j - 1; i >= 0; i--) {
                    if( i + 1 == j) {
                        costs[i][j] = 0;
                    }
                    else {
                        costs[i][j] = Integer.MAX_VALUE;
                        for(int k = i + 1; k < j; k++) {
                            if(costs[i][k] + costs[k][j] < costs[i][j]) {
                                costs[i][j] = costs[i][k] + costs[k][j];
                            }

                        }
                        costs[i][j] += cuts[j] - cuts[i];
                    }
                }
            }
            System.out.print("The minimum cutting is " + costs[0][n] + ".\n");

            l = scan.nextInt();
        }
    }
}
