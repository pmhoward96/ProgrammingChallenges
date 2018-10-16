import java.util.Scanner;

class Main {

    static int gcd(int a, int b)
    {
        if (a < b)
            return gcd(b, a);
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    static int power(int x, int y, int mod)
    {
        if (y == 0)
            return 1;
        int temp = power(x, y / 2, mod) % mod;
        temp = (temp * temp) % mod;
        if (y % 2 == 1)
            temp = (temp * x) % mod;
        return temp;
    }

    static boolean isCarmichaelNumber(int n)
    {
        for (int b = 2; b < n; b++) {
            // If "b" is relatively prime to n
            if (gcd(b, n) == 1)

                // And pow(b, n-1)%n is not 1,
                // return false.
                if (power(b, n - 1, n) != 1)
                    return false;
        }
        return true;
    }
    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int[] car = {561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973};
        int n = scan.nextInt();
        while(n != 0) {
            boolean carmichael = false;
            for(int i = 0; i < 15; i++) {
                if(n == car[i]) {
                    carmichael = true;
                    break;
                }
            }
            if(carmichael) {
                System.out.print("The number " + n + " is a Carmichael number.\n");
            }
            else {
                System.out.print(n + " is normal.\n");
            }

            n = scan.nextInt();
        }
    }
}
