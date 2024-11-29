package programmers.level0;

public class 나이출력 {
    public static void main(String[] args) {
        System.out.println(solution(23));
    }
    static public int solution(int age) {
        int year = 2022;
        return year - age + 1;
    }
}