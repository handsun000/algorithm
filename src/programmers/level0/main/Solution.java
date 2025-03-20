package programmers.level0.main;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return 0;
        });

        int time = 0;
        int idx = 0;
        int total = 0;
        int count = 0;

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];
                count++;
            } else {
                time = jobs[idx][0];
            }
        }

        return total / jobs.length;
    }
}
