package programmers.level1;

import java.util.*;

public class Running_Race {
        public static void main(String[] args) {
                String[] players = {"mumu", "soe", "poe", "kai", "mine"};
                String[] callings = {"kai", "kai", "mine", "mine"};

                System.out.println(Arrays.toString(solution(players, callings)));

        }

        public static String[] solution(String[] players, String[] callings) {

                Map map = new HashMap();
                for (int i = 0; i < players.length; i++) {
                        map.put(players[i], i);
                }

                for (int i = 0; i < callings.length; i++) {
                        String call = callings[i];
                        int index = (int) map.get(call);
                        players[index] = players[index-1];
                        players[index-1] = call;
                        map.put(call, index-1);
                        map.put(players[index], index);

                }
                return players;
        }
}
