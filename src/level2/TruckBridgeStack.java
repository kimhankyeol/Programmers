package level2;
//velog님 의 블로그를 참고하여 공부하였습니다.
import java.util.*;
public class TruckBridgeStack {
    public static void main(String[] args) {
        TruckBridgeStack t = new TruckBridgeStack();
        int[] truck_weights={7,4,5,6};
        System.out.println(t.TruckBridgeStack(2,10,truck_weights));
    }
    class Truck {
        int weight;
        int entry;

        Truck(int weight, int entry){
            this.weight = weight;
            this.entry = entry;
        }
    }
    public int TruckBridgeStack(int bridge_length, int weight, int[] truck_weights) {
        //대기중인 트럭을 큐로
        Queue<Truck> waiting = new LinkedList<>();
        //다리로 이동중인 트럭을 큐로
        Queue<Truck> bridge = new LinkedList<>();
        //정수형 배열을 큐로
        for(int i = 0 ; i < truck_weights.length ; ++i){
            waiting.offer(new Truck(truck_weights[i], 0));
        }
        //총 시간을 계산하기위한 변수
        int time = 0;
        int totalWeight = 0;
        //대기열과 다리 안에 있는 트럭이 없어져야함 비어있지 않을떄 까지 돌림
//peek 은 큐의 맨앞에 데이터가 무엇인지 poll 큐의 맨앞에 데이터를 꺼내옴
        while(!waiting.isEmpty() || !bridge.isEmpty()){
            time++;
            if(!bridge.isEmpty()) {
                Truck t = bridge.peek();
                if(time - t.entry >= bridge_length) {
                    totalWeight -= t.weight;
                    bridge.poll();
                }
            }

            if(!waiting.isEmpty()) {
                if(totalWeight + waiting.peek().weight <= weight) {
                    Truck t = waiting.poll();
                    totalWeight += t.weight;

                    bridge.offer(new Truck(t.weight, time));
                }
            }
        }
        return time;
    }
}
