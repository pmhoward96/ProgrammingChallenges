import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        int[] values = {1, 2, 3, 1};
        int max = 1001;
        BigInteger[] br = new BigInteger[max];

        Arrays.fill(br, BigInteger.ZERO);
        br[0] = new BigInteger("1");
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < values.length; j++) {
                if(i - values[j] >= 0) {
                    br[i] = br[i].add(br[i - values[j]]);
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        while( scan.hasNext()){
            int s = scan.nextInt();
            System.out.print(br[s] + "\n");
        }
    }
}
