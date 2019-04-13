import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    Point P[] = new Point[1000];
    //Point CH[] = new Point[1000];

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int cases = 1;
        while (n != 0) {
            for(int i = 0; i < n; i++) {

                int x = scan.nextInt();
                int y = scan.nextInt();
                P[i] = new Point(x, y);
            }
            P[n] = P[0];
            double tile = area_calc(P, n);
            //int m = mono(n);
            ArrayList<Point> CH = convexHull(P, n);
            CH.add(CH.get(0));
            Point[] chArray = CH.toArray(new Point[CH.size()]);
            double cont = area_calc(chArray, chArray.length - 1);
            System.out.print("Tile #" + cases + "\n");
            cases++;
            double wasted = (cont - tile) * 100/cont;
            String w = String.format("%.2f", wasted);
            System.out.print("Wasted Space = " + w + " %\n\n");

            n = scan.nextInt();
        }
    }

    double area_calc(Point P[], int n) {
        double a = 0;
        for(int i = 0; i < n; i++) {
            a += P[i].x * P[i+1].y - P[i].y * P[i + 1].x;
        }
        return Math.abs(a) / 2;
    }


    //Next Two Methods are from https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
    int orientation(Point p, Point q, Point r){
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if(val == 0)
            return 0;
        if(val > 0)
            return 1;
        else
            return 2;
    }

    ArrayList<Point> convexHull(Point points[], int n) {
        if (n < 3)
            return new ArrayList<>();
        ArrayList<Point> hull = new ArrayList<Point>();

        int l = 0;
        for(int i = 1; i < n; i++){
            if(points[i].x < points[l].x){
                l = i;
            }
        }

        int p = l, q;
        do{
            hull.add(points[p]);
            q= (p+1) % n;
            for(int i = 0; i < n; i++){
                if(orientation(points[p], points[i], points[q]) == 2) {
                    q = i;
                }
            }
            p = q;
        }while( p != l);
        return  hull;
    }



//    double cross(Point o, Point a, Point b) {
//        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
//    }
//
//    boolean cmp(Point a, Point b) {
//        if(a.x != b.x) {
//            return a.x < b.x;
//        }
//        return a.y < b.y;
//    }
//
//    int mono(int n) {
//        int i, m, t;
//        m = 0;
//        for(i = 0; i < n; i++) {
//            while(m >= 2 && cross(CH[m-2], CH[m-1], P[i]) <= 0)
//                m--;
//            CH[m++] = P[i];
//        }
//        for(i = n-1, t = m+1; i >= 0; i--) {
//            while(m >=t && cross(CH[m-2], CH[m-1], P[i]) <=0) {
//                m--;
//            }
//            CH[m++] = P[i];
//        }
//        return m;
//    }

    class Point {
        public double x;
        public double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
