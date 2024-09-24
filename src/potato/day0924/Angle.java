package potato.day0924;

public class Angle {
    private static final int MIN_ANGLE = 0;
    private static final int MAX_ANGLE = 180;
    private static final int RIGHT_ANGLE_DEGREE = 90;
    private static final int ACUTE_ANGLE = 1;
    private static final int RIGHT_ANGLE = 2;
    private static final int OBTUSE_ANGLE = 3;
    private static final int FLAT_ANGLE = 4;

    public int angle(int degree) throws IllegalArgumentException {
        boolean notInRange = degree <= MIN_ANGLE || degree > MAX_ANGLE;

        if (notInRange) {
            throw new IllegalArgumentException();
        }

        if(degree == RIGHT_ANGLE_DEGREE){
            return RIGHT_ANGLE;
        }else if(degree == MAX_ANGLE){
            return FLAT_ANGLE;
        }else if(degree < RIGHT_ANGLE_DEGREE){
            return ACUTE_ANGLE;
        }else {
            return OBTUSE_ANGLE;
        }
    }
}
