package level2;

public class Num124 {
    public static void main(String[] args) {
        Num124 n = new Num124();
        System.out.println(n.solution(10));
    }
    public String solution(int n) {
        // 나머지 0 이면 4, 1이면 2 ,2이면 1
        String[] numbers = {"4", "1", "2"};
        String answer = "";
        int num = n;
        while(num > 0){
            int remain = num % 3;
            num = num/3;
            if(remain == 0) num--;

            answer = numbers[remain] + answer;
        }
        return answer;
    }
}
   //재귀함수를 만들어서 처리할 생각을 함 3으로 나눠서 4 1 2
////1차적 생각
//class Solution {
//    private String answer="";
//    private int exitCode="";
//    public String solution(int n) {
//        int res = cont
//        return answer;
//    }
//
//    public int cont(int n){
//        if (n <= 3){
//            if(n==1) otf=1;
//            if(n==2) otf=2;
//            if(n==3) otf=4;
//            if(n==0) continue;
//            answer=answer+Integer.toString(otf);
//            return exitCode;
//        }else {
//            int a = n/3;
//            int b = n%3;
//            //124나라의 뒷 값
//            int otf=0;
//            if(b==1) otf=1;
//            if(b==2) otf=2;
//            if(b==3) otf=4;
//            answer=answer+Integer.toString(otf);
//            return cont(a);
//        }
//    }
//}