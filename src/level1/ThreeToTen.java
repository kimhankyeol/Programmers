package level1;

public class ThreeToTen {
    public static void main(String[] args) {
        int k = 45;
        int n =1;
        int sum = 0;
        String s = "";
        while(k>0) {
            s+=k%3;
            k/=3;
        }
        for(int i=s.length()-1; i>=0 ; i-- ){
           sum += Integer.parseInt(s.charAt(i)+"")*n;
           n*=3;
        }
        System.out.println(sum);
    }

}
