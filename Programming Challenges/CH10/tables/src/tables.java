//import java.util.Arrays;
//import java.util.Scanner;
//
//class Main {
//
//    public static void main(String[] args) {
//	// write your code here
//        Main main = new Main();
//        main.begin();
//    }
//
//    void begin() {
//        Scanner scan = new Scanner(System.in);
//        int numTeams = scan.nextInt();
//        int numTables = scan.nextInt();
//        while(true) {
//            if(numTables == 0 && numTeams == 0){
//                break;
//            }
//            int[] teams = new int[numTeams];
//            table[] tables = new table[numTables];
//            for(int i = 0; i < numTeams; i++) {
//                teams[i] = scan.nextInt();
//            }
//
//            boolean tooManyMembers = false;
//            for(int i = 0; i < numTeams; i++) {
//                if(teams[i] > numTables) {
//                    tooManyMembers = true;
//                }
//            }
//
//            if(tooManyMembers) {
//                System.out.print(0 + "\n");
//            }
//
//            else {
//                for(int i = 0; i < numTables; i++) {
//                    tables[i] = new table(i+1, scan.nextInt());
//                }
//                Arrays.sort(tables);
//
//                int[][] seating = new int[numTeams][numTables];
//                boolean flag = false;
//                for(int i = 0; i < numTeams && !flag; i++) {
//                    for(int j = 0; j < teams[i]; j++) {
//                        seating[i][j] = tables[j].tableNumber;
//                        tables[j].capacity--;
//                        if(tables[j].capacity < 0) {
//                            flag = true;
//                        }
//                    }
//                }
//                if(flag) {
//                    System.out.print(0 + "\n");
//                }
//                else {
//                    System.out.print(1 + "\n");
//                    for(int i = 0; i < numTeams; i++) {
//                        //System.out.print("\n");
//                        for(int j = 0; j < teams[i]; j++) {
//                            if(j == teams[i] - 1) {
//                                System.out.print(seating[i][j] + "\n");
//                            }
//                            else {
//                                System.out.print(seating[i][j] + " ");
//                            }
//                        }
//                    }
//                }
//            }
//
//            numTeams = scan.nextInt();
//            numTables = scan.nextInt();
//        }
//    }
//
//    static class table implements Comparable<table> {
//        int tableNumber;
//        int capacity;
//        table(int tn, int cap) {
//            tableNumber = tn;
//            capacity = cap;
//        }
//
//        @Override
//        public int compareTo(table t) {
//            return t.capacity-this.capacity;
//        }
//    }
//}
