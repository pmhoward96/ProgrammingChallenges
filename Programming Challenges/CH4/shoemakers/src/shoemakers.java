import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main{

public static void main (String[]args) throws Exception{
//writeyourcodehere
Main main=new Main();
main.begin();
}


void begin() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int testCases= Integer.parseInt(br.readLine());
for(int i=0;i<testCases;i++){
    int numJobs=Integer.parseInt(br.readLine());
    double[][]jobs=new double[numJobs][];
    for(int j=0, x;j<numJobs;j++){
        String s = br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        x = Integer.parseInt(st.nextToken());
        jobs[j] = new double[] {1.0 * Integer.parseInt(st.nextToken()) / x, j + 1};
//System.out.println(jobs[j][0]+""+jobs[j][1]+""+jobs[j][2]);

    }

    Arrays.sort(jobs,new Comparator<double[]>(){
    @Override
    public int compare(double[]doubles,double[]t1){
        if(doubles[0] != t1[0]) {
            return t1[0] < doubles[0] ? -1 : 1;
        }
        return (doubles[1] + "").compareTo(t1[1] + "");
    }
    });

    for(int j = 0; j < numJobs; j++) {
        System.out.print((int)jobs[j][1] + (j < numJobs - 1 ? " " : ""));
    }
    System.out.print("\n");
//    int[]sorted=new int[numJobs];
//    int n=numJobs-1;
//    for(int j=0;j<numJobs;j++){
//        sorted[j]=(int)jobs[n-j][3];
//    }
//
//
//    for(int j=0;j<numJobs;j++){
//        System.out.print(sorted[j]+" ");
//    }
//    System.out.print("\n");

}
}
}
