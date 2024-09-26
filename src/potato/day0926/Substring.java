package potato.day0926;

public class Substring {

    public int containSubstring(String my_string, String target) {
        validateLength(my_string);
        validateLength(target);
        validateLetter(my_string);
        validateLetter(target);

//        boolean contains = my_string.contains(target);
//
//        if (contains) {
//            return 1;
//        }else {
//            return 0;
//        }

        return my_string.contains(target) ? 1 : 0;
    }

    public void validateLength(String str){
        if(str.isBlank() || str.length() > 100){
            throw new IllegalArgumentException("1자에서 100자 가능");
        }
    }

    public void validateLetter(String str){
//        return str.matches("[a-z]");
        boolean validation = str.matches("^[a-z]*$");

        if(!validation){
            throw new IllegalArgumentException("영문 소문자만 입력 가능");
        }
    }


}
