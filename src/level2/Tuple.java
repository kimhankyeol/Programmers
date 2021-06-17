package level2;


import java.util.*;
import java.util.stream.Collectors;

public class Tuple {
    static String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
    public static void main(String[] args) {
        //중괄호 제거 middleOpClRemove
        //중복값 제거 overlapNumber
        //카운트 세야됨 중복값 제거 하면서
        //set<> to int[]
//        setToIntArray();
        listKeySetConverter(overlapNumber(middleOpClRemove(s)));
    }
    static String middleOpClRemove(String s1){
        return s1.replaceAll("[{^d}]", "");
    }
    static List<Map.Entry<String, Integer>>  overlapNumber(String s1){
        String[] arrS1 = s1.split(",");
        HashMap<String,Integer> hMap = new HashMap<>();
        for(int i = 0 ; i< arrS1.length; i++){
            if (hMap.containsKey(arrS1[i])) {
                hMap.put(arrS1[i], hMap.get(arrS1[i])  + 1);
            } else {
                hMap.put(arrS1[i] , 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hMap.entrySet());
        list.sort(Map.Entry.<String,Integer>comparingByValue().reversed());
        return list;
    }
    static int[] listKeySetConverter(List<Map.Entry<String, Integer>> list){
        int[] res = new int[list.size()];
        for(int i = 0 ; i<list.size(); i++){
            res[i] = Integer.parseInt(list.get(i).getKey());
        }
        return res;
    }
}
