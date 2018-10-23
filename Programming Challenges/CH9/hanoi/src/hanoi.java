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
        for(int k = 0; k < testCases; k++) {
            int numPegs = scan.nextInt();
            int[] pegs = new int[numPegs];
            int numBalls = 1;
            boolean pegsFull = false;
            while(true) {
                if(pegsFull) {
                    break;
                }
                int currentPegs = 0;
                while(true) {
                    boolean pegsNotFull = false;
                    for(int i = 0; i < numPegs; i++) {
                        if(pegs[i] == 0) {
                            currentPegs++;
                            pegs[i] = numBalls;
                            pegsNotFull = true;
                            numBalls++;
                            break;
                        }
                        int root = (int) (Math.sqrt(pegs[i] + numBalls));
                        if ((root * root) == pegs[i] + numBalls) {
                            pegs[i] = numBalls;
                            pegsNotFull = true;
                            numBalls++;
                            break;
                        }

                    }
                    if(!pegsNotFull) {
                        pegsFull = true;
                        break;
                    }


                }

            }
            System.out.print((numBalls - 1)+ "\n");
        }
    }
}