package level1;
//1S2D*3T
public class Dart {
    static String dartResult = "1D2S#10S";
    public static void main(String[] args) {
        int answer = 0;
        int [] pt = new int[3];
        int idx = 0;

        String temp = "";

        for(int i=0 ; i<dartResult.length() ; i++) {
            char c = dartResult.charAt(i);

            if(c >= '0' && c <= '9') {
                temp += String.valueOf(c);
            } else if(c == 'S' || c == 'D'|| c == 'T'){
                // 각 숫자별로 합산
                int p = (int) Math.pow(Integer.parseInt(temp), c == 'S' ? 1: (c == 'D' ? 2: 3));
                pt[idx++] = p;
                temp = "";
            } else {
                if(c == '#') {
                    //전에것만 -
                    pt[idx-1] *= -1;
                } else {
                    //3개까지니  -1 ,-2
                    pt[idx-1] *= 2;
                    if(idx-2 >= 0) pt[idx-2] *= 2;
                }
            }

        }

        for(int val : pt) {
            answer += val;
        }
        System.out.println(answer);

    }

}