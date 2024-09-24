package jh.day0924;

public class CompareNumber {

    public int compareNumber(int num1, int num2) {

        if((num1 < 0 || num1 > 10000) || (num2 < 0 || num2 > 10000)) {
            throw new IllegalArgumentException("입력값은 0 이상 10000 이하의 값이어야 합니다.");
        } // end if

        if(num1 == num2) {
            return 1;
        } else {
            return -1;
        } // ene else

    } // compareNumber

} // class