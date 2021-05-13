package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelop {

    static int[] progresses = {93,30,55};
    static int[] speed ={1,30,5};
    public static void main(String[] args) {
        Queue<Func> q = new LinkedList<>();
        List<Integer> res  = new ArrayList<>();
        // 1번 , 2번 ,3번
        // progress
        //speed
        // day
        //각 기능이 몇일 걸리는지 계산
        //잔여 =100 - 진행
        //실행일수(완료) = 잔여 / 스피드
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int compDay = remain/speed[i];
            //잔여 나머지 0초과면 +1
            int m = remain%speed[i];
            if(m>0){
                compDay++;
            }
            //첫작업끝날시 큐가 비어있음
            if(q.isEmpty()){
                q.add(new Func(compDay,1));
            }else{
                //else 부터는 2번쨰 작업 완료일 비교함
                if(q.peek().compDay>=compDay){
                    q.peek().cnt += 1;
                }else{
                    //지금까지 계산한 카운트 미리넣고 새로운 cnt
                    res.add(q.poll().cnt);
                    q.add(new Func(compDay,1));
                }
            }
//            System.out.println("잔여일:"+remain+", 실행일수:"+compDay+", 잔여 나머지:"+m);
        }
        //마지막값
        if(!q.isEmpty()){
            res.add(q.poll().cnt);
        }

        System.out.println(res);
        Integer[] answer = res.toArray(new Integer[res.size()]);


    }

    static class Func {
         int compDay;
         int cnt;

        public Func(int compDay, int cnt){
            this.compDay = compDay;
            this.cnt = cnt;
        }
    }

}
