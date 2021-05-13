package level1;

public class SecretMap {
    static int n = 5;
    static int[] arr1 = {9, 20, 28, 18, 11};
    static int[] arr2 = {30, 1, 21, 17, 28};
    static String[] answer = new String[n];
    public static void main(String[] args) {

        for(int i = 0 ; i < arr1.length ; i++){
            String res ="";
            for(int j =0; j<n; j++){
                if (Integer.parseInt(binaryChg(arr1[i]).charAt(j)+"")+Integer.parseInt(binaryChg(arr2[i]).charAt(j)+"") == 0) {
                    res +=" ";
                }else{
                    res +="#";
                }
            }
            answer[i]=res;
        }
        System.out.println(answer);
        for(int i = 0 ; i<answer.length;i++){
            System.out.println(answer[i]);
        }
        //11버전 repeat 이 있음
    }
    //10진수 -> 2진수 변환
    static String binaryChg(int i){
        StringBuffer sb = new StringBuffer();
        String s = "";
        while(i>0){
            s += i%2;
            i=i/2;
        }
        sb.append(s);
        return new String(new char[n-s.length()]).replace("\0", "0")+sb.reverse().toString();
    }
}
