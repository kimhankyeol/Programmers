package level2;

import java.util.*;

public class Teest {

    static String p = "101";
    static String s ="10100010101101100";

    public static void main(String[] args) {
        String res = "";
        Queue<Character> q2 = new LinkedList<>();
        int count = 0, k = 0 ;
        for(char c : s.toCharArray()){
            q2.add(c);
        }
        while(!q2.isEmpty()){
            if(p.charAt(k)==q2.peek()){
                res += q2.peek();
                if(res.equals(p)){
                    res="";
                    count++;
                    k=0;
                }else{
                    k++;
                }
            }
            q2.poll();
        }
        System.out.println(s.length()-(count*p.length()));

    }
}
