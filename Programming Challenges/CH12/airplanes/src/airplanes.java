import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt(), Q = scan.nextInt();
        while(N != 0 && M != 0 && Q != 0) {
            Airport[] airports = new Airport[N];
            for(int i = 0; i < N; i++) {
                String s = scan.next();
                float a = scan.nextFloat();
                float b = scan.nextFloat();
                airports[i] = new Airport(s, a , b);
            }

            for(int j = 0; j < M; j++) {
                String start = scan.next();
                String destination = scan.next();
                int startIndex = 0;
                for(int i = 0; i < N; i++) {
                    if(airports[i].name.equals(start)) {
                        startIndex = i;
                        break;
                    }
                }
                int desIndex = 0;
                for(int i = 0; i < N; i++) {
                    if(airports[i].name.equals(destination)) {
                        desIndex = i;
                        break;
                    }
                }
                airports[startIndex].addConnection(airports[desIndex]);
            }






            N = scan.nextInt(); M = scan.nextInt(); Q = scan.nextInt();
        }


    }

    class Airport {
        public String name;
        public float latitude;
        public float longitude;
        public ArrayList<connection> connections = new ArrayList<>();
        public int numConnections = 0;

        Airport(String s, float a, float b) {

            name = s;
            latitude = a;
            longitude = b;
        }

        void addConnection(Airport b) {
            connection c = new connection(this, b);
            connections.add(c);
            numConnections++;
        }

    }

    class connection {
        String destination;
        String start;
        double distance;

        connection(Airport a, Airport b) {
            double R = 6378;
            double lat1 = (a.latitude);
            double lat2 = (b.latitude);
            double long1 = a.longitude;
            double long2 = b.longitude;
            //double A = Math.sin(diffLat/2) * Math.sin(diffLat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(diffLon) * Math.sin(diffLon);
            double C = Math.acos(Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2) + Math.sin(lat1) * Math.sin(lat2)) * R;
            distance = (R * C);
            start = a.name;
            destination = b.name;

        }
    }
}
