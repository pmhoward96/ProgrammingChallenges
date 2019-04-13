import java.util.Scanner;
import java.awt.Polygon;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n != 0) {
            int[] xCoords = new int[n];
            int[] yCoords = new int[n];
            int maxX = 0;
            int maxY = 0;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                xCoords[i] = scan.nextInt();
                yCoords[i] = scan.nextInt();

                if (maxX < xCoords[i]) {
                    maxX = xCoords[i];
                }
                if (maxY < yCoords[i]) {
                    maxY = yCoords[i];
                }
                if (minX > xCoords[i]) {
                    minX = xCoords[i];
                }
                if (minY > yCoords[i]) {
                    minY = yCoords[i];
                }
            }

            Polygon island = new Polygon(xCoords, yCoords, n);
//            for (int i = 0; i < n; i++) {
//                island.addPoint(xCoords[i], yCoords[i]);
//            }

            int count = 0;
            for (int x = minX; x < maxX + 1; x++) {
                for (int y = minY; y < maxY + 1; y++) {
                    if (island.contains(x, y)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            n = scan.nextInt();
        }
    }
}
