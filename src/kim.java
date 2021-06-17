import java.util.LinkedList;
import java.util.Queue;

public class kim {
    public static String p ="";
    public static String s="";
    public static void main(String[] args) {
        int answer = 0;
        Queue<String> sQueue = new LinkedList<>();
        Queue<String> pQueue = new LinkedList<>();
        for(int i = 0; i < p.length(); i++) {
            sQueue.offer(String.valueOf(s.charAt(i)));
        }
        String [] sArr = s.substring(p.length(), s.length()).split("");
        int deleteNum = 0;
        String [] pArray = p.split("");
        for(int i=0; i<p.length(); i++) {
            pQueue.offer(pArray[i]);
        }
        for(int i=0; i<sArr.length; i++) {
            if(sQueue.equals(pQueue)) {
                sQueue.clear();
                if(sQueue.size()!=p.length()) {
                    sQueue.add(sArr[i]);
                } else {
                    sQueue.add(sArr[i]);
                    sQueue.remove();
                    deleteNum++;
                }
            } else {
                if(sQueue.size()!=p.length()) {
                    sQueue.add(sArr[i]);
                } else {
                    sQueue.add(sArr[i]);
                    sQueue.remove();
                    deleteNum++;
                }
            }
            if(i==sArr.length-1) {
                System.out.println("hi");
                if(!sQueue.equals(pQueue)) {
                    deleteNum += sQueue.size();
                }
            }
        }
        if(deleteNum==s.length()) {
            deleteNum = -1;
        }
    }
}
