package programmers.level0;

public class 숫자비교하기 {
    public static void main(String[] args) {
        System.out.println(solution(3, 4));
    }
    static public int solution(int num1, int num2) {
        if (num1 == num2) return 1;
        return -1;
    }
}