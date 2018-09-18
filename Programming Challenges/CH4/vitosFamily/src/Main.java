import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.StrictMath.abs;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testCases; i++) {
            String s = scan.nextLine();
            StringTokenizer st = new StringTokenizer(s);
            int numRelatives = Integer.parseInt(st.nextToken());
            int[] relatives = new int[numRelatives];
            for(int j = 0; j < numRelatives; j++) {
                relatives[j] = Integer.parseInt(st.nextToken());
                //System.out.println(relatives[j]);
            }

            int low = 2147483647;
            for(int j = 0; j < numRelatives; j++) {
                int sumDiff = 0;
                for(int k = 0; k < numRelatives; k++) {
                    sumDiff = sumDiff + (Math.abs(relatives[k] - relatives[j]));
                }
                low = Math.min(low, sumDiff);
            }
            System.out.print(low + "\n");
        }

    }
}
