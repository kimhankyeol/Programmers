package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinRoute {
    static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    static int a = maps.length;
    static int b = maps[0].length;
    static boolean[][] visited = new boolean[a][b];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) {
        System.out.println(bfs(0,0,maps));
    }
    public static int bfs(int x, int y, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();
            //종료조건 마지막행일떄
            if(node.x == a - 1 && node.y == b - 1)
                return node.cnt;
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < a && ny < b) {
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, node.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


//    public static void route(){
//        while(maps[lenX][lenY]==1){
//            System.out.println(startX);
//            if(startX == lenX && startY == lenY){
//                break;
//            }
//            startX++;
//            startY++;
//        }
//    }
//    public static void rightMove(){
//        if(startY==lenY){
//
//        }
//        startY++;
//        rightMove();
//        bottomMove();
//    }
//    public static void bottomMove(){
//        if(startX==lenX){
//
//        }
//        startX++;
//        rightMove();
//        bottomMove();
//    }
}
