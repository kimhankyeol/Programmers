package level2;
//스택 큐 등 자료구조를 다시공부해야겠다 ... 2020 10 04 너무 모자란게 보인다 ..
import java.util.*;
public class StockPrice {
    public int[] solution(int[] prices) {
        Stack<Integer[]> stack = new Stack<>();
        int[] answer = new int[prices.length];
        //마지막날은 오르지도 내리지도 않음 제외 역순  stack [0] [1] 0은 시간 값 1은 주식
        for(int i = prices.length-2 ; i>=0;i--){
            int time = 0;
            //스택이 비어있지 않거나 스택 꺼낸값에 0번째 값이 배열의 i보다 크면   다음날이 전날 주식값보다 크면
            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                time += stack.pop()[1];
            }

            answer[i] = stack.push(new Integer[]{prices[i], time + 1})[1];
        }

        return answer;
    }
}