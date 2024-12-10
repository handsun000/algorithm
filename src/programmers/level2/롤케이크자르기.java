package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 롤케이크자르기 {
    public static void main(String[] args) {

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));

    }
    public static int solution (int[] topping) {
        int answer = 0;

        // 왼쪽과 오른쪽에서 고유한 토핑을 추적할 Set
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        // 초기 오른쪽 Map 생성
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        // 배열 순회
        for (int t : topping) {
            // 현재 토핑을 왼쪽 Set에 추가
            leftSet.add(t);

            // 오른쪽 Map에서 현재 토핑 제거
            rightMap.put(t, rightMap.get(t) - 1);
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }

            // 왼쪽 Set과 오른쪽 Map의 고유 토핑 수 비교
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
