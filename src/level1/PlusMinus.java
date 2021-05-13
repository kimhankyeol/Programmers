package level1;

public class PlusMinus {

    public static void main(String[] args) {
        int answer=0;
        int[] absolutes={};
        boolean[] signs={};
        for(int i = 0 ; i < absolutes.length ;i++){
            if(signs[i])
                answer += absolutes[i];
            else
                answer += -1 * absolutes[i];
        }
    }
}
