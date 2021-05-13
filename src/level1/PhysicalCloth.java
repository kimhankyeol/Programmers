package level1;

import java.util.Arrays;

public class PhysicalCloth {
    static private int[] lost = {1,2};
    static private int[] reserve = {2,3};
    static private int n = 3;

    public static void main(String[] args) {
        //1. 체육복 있고 없고
        // 여분이 있으면 1 없으면 0  체육복이 아예 없으면 -1
        int[] res = new int[n];
        //여분이 있으면
        for(int i = 0 ; i<reserve.length ; i++){
            res[reserve[i]-1] = 1;
        }
        //여벌 체육복이 있는 학생이 도난 당한 경우
        for(int i = 0 ; i<lost.length ; i++){
            for(int j = 0 ; j<reserve.length ; j++){
                if(lost[i]==reserve[j]){
                    res[lost[i]-1]=0;
                    break;
                }
            }
        }

        //체육복이 없는 학생(-1)들을 기준으로 앞뒤 판별
        for(int i = 0 ;i<res.length; i++){
            if(res[i]==-1){
                if(i==0){
                    if(i+1<=res.length && res[i+1] == 1)
                        res[i] = res[i+1] = 0;
                }else if(i>0 && i==res.length-1){
                    if(res[i-1] == 1)
                        res[i] = res[i-1] = 0;
                }else if( i>0 && i<res.length-1){
                    if(res[i-1]==1)
                        res[i]=res[i-1]=0;
                    else if(res[i+1]==1 )
                        res[i]=res[i+1]=0;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
