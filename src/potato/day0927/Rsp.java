package potato.day0927;

import java.util.Scanner;

public class Rsp {
    public String validateInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();;

        if(!input.equals("가위") && !input.equals("바위") && !input.equals("보")) {
            throw new IllegalArgumentException("입력값은 '가위','바위','보' 중에 하나만 가능합니다.");
        }

        return input;
    }

    public String game() {
        String input = validateInput();

        if(input.equals("가위")){
            return "바위";
        }else if(input.equals("바위")){
            return "보";
        }else {
            return "가위";
        }
    }

    public static void main(String[] args) {
        Rsp rsp = new Rsp();
        System.out.println(rsp.game());
    }
}
