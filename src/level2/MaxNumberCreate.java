package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxNumberCreate {
    static String number = "1924";
    static int k = 2;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        System.out.println(sb.toString());
    }
}
