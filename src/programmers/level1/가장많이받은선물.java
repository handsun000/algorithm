package programmers.level1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 가장많이받은선물 {
    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> take = Arrays.stream(friends)
                .collect(Collectors.toMap(
                        e -> e,
                        e -> 0
                ));

        Map<String, Map<String, Integer>> gives = Arrays.stream(friends)
                .collect(Collectors.toMap(
                        e -> e,
                        e -> Arrays.stream(friends)
                                .collect(Collectors.toMap(
                                        f -> f,
                                        f -> 0
                                ))
                ));

        Map<String, Integer> result = Arrays.stream(friends)
                .collect(Collectors.toMap(
                        e -> e,
                        e -> 0
                ));

        for (String gift : gifts) {
            String g = gift.split(" ")[0];
            String t = gift.split(" ")[1];

            Map<String, Integer> map = gives.get(g);
            map.put(t, map.get(t)+1);
            gives.put(g, map);

            take.put(g, take.get(g)+1);
            take.put(t, take.get(t)-1);
        }

        for (int i = 0; i<friends.length; i++) {
            String friend1 = friends[i];
            Map<String, Integer> map1 = gives.get(friend1);

            for (int j = i+1; j<friends.length; j++) {
                String friend2 = friends[j];
                Map<String, Integer> map2 = gives.get(friend2);
                if (map1.get(friend2) < map2.get(friend1)) {
                    result.put(friend2, result.get(friend2) + 1);
                    if (answer < result.get(friend2)) answer = result.get(friend2);
                }
                else if (map1.get(friend2) > map2.get(friend1)) {
                    result.put(friend1, result.get(friend1) + 1);
                    if (answer < result.get(friend1)) answer = result.get(friend1);
                }
                else {
                    int a = take.get(friend1);
                    int b = take.get(friend2);
                    if (a < b) {
                        result.put(friend2, result.get(friend2)+1);
                        if (answer < result.get(friend2)) answer = result.get(friend2);
                    }
                    else if (a > b) {
                        result.put(friend1, result.get(friend1)+1);
                        if (answer < result.get(friend1)) answer = result.get(friend1);
                    }
                }
            }
        }
        return answer;
    }
}
