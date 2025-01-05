package programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 문자열나누기 {
    public static void main(String[] args) {
        System.out.println(solution("abdcb"));
    }

    public static int solution(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);

            for (char key : map.keySet()) {
                if (key == c) continue;
                if (map.get(key) == count) {
                    answer++;
                    map = new HashMap<>();
                    break;
                }
            }
        }
        if (!map.isEmpty()) answer++;
        return answer;
    }
}
