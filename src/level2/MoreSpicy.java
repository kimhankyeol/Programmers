package level2;

import java.util.Iterator;
import java.util.PriorityQueue;

/*
scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
*/
public class MoreSpicy {
    static int[] a={10, 10, 10, 10, 10};
    static int k = 1000;
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0 ; i < a.length ;i++){
            p.add(a[i]);
        }
        System.out.println(p);
        int count = 0;
        //if(p.size()>=2){
        while(p.peek()<=k){
            if(p.size()>=2){
                int first = p.poll();
                int second = p.poll();
                System.out.println("first:"+first);
                System.out.println("second:"+second);

                int newScoville = first+(second*2);
                System.out.println("newSco:"+newScoville);
                p.add(newScoville);
                count++;
            }else{
                break;
            }
        }
        
        System.out.println(p.peek());
        System.out.println(count);
    }
}
