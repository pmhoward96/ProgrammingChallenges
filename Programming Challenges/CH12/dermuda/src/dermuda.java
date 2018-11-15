import java.text.DecimalFormat;
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
            int start = scan.nextInt();
            int end = scan.nextInt();
            long sqrtStart = (long) Math.sqrt(start);
            long sqrtEnd = (long) Math.sqrt(end);
            double xStart = getXcoord(start, sqrtStart);
            double yStart = getYcoord(start, sqrtStart);
            double xEnd = getXcoord(end, sqrtEnd);
            double yEnd = getYcoord(end, sqrtEnd);
            double distance = distance(xStart, yStart, xEnd, yEnd);
            //distance = round(distance, 3);
            System.out.print( distance + "\n");
        }

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    float distance(double x1, double y1, double x2, double y2) {
        double diffX = x1 - x2;
        double diffY = y1 - y2;
        double xSquared = diffX * diffX;
        double ySqaured = diffY * diffY;
        return (float)Math.sqrt(xSquared + ySqaured);
    }

    double getXcoord(int n, long sqrt) {
        if(n == 0) {
            return 0;
        }
        long midpoint = (sqrt * sqrt + (sqrt + 1) * (sqrt + 1) - 1) / 2;
        if(midpoint == n) {
            return 0;
        }
        return (0.5 * (n - midpoint));
    }

    double getYcoord(int n, long sqrt) {
        if(n == 0) {
            return 0;
        }
        long y = 1 + 3 *(sqrt -1);
        if((sqrt * sqrt - n) % 2 == 0) {
            y = y + 2;
        }
        else {
            y = y + 1;
        }

        return (( Math.sqrt(3) / 6) * y);
    }
}
