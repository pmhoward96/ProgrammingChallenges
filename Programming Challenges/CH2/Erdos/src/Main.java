import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	    Main main = new Main();
	    main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int scenarios = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < scenarios; i ++) {
            StringTokenizer st = new StringTokenizer(scan.nextLine());
            int numPapers = Integer.parseInt(st.nextToken());
            int numAuthors = Integer.parseInt(st.nextToken());

            String papers[] = new String[numPapers];
            String authors[] = new String[numAuthors];

            for(int j = 0; j < numPapers; j++) {
                papers[j] = scan.nextLine();
                //System.out.println(papers[j]);
            }
            for(int j = 0; j < numAuthors; j++) {
                authors[j] = scan.nextLine();
                //System.out.println(authors[j]);
            }
            Boolean first = false;
            Boolean second = false;
            System.out.print("Scenario " + (i + 1) + "\n");
            for(int j = 0; j < numAuthors; j++) {
                for(int k = 0; k < numPapers; k++) {
                    if((papers[k].contains("Erdos, P.")) && papers[k].contains(authors[j])) {
                        System.out.print(authors[j] + " 1");
                        first = true;
                        break;
                    }
                    else if(papers[k].contains(authors[j])) {

                    }
                }
            }

//            int testCount = 0;
//            for(int j = 0; j < numPapers; j++) {
//                if(papers[j].contains("Erdos, P.")) {
//                    testCount++;
//                }
//            }
//            System.out.println("TestCount: " + testCount);
        }
    }
}
