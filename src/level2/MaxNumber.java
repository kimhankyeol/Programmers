package level2;

import java.util.Arrays;

public class MaxNumber{
    static int[] numbers = {3,30,34,5,9,2};
    public static void main(String[] args) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);
        //arr 배열 안에서 문자열 비교를함  문자열 합친거 끼리 쌍방비교
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        /*if(arr[0].equals("0")) return "0";*/

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            sb.append(arr[i]);
        }
//            sb.append(arr[i]);
        System.out.println(sb);
    }
}
//가장 큰수
//public class MaxNumber {
//    static int[] numbers = {6,10,2};
//    //numbers의 원소는 0<= <=1000
//    public static void main(String[] args) {
//        int temp = 0;
//        int zeroCount =0;
//        String result = "";
//        for(int i =0 ; i<numbers.length;i++){
//            //0 개수 세기 0,0,0,0,90
//            if(numbers[i]==0){
//                zeroCount++;
//            }
//            System.out.println(i+"번쨰");
//            //비교 연산
//            if(i==0){
//                temp = compareNumber(stringConvertSum(numbers[i],numbers[i+1]),stringConvertSum(numbers[i+1],numbers[i]));
//            }else if(numbers.length-1>i){
//                System.out.println("템프:"+temp+", 카운트:"+String.valueOf(temp).length());
//                if(String.valueOf(temp).length()>1){
//                    for(int j = 0; j< String.valueOf(temp).length();j++){
//                        int num = Integer.parseInt(String.valueOf(temp).charAt(j)+"");
//                        if(num<Integer.parseInt(String.valueOf(numbers[i]).charAt(0)+"")){
//
//                        }
//                        System.out.println("자릿수 :"+num);
//                        System.out.println("글자:"+String.valueOf(temp).charAt(j));
//                    }
//                }
//
//                temp = compareNumber( stringConvertSum(temp,numbers[i+1]), stringConvertSum(numbers[i+1],temp));
//            }
//        }
//        if(zeroCount>0){
//            result=temp+new String(new char[zeroCount-1]).replace("\0", "0");
//            System.out.println(result);
//        }
//        System.out.println(temp);
//    }
//    private static int stringConvertSum(int i1, int i2){
//        return Integer.parseInt(String.valueOf(i1)+String.valueOf(i2));
//    }
//    private static int compareNumber(int i1, int i2){
//        if(Integer.compare(i1,i2)>=0){
//            return i1;
//        }
//        return i2;
//    }
//
//}
