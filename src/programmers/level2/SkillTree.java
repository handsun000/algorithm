package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int j = 0; j < skill.length(); j++) map.put(skill.charAt(j), 0);

            boolean flag = true;
            int start = 0;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                char s = skill_trees[i].charAt(j);
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                    if (map.get(skill.charAt(start)) < map.get(s)) {
                        map.put(s, 0);
                        flag = false;
                        break;
                    }
                    else start++;

                }
            }
            if (flag) answer ++;
        }

        return answer;
    }
}
