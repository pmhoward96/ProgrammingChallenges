import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.begin();
    }

    void begin() {
        //Getting Inputs
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n != 0) {
            double[] money = new double[n];
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                money[i] = in.nextDouble();
                sum += money[i];
            }

            double avg = Math.round((sum / (double) n) * 100.00) / 100.00;
            double below = 0.00;
            double above = 0.00;
            double d = 0.00;
            for(int i = 0; i < n; i++) {
                d = money[i] - avg;
                if(d < 0) {
                    below = below + (-1 * d);
                }
                else {
                    above = above + d;
                }
            }

            double equalizer = 0.00;
            if(below < above) {
                equalizer = below;
            }
            else {
                equalizer = above;
            }

            System.out.printf("$%.2f\n", equalizer);

            n = in.nextInt();
        }
    }
}