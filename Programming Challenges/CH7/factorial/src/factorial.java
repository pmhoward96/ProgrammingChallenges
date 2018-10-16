import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.begin();
    }

    BigInteger factorial (BigInteger n, int count) {
        if(count == 0) {
            return n;
        }
        n = n.multiply(new BigInteger(Integer.toString(count)));
        return factorial(n, count - 1);
    }

    int get_powers(int n, int p ) {
        int res = 0;
        if(p == 1) {
            return 1;
        }
        for(long power = p ; power <= n; power *= p) {
            res += n/power;
        }
        return res;
    }

    // A function to print all prime factors
    // of a given number n
    public static void primeFactors(int n, ArrayList<Integer> primeFactors)
    {
        // Print the number of 2s that divide n
        while (n%2==0)
        {
            primeFactors.add(2);
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                primeFactors.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            primeFactors.add(n);
        if(n == 1) {
            primeFactors.add(n);
        }
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int orign = scan.nextInt();
            int origm = scan.nextInt();
            int n; int m;
            if(orign == 0) {
                n = 1;
            }
            else {
                n = orign;
            }
            if(origm == 0) {
                m = 1;
            }
            else {
                m = origm;
            }
            ArrayList<Integer> mFactors = new ArrayList<Integer>();
            primeFactors(m, mFactors);
//            for(int i = 0; i < mFactors.size(); i ++) {
//                System.out.println(mFactors.get(i));
//            }
            int[][] factors = new int[mFactors.size()][2];
            int fCount = 0;
//            Arrays.fill(factors, 0);
            for(int i = 0; i < mFactors.size(); i++) {
                boolean a = false;
                for(int j = 0; j < mFactors.size(); j++) {
                    if(mFactors.get(i) == factors[j][0]) {
                        factors[j][1]++;
                        a = true;
                        break;
                    }
                }
                if(!a) {
                    factors[fCount][0] = mFactors.get(i);
                    factors[fCount][1] = 1;
                    fCount++;
                }

            }
            boolean divides = false;
            for(int i = 0; i < factors.length; i++) {
                if(factors[i][0] != 0) {
                    if(get_powers(n, factors[i][0]) >= factors[i][1]) {
                        divides = true;
                    }
                    else {
                        divides = false;
                        break;
                    }
                }
            }

            if(divides) {
                System.out.print(origm + " divides " + orign + "!\n");
            }
            else {
                System.out.print(origm + " does not divide " + orign + "!\n");
            }





        }
    }
}
