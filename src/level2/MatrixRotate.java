package level2;
//이건 참고했으니 다른것으로 올림
public class MatrixRotate {
    static int rows = 6;
    static int columns = 6;

    static int[][] matrix = new int[rows+1][columns+1];
    static int min;
    static int[][] queries = 	{{2,2,5,4},{3,3,6,6},{5,1,6,3}};
    static int[] answer = new int[queries.length];
    public static void main(String[] args) {
        int count = 1;
        for(int i = 1; i<=rows; i++){
            for(int j =1 ; j<=columns;j++){
                matrix[i][j]= count++;
            }
        }
        for(int i = 0 ; i<queries.length;i++){
            //우측 , 아래 , 좌측 , 위 돌떄 마다 최솟값 받아서 list 에 저장
            answer[i]=rotate(queries[i]);
            System.out.println( answer[i]);
        }

    }
    public static int rotate(int[] queries){
        int startX = queries[0];
        int startY = queries[1];
        int currentTarget = matrix[startX][startY];
        //x만큼 이동(아래)
        int xm = queries[2]-queries[0];
        //y만큼 이동(우측)
        int ym = queries[3]-queries[1];

        // 현재값을 최소값으로 초기화
        min = currentTarget;

        // 오른쪽
        for(int i = 0; i < ym; i++) {
            startY += 1;
            currentTarget = move(startX, startY, currentTarget);
        }

        // 아래
        for(int i = 0; i < xm; i++) {
            startX += 1;
            currentTarget = move(startX, startY, currentTarget);
        }

        // 왼쪽
        for(int i = 0; i < ym; i++) {
            startY -= 1;
            currentTarget = move(startX, startY, currentTarget);
        }

        // 위쪽
        for(int i = 0; i < xm; i++) {
            startX -= 1;
            currentTarget = move(startX, startY, currentTarget);
        }
        return min;

    }
    //이동후 최솟값반환환
    public static int move(int x , int y ,int before){
        // 이동한 지점의 값을 temp 에 임시 저장
        int temp = matrix[x][y];

        // 최소값 초기화
        min = Math.min(min, temp);

        // 이동한 지점의 값을 이전 지점의 값으로 초기화
        matrix[x][y] = before;

        return temp;
    }
}


//        int temp = 0;
//        for(int i = 0 ; i<queries.length;i++){
//            //1.x축 변경
//            for(int j = queries[i][1]; j<=queries[i][3] ; j++ ){
//                if(j==queries[i][3]){
//                    temp = matrix[queries[i][1]][j];
//                }else{
//                    newmatrix[queries[i][1]][j+1]=matrix[queries[i][1]][j];
//                }
//            }
//
//            //2.y축 변경
//            for(int j = queries[i][0]; j<=queries[i][2] ; j++ ){
//                System.out.println("x:"+j+",y:"+queries[i][1]);
//                if(j==queries[i][0]){
//                    newmatrix[j+1][queries[i][2]-1] = temp;
//                }else if(j==queries[i][2]){
//                    temp= matrix[j][queries[i][2]-1];
//                } else{
//                    newmatrix[j+1][queries[i][2]-1]=matrix[j][queries[i][2]-1];
//                }
//            }
//        }
//
//        System.out.println("temp:"+temp);
//        for(int i = 1; i<=rows; i++){
//            for(int j =1 ; j<=columns;j++){
//                System.out.print(matrix[i][j]+"      ");
//            }
//            System.out.println();
//        }
//        for(int i = 0; i<rows; i++){
//            for(int j =0 ; j<columns;j++){
//                System.out.print(newmatrix[i][j]+"      ");
//            }
//            System.out.println();
//        }
//        System.out.println("-------------------");
//        System.out.println(matrix[2][2]);
//        System.out.println(matrix[2][3]);
//        System.out.println(matrix[2][4]);
//
//        System.out.println("-------------------");
//
//        System.out.println(matrix[2][2]);
//        System.out.println(matrix[3][2]);
//        System.out.println(matrix[4][2]);
//        System.out.println(matrix[5][2]);
//
//
//        System.out.println("-------------------");
//        System.out.println(matrix[2][4]);
//        System.out.println(matrix[3][4]);
//        System.out.println(matrix[4][4]);
//        System.out.println(matrix[5][4]);
//
//        System.out.println("-------------------");
//        System.out.println(matrix[5][2]);
//        System.out.println(matrix[5][3]);
//        System.out.println(matrix[5][4]);

