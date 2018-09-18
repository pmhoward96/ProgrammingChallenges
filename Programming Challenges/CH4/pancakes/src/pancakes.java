

import java.util.Scanner;
import java.util.StringTokenizer;


 class Main {

   public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            StringTokenizer st = new StringTokenizer(s);
            int numPan = st.countTokens();
            int[] pancakes = new int[numPan];
            for(int i = 0; i < numPan; i++) {
                pancakes[i] = Integer.parseInt(st.nextToken());
            }
            int[] orig = pancakes;

            boolean sorted = false;
            int n = 0;
            while(!sorted) {
                for(int i = 0; i < pancakes.length - 1; i++) {
                    if(pancakes[i] > pancakes[i + 1]){
                        sorted = false;
                        break;
                    }
                    else {
                        sorted = true;
                    }

                }

                if(!sorted){
                    int max = 1;
                    int maxLocation = 0;
                    for(int i = 0; i < pancakes.length - n; i++) {
                        if(pancakes[i] > max) {
                            max = pancakes[i];
                            maxLocation = i;
                        }
                    }

                    if(maxLocation == 0) {
                        flip(pancakes, 1 + n);
                        n++;
                        System.out.println("flipped");
                    }
                    else {
                        System.out.println("Else");
                    }
                }
            }
            for(int i = 0; i < orig.length - 1; i++) {
                System.out.print(orig[i] + ' ');
            }
            System.out.print(orig[orig.length - 1] + "\n");


        }

    }
    void flip(int[] pancakes, int flip) {
        for(int i = 0; i < ((pancakes.length) - (flip - 1)) / 2; i++)
        {
            int temp = pancakes[i];
            pancakes[i] = pancakes[pancakes.length - i - 1];
            pancakes[pancakes.length - i - 1] = temp;
        }
    }

}
