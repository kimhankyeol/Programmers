package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Stage {
    static int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
    static int N = 5;
    public static void main(String[] args) {
        List<SortStage> list = new ArrayList<>();
        for(int j = 1 ; j<=N ;j++){
            int fail = 0;
            int success = 0;
            for(int i = 0 ; i<stages.length; i++){
                if(j<=stages[i]){
                    success++;
                }
                if(stages[i]!=N+1 && j==stages[i]){
                    fail++;
                }
            }
            list.add(new SortStage(j,(double) fail/success));
            list.sort(SortStage::compareTo);
        }
        list.stream().mapToInt(SortStage::getNum).toArray();
//        Arrays.stream(list.stream().mapToInt(SortStage::getNum).toArray()).map(d-> System.out.println(d))
//        HashMap<Integer,Double> hMap = new HashMap<>();
//        for(int k = 0 ; k<N; k++){
//            System.out.println(k+1+"번쨰 스테이지 통과한 플레이어 " +success[k] );
//            System.out.println(k+1+"번쨰 스테이지  통과 못한플레이어" +fail[k] );
//            System.out.println("실패율:"+(float) fail[k]/success[k]);
//        }


    }


}
class SortStage implements Comparable<SortStage> {

    private int num; // 고유번호
    private double failure; // 실패율

    public int getNum() {
        return num;
    }

    public SortStage(int num, double failure) {
        this.num = num;
        this.failure = failure;
    }

    @Override
    public int compareTo(SortStage o) {
        System.out.println(this.num+":"+this.failure);
        System.out.println(o.num+":"+o.failure);
        System.out.println("-----------");
        if (this.failure == o.failure) {
            return this.num < o.num ? -1 : 1;
        } else {
            return this.failure > o.failure ? -1 : 1;
        }
    }
}

