package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static void main(String[] args) {
        int[] answer = new int[2];
        int[] lottos ={};
        int[] win_nums ={};
        int cnt = 0;
        int zeroCnt = 0;
        for(int lotto: lottos){
            if(lotto == 0) {
                zeroCnt ++;
                continue;
            }
            for(int win_num:win_nums){
                if(win_num == lotto){
                    cnt ++;
                    break;
                }
            }
        }
        //    answer[0]=7-Math.max(cnt+zeroCnt,1);
        //    answer[1]=7-Math.max(cnt,1);
    }


}
