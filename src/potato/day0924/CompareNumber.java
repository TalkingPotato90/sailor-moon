package potato.day0924;

public class CompareNumber {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 10000;

    public int checkNumber(int num1, int num2) {
        boolean num1IsNotInRange = num1 < MIN_NUM || num1 > MAX_NUM;
        boolean num2IsNotInRange = num2 < MIN_NUM || num2 > MAX_NUM;

        if (num1IsNotInRange || num2IsNotInRange) {
            throw new IllegalArgumentException();
        }

        if (num1 == num2) {
            return 1;
        } else {
            return -1;
        }
    }
}
