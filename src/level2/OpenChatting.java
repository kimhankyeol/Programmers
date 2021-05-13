package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {
    static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<>();
        List<String> hList = new ArrayList<>();
        String[] recs;
        for(int i=0 ; i<record.length; i++){
            recs = record[i].split(" ");
            if(recs[0].equals("Enter") || recs[0].equals("Change")){
                hMap.put(recs[1],recs[2]);
            }
        }

        for(int i=0 ; i<record.length; i++){
            recs = record[i].split(" ");
            if(recs[0].equals("Enter") ){
                hList.add(hMap.get(recs[1])+"님이 들어왔습니다.");
            }else if(recs[0].equals("Leave")){
                hList.add(hMap.get(recs[1])+"님이 나갔습니다.");
            }
        }
    }
}
