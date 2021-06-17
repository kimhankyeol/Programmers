package basic;

import java.util.*;

public class DfsBfs {
    /*
    그래프 탐색
    정점과 간선으로 이루어진 자료구조

    속도 면에서는 DFS 보다 BFS 가 훨씬 빠름
    DFS(깊이 우선탐색)
    //이동한 정점의 값을 가지고 계속 연산을 하는 경우 (재귀적으로 호출)

    BFS(너비 우선탐색)
    //최단 거리


    구현방법
    DFS 스택이나 재귀함수로 구현

    BFS 큐를 이용하여 구현

    문제 예시
    4 5 1
    1 2
    1 3
    1 4
    2 4
    3 4


    출력 //
    DFS  3 1 2 5 4
    BFS  3 1 4 2 5


    DFS 장점
    현경로상 노드들만 기억하면 되므로 저장공간 수요가 비교적적임 목표노드가 깊은 단계에 있을경우 해를 빨리구할수 있음

    단점
    해가 없는 경로가 깊을 경우 탐색시간이 오래걸림
    얻어진 해가 최단경로가 된다는 보장이 없음

    구현방법1
    인접 행렬(Adjacency Matrix)
    인접행렬은 행렬로 정점들 사이의 관계를 표현하는것
    간선방향의 존재유무에 따라 표현하는 방법에 차이가 있음음

    인접 리스트
    인접리스트 방식은 리스트 방식으로 각 정점이 연결된 노드들의 정보를 저장함
    간선방향의 존재 유무에 따라 출발지 도착지를 고려하여 리스트에 정보를 저장함



    BFS
    그래프 탐색의 한종류
    너비우선탐색
    루트노드나 임의의 노드에서 시작하여 인접한 노드를 먼저 모두 확인한 후 다음 depth를 탐색
    queue 를 사용하여 데이터를 탐색

    특징
    BFS는 시작정점부터 거리가 가까운정점의 순서로 탐색
    BFS는 재귀적으로  동작하지 않음
    FIFO원칙으로 탐색색
   */

    static int map[][];  //정점과 간선을 표현하는 행렬
                        //입력 1로 예를 들면 map[1][2] == 1
                        // 사이즈는 n+1로 지정
    static ArrayList<TreeMap<Integer,Integer>> arrayList; // 인접리스트 표현
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int n,m,v; //정점의 개수 , 간선의 개수 ,시작 정점
    static String answer = "";

    public static void main(String[] args) {
        dfs_adjacency_matrix(5);
    }

    // 인접행렬로 구현한 DFS (정점의 개수가 작은 경우에만 사용하는걸 권장)
    public static void dfs_adjacency_matrix(int v){
        m=5;
        visited[v] = true;
        answer += v+" ";
        System.out.println(answer);
        for(int i =1 ; i<m; i++){
            if(map[v][i] == 1 && !visited[i]) {
                dfs_adjacency_matrix(i);
            }
        }
    }
    // 인접리스트로 구현한 DFS
    public static void dfs_adjacency_list(int v) {
        visited[v] = true;
        answer += v+" ";

        TreeMap<Integer, Integer> tmap = arrayList.get(v);
        for(int i : tmap.keySet()) {
            if(!visited[i]) {
                dfs_adjacency_list(i);
            }
        }

    }

    // 스택으로 구현한 DFS
    public static void dfs_stack(int v) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);

        while(!stack.isEmpty()) {
            int vv= stack.pop();
            visited[vv] = true;
            answer += vv+" ";

            for(int i=1; i<n+1;i++) {
                if(map[vv][i] == 1 && !visited[i]) {
                    stack.push(i);			// stack에 담고 빠져나온다.
                    break;
                }
            }
        }

    }

    // 큐로 구현한 BFS (인접행렬)
    public static void bfs_queue_adjacency_matrix(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int vv = q.poll();
            answer += vv+" ";

            for(int i=1; i<n+1 ; i++) {
                if(map[vv][i] == 1 && !visited[i]) {
                    q.offer(i);			// queu에 담고 계속 진행 map[vv][i~n] 끝까지 탐색
                    visited[i] = true;
                }
            }
        }
    }

    // 큐로 구현하는 BFS (인접리스트)
    public static void bfs_queue_adjacency_list(int v){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            v = q.poll();
            answer += v +" ";

            Iterator<Integer> it = adjList[v].listIterator();
            while(it.hasNext()){
                int w = it.next();
                if(!visited[w]){
                    visited[w]=true;
                    q.add(w);
                }
            }
        }
    }


}
