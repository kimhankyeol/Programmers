package level1;

import java.util.Stack;
//카카오 크레인
public class kakaoCrainDoll {
    public static void main(String[] args) {
        kakaoCrainDoll k = new kakaoCrainDoll();
        int[][]  board= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int result =  k.solution(board,moves);
        System.out.println(result);
    }
    public int solution(int[][] board, int[] moves) {
        // 터진 횟수
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(Integer move : moves)
        {
            // move 인덱스를 배열인덱스로 맞춰야함

            for(int i = 0; i < board.length; i++) {
                int k = board[i][move - 1];
                if(k == 0) {
                    continue;
                }
                //스택이 비어있지 않고 스택의 최상위 값 (결과 값 ) 과 보드(집게로 집은 값)이 일치할떄
                if(!stack.empty() && stack.peek() == k) {
                    stack.pop();
                    //터진 횟수;
                    result++;
                } else {
                    stack.push(k);
                }
                //꺼내고 난후 board 0
                board[i][move-1] = 0;
                break;
            }
        }
        //인형이 1개만 터지는게 아니라 2개 터지기 때문
        return result * 2;
    }
}
