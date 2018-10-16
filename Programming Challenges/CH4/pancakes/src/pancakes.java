

import java.util.Arrays;
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
            int[] orig = Arrays.copyOf(pancakes, pancakes.length);
            int[] sorted = Arrays.copyOf(pancakes, pancakes.length);
            Arrays.sort(sorted);
            StringBuilder flips = new StringBuilder();

            for(int i = numPan - 1; i >= 0; i--) {
                if(sorted[i] != pancakes[i]) {
                    if(sorted[i] != pancakes[0]) {
                        int n = i - 1;
                        while(n >= 0) {
                            if(pancakes[n] == sorted[i]) {
                                break;
                            }
                            n--;
                        }
                        flip(pancakes, numPan - n);
                        flips.append(numPan - n + " ");
                    }
                    flip(pancakes, numPan - i);
                    flips.append(numPan - i + " ");

                }
            }
            flips.append(0 + "\n");
            for(int i = 0; i < numPan; i++) {
                System.out.print(orig[i] + " ");
            }
            System.out.print("\n");
            System.out.print(flips.toString());
        }

    }
    public static void flip (int [] pancakes, int flipLocation) {
        int [] temp= Arrays.copyOf(pancakes, pancakes.length);

        int endIndex=pancakes.length-flipLocation;
        for (int i=0;i<=endIndex;i++) {
            pancakes[i]=temp[endIndex-i];
        }
    }


}
