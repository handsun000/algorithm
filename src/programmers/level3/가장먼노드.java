package programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i<=n; i++) list.add(new Node(i));

        for (int[] e: edge) {
            Node node1 = list.get(e[0]);
            Node node2 = list.get(e[1]);

            node1.edge.add(node2);
            node2.edge.add(node1);
        }

        int max = 0;

        Queue<Node> q = new LinkedList<>();
        Node first = list.get(1);
        first.visited = true;
        q.offer(first);

        while(!q.isEmpty()) {
            Node now = q.poll();

            for (Node next : now.edge) {
                if (next.visited) continue;
                next.distance = now.distance + 1;
                next.visited = true;
                q.offer(next);
                max = Math.max(max, next.distance);
            }
        }

        for (Node node : list) {
            if (node.distance == max) answer++;
        }

        return answer;
    }
    static class Node {
        int num;
        int distance;
        boolean visited;
        List<Node> edge;

        Node(int num) {
            this.num = num;
            this.distance = 0;
            this.visited = false;
            edge = new ArrayList<>();
        }

        void add(Node node) {
            edge.add(node);
        }
    }
}
