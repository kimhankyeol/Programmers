package level2;

public class TargetNumber {
    static int[] numbers ={1,1,1,1,1};
    static int target = 3;
    public static void main(String[] args) {
        int result =0;
        //1. 처음 시작도  + -
        int current = numbers[0];
        //+ 시작 ,- 시작
        result += dfs(current,1,numbers,target);
        result += dfs(-current,1,numbers,target);
        System.out.println(result);

    }

    public static int dfs(int prev, int index ,int[] numbers, int target){
        //재귀 타면 종료조건 줘야됨
        if (index >= numbers.length) {
            //prev 합산된게 타겟 3이랑 같으면
            if (target == prev) {
                return 1;
            }
            return 0;
        }

        int result =0;
        //curplus
        int curPlus = prev+numbers[index];
        //curminus
        int curMinus = prev-numbers[index];
        result += dfs(curPlus,index+1,numbers,target);
        result += dfs(curMinus,index+1,numbers,target);
        return result;
    }
}
