package programmers.level0;

public class 두수의나눗셈 {
    public static void main(String[] args) {

        System.out.println(solution(3, 2));
    }
    static public int solution(int num1, int num2) {
        return (int)((double)num1/num2 * 1000.0);
    }
}
