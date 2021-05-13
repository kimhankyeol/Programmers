package level1;

import java.util.Arrays;

/*
이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
*/
public class KeypadTouch {
    //10 * 12 #
    static int[][] keypad = {{1,2,3},{4,5,6},{7,8,9},{10,0,12}};
    static int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    static String hand = "left";
    //왼손 시작위치
    static int leftHandX = 3;
    static int leftHandY = 0;
    //오른손 시작위치
    static int rightHandX = 3;
    static int rightHandY = 2;

    public static void main(String[] args) {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                System.out.print(keypad[i][j] + "\t"); // 열 출력
                System.out.print("("+i+","+j+")"+ "\t");
            }
            System.out.println(); // 행 출력
        }
        String result = "";
        for(int k : numbers){
            for (int i = 0; i < keypad.length; i++) {
                for (int j = 0; j < keypad[i].length; j++) {
                    if(k==keypad[i][j]){
                        //숫자면 최근눌렀던 L과 R의 좌표를 찾는다.
                        //그후 거리계산 거리 같으면 왼손잡이 오른손잡이
                        result += leftRightMove(k,i,j);

                    }
                }
            }
            System.out.println(); // 행 출력
        }
        System.out.println(result);
    }
    //왼손 1 4 7 10   오른손 3 6 9 12
    public static String leftRightMove(int num,int x,int y){
        if(num == 1 || num == 4 || num == 7 || num == 10){
            leftHandX = x;
            leftHandY = y;
            return "L";
        } else if(num == 3 || num ==6 || num==9 || num == 12) {
            rightHandX = x;
            rightHandY = y;
            return "R";
        }
        return CalRoute(num,x,y);

    }
    public static String CalRoute(int num , int x ,int y){

        //왼손 오른손 경로 길이 직선 거리 두점사이의 거리 아님
        double leftRoute =  Math.abs(leftHandX  - x ) + Math.abs(leftHandY - y );
        double rightRoute =  Math.abs(rightHandX  - x ) + Math.abs(rightHandY - y );
        System.out.println("현재 leftx :"+leftHandX + ", 현재 lefty:"+leftHandY);
        System.out.println("현재 rightx :"+rightHandX + ", 현재 righty:"+rightHandY);
        System.out.println("눌린 숫자 : "+num+" , x:"+x+",y:"+y+", left:"+leftRoute+", right:"+rightRoute);

        if(leftRoute == rightRoute){
            if(hand == "right"){
                rightHandX = x;
                rightHandY = y;
                return "R";
            }
        }else if (leftRoute>rightRoute){
            rightHandX = x;
            rightHandY = y;
            return "R";
        }
        leftHandX=x;
        leftHandY=y;
        return "L";
    }
}
//LRLLRLLLRRL