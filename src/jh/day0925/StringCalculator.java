package jh.day0925;

public class StringCalculator {

    public int plusNumber(String my_string) {
        if(my_string.isEmpty() || my_string.length() > 1000) {
            throw new IllegalArgumentException("문자의 길이는 1이상 1000이하");
        } // end if

        boolean containsUpperCase = my_string.matches(".*[A-Z]+.*");
        boolean containsLowerCase = my_string.matches(".*[a-z]+.*");
        boolean containsNumber = my_string.matches(".*[0-9]+.*");

        if(!containsUpperCase || !containsLowerCase || !containsNumber) {
            throw new IllegalArgumentException("문자는 대문자, 소문자, 한자리 자연수로 구성되어야 합니다.");
        } // end if

        int answer = 0;
        char[] chars = my_string.toCharArray();

        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                answer += Integer.parseInt(String.valueOf(ch));
            } // end if
        } // end for

        return answer;
    } // stringCalculator

} // class