package programmers.level1;

public class 붕대감기 {
    public static void main(String[] args) {
        int[] bandage = {3,10,1};
        int health = 100;
        int[][] attacks = {{1,5},{3,5}};

        System.out.println(solution(bandage, health, attacks));
    }
    static public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int bandageTime = bandage[0];
        int std = 0;

        int v1, v2;
        for (int[] ark : attacks) {
            if (answer <= 0) return -1;

            v1 = ark[0] - std - 1; // 시간 차이
            v2 = v1 / bandageTime;

            std = ark[0];
            answer = Math.min(health, answer + (v1*bandage[1]));
            answer = Math.min(health, answer + (v2*bandage[2]));

            answer -= ark[1];
        }

        return answer;
    }
}
