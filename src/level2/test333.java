package level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test333 {
    public static void main(String[] args) {
        Queue<String> q =  new LinkedList<>();

        String[] s =  {"INT","INT","BOOL","SHORT","LONG"};
        HashMap<String,Integer> hMap = new HashMap<>();
        hMap.put("BOOL",1);
        hMap.put("SHORT",2);
        hMap.put("FLOAT",4);
        hMap.put("INT",8);
        hMap.put("LONG",16);
//        Length len = new Length(1,2,4,8,16);

        //길이 체크 128;
        int lenCount = 0;
        String res = "";
        for(int i=0;i<s.length;i++){
            q.add(s[i]);
            lenCount+=hMap.get(s[i]);
            if(lenCount>128){
                System.out.println("Halt");
                break;
            }
        }
        add(q);
    }

    static String add(Queue q){

        String prev= "";
        String res = "";
        int count =0;
//                res+=new String(new char[1]).replace("\0", "#")+(count<=8 ? "":",");
        String r = "........";
        while(!q.isEmpty()){

           String s = q.poll().toString();
            if(s.equals("BOOL")){
                count += 1;
                res+=new String(new char[1]).replace("\0", "#")+(count<=8 ? "":",");
                if(count>=8){
                    count=0;
                }


            }else if(s.equals("SHORT")){
                count +=2;
                if(count>=8){
                    count=0;
                }
                if(prev.equals("BOOL")){

                }

            }else if(s.equals("FLOAT")){
                count +=4;
                if(count>=8){
                    count=0;
                }
            }else if(s.equals("INT")){
                count +=8;
                if(count>=8){
                    res+=new String(new char[8]).replace("\0", "#");
                    res+=",";
                }

//                res+=new String(new char[8]).replace("\0", "#")+",";
            }else if(s.equals("LONG")){
                count +=16;
                if(count>=8){
                    count=0;
                    res+=",";
                }
                res+=new String(new char[8]).replace("\0", "#")+",";
                res+=new String(new char[8]).replace("\0", "#")+",";

            }
            prev = s;
        }
        System.out.println(res);
        return res;

    }
}
