import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int numInner = scan.nextInt();
            int[][] inner = new int[numInner][2];
            for(int i = 0; i < numInner; i++) {
                inner[i][0] = scan.nextInt();
                inner[i][1] = scan.nextInt();
            }


        }
    }
}
