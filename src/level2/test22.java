package level2;

import java.util.*;
//코딜리티 
// 2개의 연속된숫자없이 숫자를 증가시켜서 최소숫자 나오도록
public class test22 {

    public static void main(String[] args) {
        String p = "44432";
        System.out.println(w(p));
    }
    public static String w(String p1){
        for(int i = 0; i<p1.length()-1; i++){
            if(p1.charAt(i)==p1.charAt(i+1)){
                p1 = String.valueOf(Integer.parseInt(p1)+1);
                return w(p1);
            }
        }
        return p1;
    }
}
