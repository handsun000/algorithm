package programmers.level1;

import java.util.ArrayList;

public class MakingHamBurger {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(solution(ingredient));
    }
    public static int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
        }

        for (int i = 3; i < list.size(); i++) {
            if (list.get(i) == 1 && list.get(i - 1) == 3 && list.get(i - 2) == 2 && list.get(i - 3) == 1) {
                list.remove(i);
                list.remove(i - 1);
                list.remove(i - 2);
                list.remove(i - 3);
                answer++;
                if (i > 0) {
                    if (list.size() > 3) i -= 3;
                    else break;
                }
            }
        }

        return answer;
    }
}
