import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.begin();
    }

    void begin(){
        Scanner scan = new Scanner(System.in);
        int numTeams = scan.nextInt();
        int numTables = scan.nextInt();

        while(numTeams != 0 && numTables != 0) {
            team[] teams = new team[numTeams];
            for(int i = 0; i < numTeams; i++) {
                teams[i] = new team(i+1, scan.nextInt());
            }
            tables[] t = new tables[numTables];
            int tablesLeft = 0;
            for(int i = 0; i < numTables; i++) {
                t[i] = new tables(i + 1, scan.nextInt());
                tablesLeft++;
            }

            Arrays.sort(teams);

            boolean set = true;
            int count = 0;
            for(int i = 0; i < numTeams && set; i++) {
                team s = teams[i];
                if(tablesLeft < s.members) {
                    set = false;
                    continue;
                }
                Arrays.sort(t);

                for(int j = 0, k = 0; k < s.members; j++) {
                    if(t[j].capacity > 0) {
                        count++;
                        //System.out.print(count + "\n");
                        s.tables[k++] = t[j].id;
                        t[j].capacity--;
                        if(t[j].capacity==0) {
                            tablesLeft--;
                        }
                    }
                }
            }
            if(set) {
                System.out.print(1 + "\n");
                Arrays.sort(teams, new ids());
                for(int i = 0; i < numTeams; i++) {
                    team current = teams[i];
                    Arrays.sort(current.tables);
                    for(int j = 0; j < current.members; j++) {
                        if(j == current.members - 1) {
                            System.out.print(current.tables[j] + "\n");
                        }
                        else {
                            System.out.print(current.tables[j] + " ");
                        }
                    }
                }
            }
            else {
                System.out.print(0 + "\n");
            }


            numTeams = scan.nextInt();
            numTables = scan.nextInt();
        }

    }

//    static boolean seatingChart( int ids) {
//
//    }
    class team implements Comparable<team>{
        int teamNum;
        int members;
        int[] tables;

        team(int tn, int m) {
            teamNum = tn;
            members = m;
            tables = new int[m];
        }

        public int compareTo(team t) {
            return t.members - this.members;
        }
    }

    class tables implements Comparable<tables> {
        int id;
        int capacity;

        tables(int i, int cap) {
            id = i;
            capacity = cap;
        }

        public int compareTo(tables t) {
            return  t.capacity - this.capacity;
        }
    }

    class ids implements Comparator<team> {
        @Override
        public int compare(team t1, team t2) {
            return t1.teamNum - t2.teamNum;
        }
    }
}
