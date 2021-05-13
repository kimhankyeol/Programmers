package level1;

import java.util.Arrays;

public class BudgetRecur {
    static int[] d = {1,3,2,5,4};
    static int budget = 9;
    public static void main(String[] args) {
        int answer = 0;
        Arrays.sort(d); //오름차순
        for(int i=0; i<d.length; i++) {
            //예산이 0이 되거나 지원해주려는 부서보다 작으면 종료한다.
            if (budget == 0 || budget < d[i]) {
                break;
            }
            budget -= d[i];
            answer++;
        }

        System.out.println(answer);
    }

}
