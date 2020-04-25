public class FrameHelper {
    public static FrameScoringMethod getframeScoringMethod(Frame frame) {
        if (frame.isSpare())  {
            return FrameScoringMethod.SPARE;
        }
        if (frame.isStrike()) {
            return FrameScoringMethod.STRIKE;
        }
        return FrameScoringMethod.NORMAL;
    }

}
