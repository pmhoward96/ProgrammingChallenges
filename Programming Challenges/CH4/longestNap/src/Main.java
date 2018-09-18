import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.time.temporal.ChronoUnit.MINUTES;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        m.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int day = 1;
        while(scan.hasNextLine()) {

            //Inputting Times
            int testCases = Integer.parseInt(scan.nextLine());
            LocalTime[][] ss = new LocalTime[testCases][2];
            for(int i = 0; i < testCases; i++) {
                String s = scan.nextLine();
                StringTokenizer st = new StringTokenizer(s);
                for(int j = 0; j < 2; j++) {
                    String sb = st.nextToken();
                    if(sb != ":") {
                        ss[i][j] = LocalTime.parse(sb, DateTimeFormatter.ofPattern("HH:mm"));
                        //System.out.println(ss[i][j]);
                    }

                }
            }

            //Calculating Differences
            int[] minutes = new int[testCases + 1];
            LocalTime begin =  LocalTime.of(10, 00);
            LocalTime end = LocalTime.of(18, 00);
            int max = 0;
            int maxPosition = 0;
            for(int i = 0; i < testCases + 1; i++) {
                if(i == 0) {
                    minutes[i] = (int)begin.until(ss[0][0], MINUTES);
                }
                else if(i == testCases) {
                    minutes[i] = (int)ss[testCases-1][1].until(end, MINUTES);

                }
                else {
                    minutes[i] = (int)ss[i - 1][1].until(ss[i][0], MINUTES);

                }
                //System.out.println(minutes[i]);
                if(minutes[i] > max) {
                    max = minutes[i];
                    maxPosition = i;
                }

            }
            String out = "";
            if(maxPosition == 0) {
                out = OutputBuild(begin, minutes[maxPosition],day);
            }
            else {
                out = OutputBuild(ss[maxPosition-1][1], minutes[maxPosition], day);
            }
            day++;
            System.out.print(out);

        }
    }

    String OutputBuild(LocalTime lt, int minutes, int day) {
        StringBuilder sb = new StringBuilder();
        sb.append("Day #");
        sb.append(day);
        sb.append(" the longest nap starts at ");
        sb.append(lt);
        sb.append(" and will last for ");
        if(minutes >= 60) {
            int hours = minutes / 60;
            int mm = minutes - (60 * hours);
            sb.append(hours);
            sb.append(" hours and ");
            sb.append(mm);
            sb.append(" minutes.\n");
        }
        else {
            sb.append(minutes);
            sb.append(" minutes.\n");
        }
        String ss = sb.toString();
        return ss;
    }
}
