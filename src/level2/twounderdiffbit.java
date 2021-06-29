package level2;

public class twounderdiffbit {
    public static void main(String[] args) {
        long[] number ={85} ;
        long[] res = new long[number.length];
        System.out.println(Long.toBinaryString(157));
        //규칙 마지막 찾은 01 을 10 으로 바꿔주면됨
        for(int i = 0 ; i<number.length;i++){
            long l1 =((number[i]^(number[i]+1))>>2)+number[i]+1;
            System.out.println(l1);
//            if(Long.toBinaryString(number[i]).charAt(Long.toBinaryString(number[i]).length()-1)=='0'){
//                res[i]=(number[i]+1);
//            }else{
//                res[i]=Long.valueOf(rep(Long.toBinaryString(number[i]).toString()), 2);
//            }
        }
        for(int j = 0 ; j<number.length ;j++){
            System.out.print(res[j]+",");
        }
    }
    private static String rep(String s){
        if(s.indexOf("01")==-1){
            s="0"+s;
            System.out.println("after:"+s);
        }
        return replaceLast(s,"01","10");
    }
    public static String replaceLast(String str, String regex, String replacement) {
        int regexIndexOf = str.lastIndexOf(regex);
        if(regexIndexOf == -1){
            return str;
        }else{
            return str.substring(0, regexIndexOf) + replacement + str.substring(regexIndexOf + regex.length());
        }
    }


//    private static long compare(long before,long number ){
//
//        int count =Long.bitCount(before^(number+1));
//        if(count<=2){
//            return number+1;
//        }else {
//            return compare(before,number+1);
//        }
//    }
//    public static void main(String[] args) {
//        long[] number = {7};
//        for(int i =0 ; i<result(number).length;i++){
//            System.out.println(result(number)[i]);
//        }
//    }
//    static long[] result(long[] number){
//        long[] res = new long[number.length];
//        for(int i = 0 ; i<number.length ; i++){
//            res[i]=compare(number[i],number[i]);
//        }
//        return res;
//    }
//    static String longToBinary(long x){
//        String str = Long.toBinaryString(x);
//        return str;
//    }
//    //길이 안맞으면 맞춰줘야됨 인덱스 문제
//    static String compLengthMatch(String binStr,String compBinStr){
//        if(binStr.length()!=compBinStr.length()){
//            binStr= new String(new char[compBinStr.length()-binStr.length()]).replace("\0", "0")+binStr;
//        }
//        return binStr;
//    }
//    //기준과 증가하는값 비교
//    static long compare(long beforeX ,long x){
//        int count=0;
//        String binStr = longToBinary(beforeX);
//        x=x+1;
//        String compBinStr = longToBinary(x);
//        binStr=compLengthMatch(binStr,compBinStr);
//        if(binStr.lastIndexOf("0")==-1){
//            return x;
//        }
//        for(int i = binStr.length()-1; i>=0; i--){
//            if(binStr.charAt(i) != compBinStr.charAt(i)){
//                count++;
//            }
//            if(count>2){
//                return compare(beforeX,x);
//            }
//        }
////        if(compBinStr.length()>4 && compBinStr.charAt(compBinStr.length()-1)=='1' && compBinStr.charAt(compBinStr.length()-2)=='1'){
////            char[] compBinstrArr = compBinStr.toCharArray();
////            compBinstrArr[compBinStr.length()-3] = '1';
////            compBinstrArr[compBinStr.length()-2] = '1';
////            compBinstrArr[compBinStr.length()-1] = '1';
////            String compBinStr = String.valueOf(compBinstrArr);
////            System.out.println(compBinStr);
////            System.out.println("결과:"+Integer.parseInt(compBinStr, 2));
////            return Integer.parseInt(compBinStr, 2);
////        }else if(compBinStr.length()>4 && (compBinStr.charAt(compBinStr.length()-1)!='1' || compBinStr.charAt(compBinStr.length()-2)!='1')){
////            System.out.println("타냐");
////            return compare(beforeX,x);
////
////        }else{
////
////        }
//        return x;
//    }
}
