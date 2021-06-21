package level2;

import java.util.HashMap;
//코딜리티
public class test {
    static String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
    static String C = "Example";

    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<>();
        String s = "";
        for(String s1 : spiltStr(S,";")){
//            System.out.println(createEmail(spiltStr(s1.trim()," "),C,hMap));
            s +=createEmail(spiltStr(s1.trim()," "),C,hMap)+"; ";
        }
        System.out.println(s.substring(0,s.length()-2));
    }
    private static String[] spiltStr(String str,String spl){
        return str.split(spl);
    }
    private static String dashContain(String s){
       if(s.contains("-")){
           String[] spl = s.split("-");
           return  spl[0]+(spl[spl.length-1].substring(0,2));
       }
       return s;
    }
    private static  String createEmail(String[] nameArr,String c ,HashMap<String,String> hMap){
        String first = nameArr[0];
        String last =  dashContain(nameArr[nameArr.length-1]);
        String nameEmail =first+"."+last;
        if(hMap.containsKey(nameEmail)){
            int count = hMap.get(nameEmail).equals("") ? 1 : Integer.parseInt(hMap.get(nameEmail));
            hMap.put(nameEmail,String.valueOf(count+1));
            return (nameEmail+hMap.get(nameEmail)+"@"+c+".com").toLowerCase();
        }else{
            hMap.put(nameEmail,"");
        }

        return (nameEmail+hMap.get(nameEmail)+"@"+c+".com").toLowerCase();
    }

}
