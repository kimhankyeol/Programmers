package level2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class NextMaxBinary {
    public static void main(String[] args) {
        int n = 78;
        int oneCount = oneCnt(n);
        for(int i = n+1; i<1000000 ; i++){
           if(oneCnt(i)==oneCount) {
               n = i;
           }
        }
        System.out.println(n);
    }
    private static int oneCnt(int n){
        int oneCount = 0;
        while(n>0){
            if(n%2==1){
                oneCount++;
            }
            n = n/2;
        }
        return oneCount;
    }

}
