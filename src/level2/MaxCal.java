package level2;

import java.util.*;

public class MaxCal {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        String[] loop = {"*+-", "*-+", "+*-", "+-*", "-+*", "-*+"};
        String regExp = "\\D+";
        String regExp2 = "[0-9]+";
        LinkedList<Long> num = new LinkedList<>();
        LinkedList<String> cal = new LinkedList<>();
        LinkedList<Long> num2 = new LinkedList<>();
        LinkedList<String> cal2 = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < expression.split(regExp).length; i++) {
            num.add(Long.parseLong(expression.split(regExp)[i]));
        }
        for (int j = 0; j < expression.split(regExp2).length; j++) {
            if (!expression.split(regExp2)[j].equals("")) {
                cal.add(expression.split(regExp2)[j]);
                set.add(expression.split(regExp2)[j]);
            }
        }
        long sum = 0;
        long max = 0;
        //연산식 1개일떄 는 단순계산 해주면 통과

        for (int a = 0; a < loop.length; a++) {
            num2 = (LinkedList) num.clone();
            cal2 = (LinkedList) cal.clone();
            for (int i = 0; i < loop[a].length(); i++) {
                sum = 0;
                String compare = loop[a].charAt(i) + "";
                System.out.println(compare);
                for (int k = 0; k < cal2.size(); k++) {
                    if (cal2.get(k).toString().equals(compare)) {
                        if (compare.equals("*")) {
                            sum = num2.get(k) * num2.get(k + 1);
                        } else if (compare.equals("+")) {
                            sum = num2.get(k) + num2.get(k + 1);
                        } else if (compare.equals("-")) {
                            sum = num2.get(k) - num2.get(k + 1);
                        }
                        num2.remove(k + 1);
                        num2.remove(k);
                        num2.add(k, sum);
                        cal2.remove(k);
                        System.out.println("beforekk:"+k);
                        k--;
                        System.out.println("afterk:"+k);
                    }
                }
            }
            max = Math.max(max, Math.abs(sum));

        }

    }
}
//import java.util.*;
//class Solution {
//    public long solution(String expression) {
//        System.out.println(expression);
//        String[] loop = {"*+-","*-+","+*-","+-*","-+*","-*+"};
//        String regExp = "\\D+";
//        String regExp2 = "[0-9]+";
//        LinkedList<Long> num = new LinkedList<>();
//        LinkedList<String> cal = new LinkedList<>();
//        LinkedList<Long> num2 = new LinkedList<>();
//        LinkedList<String> cal2 = new LinkedList<>();
//        //연산식이 한개일때 케이스두면 시간 줄여짐
//        for(int i = 0; i<expression.split(regExp).length ;i++){
//            num.add(Long.parseLong(expression.split(regExp)[i]));
//        }
//        for(int j = 0 ; j<expression.split(regExp2).length;j++){
//            if(!expression.split(regExp2)[j].equals("")){
//                cal.add(expression.split(regExp2)[j]);
//            }
//        }
//        long sum = 0;
//        long max = 0;
//        for(int a = 0 ; a<loop.length;a++){
//            num2=(LinkedList) num.clone();
//            cal2=(LinkedList) cal.clone();
//            for(int i = 0 ; i<loop[a].length();i++ ){
//                String compare= loop[a].charAt(i)+"";
//                for(int k = 0 ; k<cal2.size();k++){
//                    if(cal2.get(k).toString().equals(compare+"")){
//                        if(compare.equals("*")){
//                            sum = num2.get(k)*num2.get(k+1);
//                        }else if(compare.equals("+")){
//                            sum = num2.get(k)+num2.get(k+1);
//                        }else if(compare.equals("-")){
//                            sum = num2.get(k)-num2.get(k+1);
//                        }
//
//                        num2.remove(k+1);
//                        num2.remove(k);
//                        cal2.remove(k);
//                        num2.add(k,sum);
//
//                        k--;
//                    }
//                }
//            }
//            max= Math.max(max,Math.abs(sum));
//
//        }
//
//        return max;
//    }
//}