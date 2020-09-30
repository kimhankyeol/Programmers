package level1;

import java.util.*;
public class DislikeSameNum {
    public static void main(String[] args) {
        int[] arr={1,1,3,3,0,1,1};
        DislikeSameNum ds = new DislikeSameNum();
        int[] res = ds.solution(arr);
        System.out.println(res);
    }
    //Run-Length 알고리즘이랑 비슷할수도
    public  int[] solution(int[] arr) {
        List<Integer> rList = new ArrayList();
        for(int i = 0 ; i<arr.length ; i++){
            if(i==0){
                rList.add(arr[i]);
            }else{
                if(arr[i-1]!=arr[i]){
                    rList.add(arr[i]);
                }
            }
        }
        int[] answer = rList.stream().mapToInt(i->i).toArray();
        return answer;
    }
    //     //형변환 해도 상관없으면  List<Integer> 형변환 해야되면
// 	public   List<Integer> solution(int []arr) {
//         List<Integer> rList = new ArrayList();
//        for(int i = 0 ; i<arr.length ; i++){
//            if(i==0){
//                rList.add(arr[i]);
//            }else{
//                if(arr[i-1]!=arr[i]){
//                     rList.add(arr[i]);
//                }
//            }
//        }
//         return rList;


    }
