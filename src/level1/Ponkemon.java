package level1;

import java.util.TreeSet;

public class Ponkemon {
    private static int[] ponkeArr = {3,3,3,2,2,2};

    public static void main(String[] args) {
        //1. 최대로 고를수 있는 폰케몬 수
        int maxPonke = ponkeArr.length/2;
        //2. 배열 중복 제거
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i : ponkeArr){
            treeSet.add(i);
        }
        if(maxPonke>=treeSet.size())
            System.out.println(treeSet.size());
        else
            System.out.println(maxPonke);

    }
}
