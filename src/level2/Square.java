package level2;


public class Square {
    public long solution(int w, int h) {
        long w1 = Long.parseLong(String.valueOf(w));
        long h1 = Long.parseLong(String.valueOf(h));

        return (w1*h1) - ( w1+h1-maxg(w1,h1));
    }

    private static long maxg( long w , long h ) {

        long small,big ;
        // 제일 큰수로 작은수를 나누어 최대 공약수를 구하기 위해
        big = w >= h ? w : h ;
        small = w < h ? w : h ;

        while ( small != 0 ) {
            long nmg = big % small ;
            big = small;
            small = nmg;
        }
        return big;
    }
}