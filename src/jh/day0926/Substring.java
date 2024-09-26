package jh.day0926;

public class Substring {

    /**
     * target이 my_string의 부분 문자열인지 확인하기
     * @param my_string
     * @param target
     * @return 부분 문자열이라면 1, 아니라면 0
     */
    public int doesContainSubstring(String my_string, String target) {
        if(!checkLength(my_string, target) || !checkLowerCase(my_string, target)) {
            throw new IllegalArgumentException();
        } // end if

        int answer = 0;

        if(my_string.contains(target)) {
            answer = 1;
        } // end if

        return answer;
    } // doesContainSubstring

    /**
     * my_string과 target의 길이가 1 이상 100 이하인지 확인하기
     * @param my_string
     * @param target
     * @return true or false
     */
    public boolean checkLength(String my_string, String target) {
        return (!my_string.isBlank() && my_string.length() <= 100) &&
                (!target.isBlank() && target.length() <= 100);
    } // checkLength

    /**
     * my_string과 target이 영소문자로만 이루어져 있는지 확인하기
     * @param my_string
     * @param target
     * @return true or false
     */
    public boolean checkLowerCase(String my_string, String target) {
        char[] my_string_chars = my_string.toCharArray();
        char[] target_chars = target.toCharArray();
        boolean my_string_isLower = false;
        boolean target_isLower = false;

        for(char ch : my_string_chars) {
            if(Character.isLowerCase(ch)) {
                my_string_isLower = true;
            } // end if
        } // end for

        for(char ch : target_chars) {
            if(Character.isLowerCase(ch)) {
                target_isLower = true;
            } // end if
        } // end for

        return my_string_isLower && target_isLower;
    } // checkLowerCase

} // class