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
        for(int j = 0; j < testCases; j++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            int diff = b - a;
            int both = 0;
            int steps = 0;
            int stepLength = 1;

            while(diff > 0) {
                diff = diff - stepLength;
                steps++;
                if(both == 1) {
                    stepLength++;
                    both = 0;
                }
                else {
                    both = 1;
                }

            }
            System.out.print(steps + "\n");

        }
    }
}