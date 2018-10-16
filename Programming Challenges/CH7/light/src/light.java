import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }
    //Found this method online
    long sqrtLong(long n) {

        long min=0;
        long max=((long)Integer.MAX_VALUE)*2;
        long mid=0;
        while (min<=max) {
            mid=(min+max)/2;
            long value=mid*mid;
            if (value==n) {
                break;
            } else if (value<n) {
                min=mid+1;
            } else {
                max=mid-1;
            }
        }
        return mid;
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        while(n !=  0) {
            long n2 = sqrtLong(n);
            if ((n2 * n2) == n){
                System.out.print("yes" + "\n");
            }
            else {
                System.out.print("no\n");
            }




            n = scan.nextLong();
        }
    }
}
