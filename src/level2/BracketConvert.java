package level2;

import java.util.LinkedList;
import java.util.Queue;

public class BracketConvert {
    public static void main(String[] args) {
        String p = "()))((()";
        String kim =  recurChange(p);
        System.out.println(kim);
    }
    public static String recurChange(String p1){
        if(p1.equals("")){
            return "";
        }
        int index = splitString(p1);
        String u  = p1.substring(0,index);
        String v  = p1.substring(index);
        System.out.println("u:"+u);

        System.out.println("V:"+v);
        if(right(u)){
            return u+recurChange(v);
        }

        StringBuffer temp = new StringBuffer();
        temp.append("(");
        temp.append(recurChange(v));
        temp.append(")");
        u=u.substring(1,u.length()-1);
        for(int i = 0; i<u.length();i++){
            if(u.charAt(i) =='('){
                temp.append(')');

            } else{
                temp.append('(');
            }
        }
        return temp.toString();
    }
    //u, v 나누기
    public static int splitString(String p2){
        int sum = 0;  //"( ) 합 0 되는순간 균형잡힌"
        int index = 0;
        for(int i = 0 ; i<p2.length();i++){
            index++;
            if(p2.charAt(i) == '('){
                sum--;
            }else{
                sum++;
            }
            if(sum == 0 )
                break;
        }
        return index;
    }
    public static boolean right(String s){
        int sum = 0 ;
        for(int i = 0 ;i<s.length();i++){
            if(s.charAt(i)=='('){
                sum++;
            }else{
                sum--;
            }
            if(sum<0){
                return false;
            }
        }
        return true;
    }
//    public static void convert(Queue q){
//
//    }
}
