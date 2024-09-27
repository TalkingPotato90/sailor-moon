package jh.day0927;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rsp {

    public String playRsp() {
        String output = null;
//        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            vaildInput(input);

            switch (input) {
                case "가위":
                    output = "바위";
                    break;
                case "바위":
                    output = "보";
                    break;
                case "보":
                    output = "가위";
                    break;
            } // end case
//        } catch(InputMismatchException e) {
//            playRsp();
//        } // end catch

        return output;
    } // playRsp

    public void vaildInput(String input) {
        if(!("가위".equals(input) || "바위".equals(input) || "보".equals(input))) {
            throw new InputMismatchException("가위/바위/보 중 하나만 입력 가능합니다.");
        } // end if
    } // validInput

} // class