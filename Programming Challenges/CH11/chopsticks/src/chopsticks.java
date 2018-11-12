import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code hereMa
        Main main = new Main();
        main.begin();
    }

    void begin(){
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int t = 0; t < testCases; t++) {
            int K = scan.nextInt();
            int N = scan.nextInt();
            int[] chopsticks = new int[N + 1];
            for(int i = 0; i < N; i++) {
                chopsticks[chopsticks.length - i - 1] = scan.nextInt();
            }

            int[][] sets = new int[N + 1][K + 9];
            for(int i = 1; i < sets[0].length; i++) {
                for(int j = 0; j < sets.length; j++) {
                    sets[j][i] = Integer.MAX_VALUE;
                }
            }

            for(int i = 1; i < sets[0].length; i++) {
                for(int j = 3 * i; j < sets.length; j++) {
                    int badness = chopsticks[j - 1] - chopsticks[j];
                    sets[j][i] = Math.min(sets[j - 1][i] ,sets[j - 2][i - 1] + badness * badness );
                }
            }
            System.out.print(sets[N][K+8] + "\n");




        }
    }
}
