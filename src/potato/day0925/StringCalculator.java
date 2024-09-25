package potato.day0925;

public class StringCalculator {
    boolean validation = false;

    public int add(String str) {
        int sum = 0;

        checkParameter(str);
        str = setOnlyDigits(str);

        if (!validation) {
            throw new IllegalArgumentException("알파벳과 숫자만 입력 가능");
        }

        if (!str.isBlank()) {
            String[] numbers = str.split("");
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    public void checkParameter(String str) {
        if (str.isBlank() || str.length() > 1000) {
            throw new IllegalArgumentException("1자에서 1000자까지 가능");
        }
    }

    public String setOnlyDigits(String str) {
        String[] digits = str.split("");
        StringBuilder sb = new StringBuilder();

        for (String digit : digits) {
            if (digit.matches("[0-9]")) {
                sb.append(digit);
                validation = true;
            } else if (digit.matches("[a-zA-Z]")) {
                validation = true;
            } else {
                validation = false;
                break;
            }
        }

        return sb.toString();
    }

}
