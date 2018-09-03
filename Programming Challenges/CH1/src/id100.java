import java.io.IOException;
import java.util.Scanner;

public class id100 {

    public static void main(String[] args) throws IOException{
        id100 m = new id100();
        m.begin();
    }

    void begin() throws IOException {
        //Getting Inputs
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int i = in.nextInt();
            int j = in.nextInt();
            int origI = i;
            int origJ = j;


            //Swap if j greater than i
            if (j < i) {
                int temp = i;
                i = j;
                j = temp;
            }

            int max = 0;
            //For Loop to walkthrough i - j
            for (int k = i; k <= j; k++) {
                int count = 1;
                int cc = k;
                while (cc != 1) {
                    if ((cc % 2) == 0) {
                        cc = cc / 2;
                    } else {
                        cc = (3 * cc) + 1;
                    }
                    count = count + 1;
                }

                if (max < count) {
                    max = count;
                }

            }

            System.out.println(origI + " " + origJ + " " + max);


        }
    }
}
