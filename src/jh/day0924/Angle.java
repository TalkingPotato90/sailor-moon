package jh.day0924;

public class Angle {

    public int checkAngle(int angle) {

        if(angle > 0 && angle < 90) {
            return 1;
        } else if(angle == 90) {
            return 2;
        } else if(angle > 90 && angle < 180) {
            return 3;
        } else if(angle == 180) {
            return 4;
        } else {
            throw new IllegalArgumentException("입력값은 0 초과 180 미만이어야 합니다.");
        } // end else
    } // checkAngle

} // class