package programmers.level3;


import java.util.*;

/**
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 */
public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> best = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for (int i = 0; i < genreList.size(); i++) {
            Map<Integer, Integer> play = new HashMap<>();
            String g = genreList.get(i);
            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(g)) {
                    play.put(j, plays[j]);
                }
            }
            List<Integer> index = new ArrayList<>(play.keySet());
            index.sort((o1,o2) -> play.get(o2).compareTo(play.get(o1)));
            if (index.size() > 1) {
                for (int j = 0; j<2; j++) {
                    best.add(index.get(j));
                }
            } else {
                best.add(index.get(0));
            }
        }

        int[] answer = new int[best.size()];

        for (int i = 0; i<best.size(); i++) {
            answer[i] = best.get(i);
        }

        return answer;
    }
}
