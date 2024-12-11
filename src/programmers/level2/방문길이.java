package programmers.level2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 방문길이 {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    public static int solution(String dirs) {

        Set<String> set = new HashSet<>();
        int x = 0, y = 0;

        for (int i = 0; i<dirs.length(); i++) {
            int idx = "UDLR".indexOf(dirs.charAt(i));
            int cx = x + dx[idx];
            int cy = y + dy[idx];

            if (!check(cx, cy)) continue;

            String path = x + "," + y + "->" + cx + "," + cy;
            String reversePath = cx + "," + cy + "->" + x + "," + y;
            set.add(path);
            set.add(reversePath);

            x = cx;
            y = cy;
        }
        return set.size()/2;
    }
    public static boolean check(int x, int y) {
        if (x > 5 || x < -5 || y > 5 || y < -5) return false;
        return true;
    }
}
