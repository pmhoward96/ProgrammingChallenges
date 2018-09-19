import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.time.temporal.ChronoUnit.MINUTES;

class Main {

    public class appointment implements Comparable<appointment> {
        LocalTime begin;
        LocalTime end;

        appointment(LocalTime b, LocalTime e) {
            begin = b;
            end = e;
        }

        public void setBegin(LocalTime begin) {
            this.begin = begin;
        }

        public void setEnd(LocalTime end) {
            this.end = end;
        }

        public LocalTime getBegin() {
            return begin;
        }

        public LocalTime getEnd() {
            return end;
        }

        @Override
        public int compareTo(appointment ap) {
            return begin.compareTo(ap.begin);
        }
    }

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
            appointment[] aps = new appointment[testCases];
            for(int i = 0; i < testCases; i++) {
                String s = scan.nextLine();
                StringTokenizer st = new StringTokenizer(s);
                aps[i] = new appointment(LocalTime.parse(st.nextToken(), DateTimeFormatter.ofPattern("HH:mm")), LocalTime.parse(st.nextToken(), DateTimeFormatter.ofPattern("HH:mm")));

            }
            //Sorting Appointments
            Arrays.sort(aps, new Comparator<appointment>() {
                @Override
                public int compare(appointment ap1, appointment ap2) {
                    return ap1.begin.compareTo(ap2.begin);
                }
            });


            //Calculating Differences
            int[] minutes = new int[testCases + 1];
            LocalTime begin =  LocalTime.of(10, 00);
            LocalTime end = LocalTime.of(18, 00);
            int max = 0;
            int maxPosition = 0;
            for(int i = 0; i < testCases + 1; i++) {
                if(i == 0) {
                    minutes[i] = (int)begin.until(aps[0].begin, MINUTES);
                }
                else if(i == testCases) {
                    minutes[i] = (int)aps[i - 1].end.until(end, MINUTES);

                }
                else {
                    minutes[i] = (int)aps[i-1].end.until(aps[i].begin, MINUTES);

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
                out = OutputBuild(aps[maxPosition-1].end, minutes[maxPosition], day);
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
