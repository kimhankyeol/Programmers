package level1;

import java.util.TreeSet;

public class RandomTwoNumberSum {
    public static void main(String[] args) {
        //실행 메서드
    }
    public TreeSet<Integer> solution(int[] numbers) {
        int sum = 0;
        //트리셋 오름차순 저장
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0 ; i<numbers.length ; i++){
            for(int k=i+1; k<numbers.length;k++){
                sum = numbers[i]+numbers[k];
                treeSet.add(sum);
            }
        }
        return treeSet;
    }
}
