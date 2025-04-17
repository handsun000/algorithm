package programmers.level0.main;// 3210123
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] point = {3,2,1,0,1,2,3};

        Map<String, Integer> rt = new HashMap<>();
        rt.put("r", 0);
        rt.put("t", 0);
        Map<String, Integer> cf = new HashMap<>();
        cf.put("c", 0);
        cf.put("f", 0);
        Map<String, Integer> jm = new HashMap<>();
        jm.put("j", 0);
        jm.put("m", 0);
        Map<String, Integer> an = new HashMap<>();
        an.put("a", 0);
        an.put("n", 0);

        for (int i = 0; i<survey.length; i++) {
            String s = survey[i];
            String s0 = String.valueOf(s.charAt(0));
            String s1 = String.valueOf(s.charAt(1));

            int c = choices[i]-1;

            if (c < 4) {
                if (s.contains("r")) {
                    rt.put(s0, rt.get(s0)+point[c]);
                }
                else if (s.contains("c")) {
                    cf.put(s0, rt.get(s0)+point[c]);
                }
                else if (s.contains("j")) {
                    jm.put(s0, rt.get(s0)+point[c]);
                }
                else if (s.contains("a")) {
                    an.put(s0, rt.get(s0)+point[c]);
                }
            }
            else if (4 < c) {
                if (s.contains("r")) {
                    rt.put(s1, rt.get(s1)+point[c]);
                }
                else if (s.contains("c")) {
                    cf.put(s1, rt.get(s1)+point[c]);
                }
                else if (s.contains("j")) {
                    jm.put(s1, rt.get(s1)+point[c]);
                }
                else if (s.contains("a")) {
                    an.put(s1, rt.get(s1)+point[c]);
                }
            }
        }

        System.out.println(rt);
        System.out.println(cf);
        System.out.println(jm);
        System.out.println(an);

        return answer;
    }
}