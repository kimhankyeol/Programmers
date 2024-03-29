package basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 	문제 링크
 * 		https://www.acmicpc.net/problem/1260
 *
 *  문제 풀이 참고 링크
 *  	https://sundries-in-myidea.tistory.com/4
 *  	https://mygumi.tistory.com/102
 *  	https://take-her-to-the-moon-for-me.tistory.com/15
 *  	https://minhamina.tistory.com/36
 */
public class BFS {

    static int map[][];										// 인접행렬 표현
    static LinkedList<Integer>[] adjList;					// 인접리스트 표현(LinkedList([]))
    static boolean[] visited;
    static int n,m,v;			// 정점의 개수, 간선의 개수, 시작 정점
    static String answer = "";

    public static void main(String[] args) throws IOException {
		/* 예제 1
4 5 1
1 2
1 3
1 4
2 4
3 4
		 * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // map, visit의 사이즈는 n+1로 설정
        map =new int[n+1][n+1];
        visited = new boolean[n+1];
        adjList = new LinkedList[n+1];

        // Arrays.fill ( index, default) default로 기본값 채우기
        for(int j=0; j<n+1;j++){
            Arrays.fill(map[j], 0);								// 인접행렬
            adjList[j]= new LinkedList<Integer>();
        }
        Arrays.fill(visited, false);
//		System.out.println();
        for(int i=0; i<m; i++){
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge," ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            map[a][b] = map[b][a] = 1;			// 인접행렬

            adjList[a].add(b);					// 인접리스트
            adjList[b].add(a);
//			System.out.println("adjList.["+a+"]  : "+ adjList[a]);
        }

//		long start = System.currentTimeMillis(); 	//시작하는 시점 계산
//		long end = System.currentTimeMillis(); 		//종료되는 시점 계산
//		System.out.println("start : " + start+" / end : " + end + " :::  total :"+(end-start));

        // 큐로 구현하는 BFS(인접행렬)
        bfs_queue_adjacency_matrix(v);
        init();

        // 큐로 구현하는 BFS(인접리스트)
        for(int i=0;i<=n;i++){
            Collections.sort(adjList[i]);
        }
        bfs_queue_adjacency_list(v);

    }

    // 인접행렬과 큐로 구현한 BFS
    public static void bfs_queue_adjacency_matrix(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int vv = q.poll();
            answer += vv+" ";
            System.out.println("bfs_queue_adjacency_matrix :: answer  : "+answer);
            for(int i=1; i<n+1 ; i++) {
                if(map[vv][i] == 1 && !visited[i]) {
                    q.offer(i);			// queu에 담고 계속 진행 map[vv][i~n] 끝까지 탐색
                    visited[i] = true;
                }
            }
        }
    }

    // 인접리스크와 큐로 구현하는 BFS
    public static void bfs_queue_adjacency_list(int v){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            v = q.poll();
            answer += v +" ";
            System.out.println("bfs_queue_adjacency_list :: answer  : "+answer);
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

    public static void init() {
        Arrays.fill(visited, false);
        answer = "";
    }
}