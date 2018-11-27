import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
            }
    void begin() {
        Scanner scan = new Scanner(System.in);
        double pi = Math.PI;
        while(scan.hasNext()) {
            double a = scan.nextDouble();
            double aSquared = a * a;
            double z = (aSquared * (12 - 2 * pi - 3 * Math.sqrt(3)))/ 3.0;
            double y = (aSquared* (pi + 6 * Math.sqrt(3) - 12))/ 3.0;
            double x = aSquared - y - z;

            String crossed = String.format("%.3f", z);
            String dot = String.format("%.3f", y);
            String stripped = String.format("%.3f", x);

            System.out.print(stripped + " " + dot + " " + crossed + "\n");
        }
    }
}

