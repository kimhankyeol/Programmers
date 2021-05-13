package level1;
//서로 다른 숫자 3개 의 합이 소수인지 // 몇개
public class ThreeSumDecimal {
    static private int[] arr = {1,2,3,4};
    static private int result = 0;

    public static void main(String[] args) {
        for (int i = 0 ; i<arr.length-2;i++){
            for (int j = i+1 ; j<arr.length-1;j++){
                for(int k = j+1 ; k<arr.length;k++){
//                    System.out.println("i:"+arr[i]);
//                    System.out.println("j:"+arr[j]);
//                    System.out.println("k:"+arr[k]);
                    prime(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        System.out.println(result);
    }
    public static void prime(int sum){
        int i = 2;
        while (i*i<=sum){
            if(sum%i == 0){
                //소수아님
                return;
            }
            i+=1;
        }
        //소수
        result++;
    }

}
