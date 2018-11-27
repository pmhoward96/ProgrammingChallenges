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
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();

            double radius = 0.000;
            //radius = (a / (2 * (float)Math.sqrt(3)));
            if(a != 0 && b != 0 && c != 0) {
                double s = (a + b + c) / 2;
                double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                double per = a + b + c;
                radius = (2 * area) / per;
            }

            String r = String.format("%.3f", radius);

            System.out.print("The radius of the round table is: " + r + "\n");

        }
    }
}
