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
            int n = scan.nextInt();
            float gX = scan.nextFloat();
            float gY = scan.nextFloat();
            float dX = scan.nextFloat();
            float dY = scan.nextFloat();

            float holes[][] = new float[n][2];
            for (int i = 0; i < n; i++) {
                holes[i][0] = scan.nextFloat();
                holes[i][1] = scan.nextFloat();
            }

            float distances[][] = new float[n][2];
            for (int i = 0; i < n; i++) {
                distances[i][0] = 2 * distanceCal(gX, gY, holes[i][0], holes[i][1]);
                distances[i][1] = distanceCal(dX, dY, holes[i][0], holes[i][1]);
            }

            boolean caught = false;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (distances[i][0] <= distances[i][1]) {
                    caught = true;
                    index = i;
                    break;
                }
            }

            if (caught) {
                //String x = Float.toString(holes[index][0]);
                //String y = Float.toString(holes[index][1]);
                String x = String.format("%.3f", holes[index][0]);
                String y = String.format("%.3f", holes[index][1]);
                System.out.print("The gopher can escape through the hole at (" + x + "," + y + ").\n");
            } else {
                System.out.print("The gopher cannot escape.\n");

            }
        }

    }

    float distanceCal(float x1, float y1, float x2, float y2) {
        float xs = (x2 - x1) * (x2 - x1);
        float ys = (y2 - y1) * (y2 - y1);

        return (float)Math.sqrt(xs + ys);
    }
}
