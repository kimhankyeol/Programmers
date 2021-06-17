package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/////////////////////////////////////////////////////////////////////인접 행렬/////////////////////////////////////////////////////////
//public class DFSBasic {
//
//    static int edge;  //간선 수
//    static int vertex; //정점 수
//    static int[][] map; // 정점간의 연결의 정보를 담는 객체
//    static boolean[] visit; //정점을 방문 했는지 체크
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        vertex = sc.nextInt();
//        edge = sc.nextInt();
//        map =new int[vertex+1][vertex+1];
//        visit = new boolean[vertex];
//
//        for(int i=0; i<edge;i++){
//            int start = sc.nextInt();
//            int next = sc.nextInt();
//
//            map[start][next] =  map[next][start] = 1;
//
//        }
//
//        dfs(1);
//
//    }
//    public static void dfs(int start){
//        visit[start] = true;
//        System.out.println(start+ " ");
//        for(int i = 1; i<vertex+1;i++){
//            if(map[start][i]==1 && visit[i]==false){
//                dfs(i);
//            }
//        }
//    }
//}

//////////////인접 리스트/////////////////////////////
public class DFSBasic {
    //재귀호출로 종단 지점까지 방문하게끔 처리
    //arrayList : 정점간의 관계를 담는 객체 (ArrayList 에 배열을 붙인것이 포인트)
    //dfsList : 방문한 순서대로 저장하기 위한 리스트 객체
    //visit : 정점을 방문했는지 체크하기 위한 객체
    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;
    static ArrayList<Integer> dfsList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int line = sc.nextInt();
        int startVertex = sc.nextInt();

        arrayList = new ArrayList[vertex + 1];
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = new ArrayList<>();
        }
        visited = new boolean[vertex + 1];

        for (int i = 0; i < line; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for (int i = 1; i < vertex + 1; i++) {
            Collections.sort(arrayList[i]);
        }

        dfs(startVertex);

        for (Integer integer : dfsList) {
            System.out.print(integer + " ");

        }
    }
    public static void dfs(int x) {
        if (visited[x]) {
            return;
        }

        visited[x] = true;

        dfsList.add(x);
        for (int y : arrayList[x]) {
            if (!visited[y]) {
                dfs(y);
            }
        }
    }
}
