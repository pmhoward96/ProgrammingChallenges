
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String r = scan.nextLine();
            StringTokenizer t = new StringTokenizer(r);
            int num = Integer.parseInt(t.nextToken());
            //System.out.println(num);
            int [] values = new int[num];
            for(int i = 0; i < num; i++) {
                values[i] = Integer.parseInt(t.nextToken());
                //System.out.println(values[i]);
            }
            int [] differences = new int[num - 1];
            boolean jolly = false;
            for(int i = 0; i < (num - 1); i++) {
                differences[i] = Math.abs(values[i] - values[i+1]);

                //System.out.print(differences[i] + ", ");
            }
            if(num == 1) {
                jolly = true;
            }
            else {
                for (int i = num - 1; i > 0; i--) {
                    jolly = false;
                    for (int j = 0; j < num - 1; j++) {
                        if (differences[j] == i) {
                            jolly = true;
                            break;
                        }
                    }
                    if (!jolly) {
                        break;
                    }
                }
            }
            if(jolly) {
                System.out.print("Jolly\n");
            }
            else {
                System.out.print("Not jolly\n");
            }



        }

    }
}