package level2;

import java.util.LinkedList;
import java.util.Queue;
/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
정수 n을 이진수로 바꿔서 0개수 제일 긴거 찾으면 됨 10001001  답은3
*/
//codility 1단계
public class BinaryGap {
    static int N = 1041;
    static  int count = 0;
    static int max = 0;

    public static void main(String[] args) {
        Queue<Integer>  q = new LinkedList<>();
        while (N >=1) {
            int rem = N%2;
            N = N/2;
            q.add(rem);
        }
        w(q);
    }
    static int w(Queue q){
        while(!q.isEmpty()){
            int prev = 0;
            prev = (int) q.poll();
            if( prev == 1){
                count = 0;
            }
            if( prev == 0){
                count++;
                max = Math.max(max,count);
            }
            w(q);
        }
        return  max;
    }
}