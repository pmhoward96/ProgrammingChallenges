import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        ArrayList<BigInteger> sb = new ArrayList<BigInteger>();
        BigInteger f = new BigInteger("0");
        BigInteger g = new BigInteger("1");
        BigInteger max = new BigInteger("10");
        max = max.pow(100);
        //sb.add(f); sb.add(g);
        while(g.compareTo(max) != 1) {
            BigInteger sum = f.add(g);
            sb.add(sum);
            f = g;
            g = sum;

        }

        while(scan.hasNextBigInteger()) {
            BigInteger a = scan.nextBigInteger();
            BigInteger b = scan.nextBigInteger();
            if(a.compareTo(new BigInteger("0")) == 0 && b.compareTo(new BigInteger("0")) == 0) {
                break;
            }

            int count = 0;
            int i = 0;
            while(sb.get(i).compareTo(b) == -1 || sb.get(i).compareTo(b) == 0) {
                if(sb.get(i).compareTo(a) == 0 || sb.get(i).compareTo(a) == 1) {
                    count++;
                }
                i++;
            }
            System.out.print(count + "\n");
        }

        //System.out.print(max);
    }
}
