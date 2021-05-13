package level1;

import java.util.*;
class DivideNumArray {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> rList = new ArrayList<>();
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i]%divisor==0){
                rList.add(arr[i]);
            }
        }
        
        if(rList.size()==0){
            rList.add(-1);
        }
   
       int[] answer = rList.stream().mapToInt(i->i).toArray();
       Arrays.sort(answer);
        return answer;
    }
}
