package level1;

public class StringCompress {
    static int[][] a ={{1,2,3},{4,5,6},{7,8,9}};

    public static void main(String[] args) {

//        int count = 0;
//        for(int i = 0 ; i<a.length ;i++){
//            for(int j = 0; j<a[i].length;j++){
//                if(a[i][j]>4){
//                    System.out.println(a[i][j]);
//                    count++;
//                    break;
//                }
//            }
//            if(count>0){
//                break;
//            }
//        }
        String s = "aabbaccc";

        //반복할개수 for문
        int min =0;
        //문자열이 8개면 최대 반복할 문자열 4개 까지
        for(int i = 1; i<=s.length()/2; i++){
            String prev = "";
            String next  ="";
            String sum = "";

            //숫자 카운트
            int count = 1;
            for(int j = 0 ;j<=s.length()/i ; j++){
                int st = j*i;
                //i는 몇개씩 자르는지
                //끝 길이가 길이를 넘으면
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                //substring  (0,2) 0<= x <2 0,1
                    prev = next;
                    next = s.substring(st,end);
                    //이전 값과 같으면 카운트 하고 다르면
                    if(prev.equals(next)){
                        count++;
                    }else{
                        //다르면
                        String c="";
                        if(count >1){
                            c= String.valueOf(count);
                        }
                        sum += c+prev;
                        count=1;
                    }
            }
            String c="";
            if(count >1){
                c= String.valueOf(count);
            }
            sum += c+next;
            if(min == 0){
                min = sum.length();
            }else if(min!=0){
                if(min >= sum.length()){
                    min=sum.length();
                }
            }





//            int loop = i+1;
//            int count = 1;
//            String temp="";
//            temp = s.substring(i,i+loop);
//            for(int j = 0 ; j <s.length() /loop ; j++){
//                System.out.println("i번쨰:"+i+",j번째:"+j);
//                if(j+loop<s.length()){
//
//                    if(s.substring(i,i+loop).equals(s.substring(j,j+loop))){
//                        count++;
//                        sum += count+temp;
//                    }else{
//                        count =1;
//                        sum +=temp;
//                    }
////                    System.out.println("비교:"+s.substring(i,i+loop).equals(s.substring(j,j+loop)));
////                    System.out.println(s.substring(j,j+loop));
//                }else{
//                    temp = s.substring(i,i+loop);
//                    if(s.substring(i,i+loop).equals(s.substring(j,s.length()))){
//                        count++;
//                        sum += count+temp;
//                    }else{
//                        count =1;
//                        sum +=temp;
//                    }
////                    System.out.println("비교:"+s.substring(i,i+loop).equals(s.substring(j,s.length())));
////                    System.out.println(s.substring(j,s.length()));
//                }
//
//            }

        }
        System.out.println(min);
    }
}
