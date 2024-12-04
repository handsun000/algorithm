package programmers.level1;

import java.util.*;

public class 데이터분석 {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80},{2, 20300804, 847, 37},{3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        System.out.println(solution(data, ext, val_ext, sort_by));
    }

    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int sort = switch (sort_by) {
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> 0;
        };

        int e = switch (ext) {
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> 0;
        };

        for (int[] d : data) {
            if (d[e] <= val_ext) list.add(d);
        }

        list.sort(Comparator.comparingInt(o -> o[sort]));
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
