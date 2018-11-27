import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int s = scan.nextInt();
            long n = s;
            //BigInteger two = new BigInteger("2");
            //BigInteger six = new BigInteger("6");
            long s2, r2;
            long s3, r3;
            long s4 = 0, r4;

            s2 = n * (n+1) *(2*n+1)/6;
            r2 = (n+1) * n/2 * (n+1) * n/2 - s2;
            System.out.print(s2 + " " + r2 + " ");

            s3 = n * (n+1)/2 * n * (n+1)/2;
            r3 = (n + 1) * n/2 * (n+1) * n/2 * (n+1) * n/2 - s3;
            System.out.print(s3 + " " + r3 + " ");

            for(int i = 1; i <= n; i++) {
                s4 += (i * i * i * i);
            }
            r4 = (n+1) * n/2 * (n+1) * n/2 * (n+1) * n/2 * (n+1) * n/2 - s4;
            System.out.print(s4 + " " + r4 + "\n");
        }
    }
}
