package level2;

public class MaxMin {
    static String s = "-1 2 -3 4";
    public static void main(String[] args) {
        String[] sArr = s.split(" ");
        int max =Integer.parseInt(sArr[0]);
        int min =Integer.parseInt(sArr[0]);
        for(int i = 1 ; i<sArr.length ;i++){
            max = Math.max(max,Integer.parseInt(sArr[i]));
            min = Math.min(min,Integer.parseInt(sArr[i]));
        }
        System.out.println(  min + " " + max);
    }
}
