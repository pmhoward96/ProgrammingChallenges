import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    public static int gcdExtended(int a, int b, int x, int y)
    {
        // Base Case
        if (a == 0)
        {
            x = 0;
            y = 1;
            return b;
        }

        int x1=1, y1=1; // To store results of recursive call
        int gcd = gcdExtended(b%a, a, x1, y1);

        // Update x and y using results of recursive
        // call
        x = y1 - (b/a) * x1;
        y = x1;

        return gcd;
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(); int b = scan.nextInt();
        while(a != 0 && b != 0) {
            int x = 1;
            int y = 1;
            int d = gcdExtended(a, b, x, y);
            System.out.println(x + " " + y + " " + d);
            a = scan.nextInt();
            b = scan.nextInt();
        }
    }
}
