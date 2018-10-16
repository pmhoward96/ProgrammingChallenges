import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int testCases = 1;
        int correctLines = Integer.parseInt(scan.nextLine());
        while(correctLines != 0) {
            StringBuilder correctSb = new StringBuilder();
            for(int i = 0; i < correctLines; i++) {
                correctSb.append(scan.nextLine());
                //correctSb.append("\n");
            }

            int answerLines = Integer.parseInt(scan.nextLine());
            StringBuilder answerSb = new StringBuilder();
            for(int i = 0; i < answerLines; i++) {
                answerSb.append(scan.nextLine());
                //answerSb.append("\n");
            }
            char[] correct = correctSb.toString().toCharArray();
            char[] answer  = answerSb.toString().toCharArray();

//            System.out.println("Correct: " + correctSb.toString());
//            System.out.println("Answer: " + answerSb.toString());
            StringBuilder correctNum = new StringBuilder();
            StringBuilder answerNum = new StringBuilder();
            for(int i = 0; i < correct.length; i++) {
                if(Character.isDigit(correct[i])) {
                    correctNum.append(correct[i]);
                }
            }
            for(int i = 0; i < answer.length; i++) {
                if(Character.isDigit(answer[i])) {
                    answerNum.append(answer[i]);
                }
            }


            if(Objects.equals(correctSb.toString(), answerSb.toString()) && correctLines == answerLines) {
                System.out.print("Run #" + testCases + ": Accepted\n");
            }
            else if(Objects.equals(correctNum.toString(), answerNum.toString()) ){
                System.out.print("Run #" + testCases + ": Presentation Error\n");
            }
            else {
                System.out.print("Run #" + testCases + ": Wrong Answer\n");
            }


            correctLines = Integer.parseInt(scan.nextLine());
            testCases++;

        }
    }
}
