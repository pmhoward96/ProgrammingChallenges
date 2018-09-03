

#include <cstdlib>
#include <iostream>
#include <stdio.h>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int m,n;
    while ((scanf("%d %d", &m, &n)) == 2){
        int mOrig = m;
        int nOrig = n;
        
        if(n < m) {
            int temp = m;
            m = n;
            n = temp;
        }
        
        int max = 0;
        for(int k = m; k <= n; k++) {
            int count = 1;
            int cc = k;
            while(cc != 1) {
                if((cc % 2) == 0) {
                    cc = cc/2;
                }
                else {
                    cc = (3 * cc) + 1;
                }
                count++;
            }
            if(max < count) {
                max = count;
            }
        }
        
        cout << endl << mOrig << " " << nOrig << " " << max ;
    }

    return 0;
}

