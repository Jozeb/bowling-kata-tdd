public class FrameHelper {
    public static FrameScoringMethod getframeScoringMethod(Frame frame) {
        if (frame.isStrike()) {
            return FrameScoringMethod.STRIKE;
        }

        if (frame.isSpare())  {
            return FrameScoringMethod.SPARE;
        }

        return FrameScoringMethod.NORMAL;
    }

}
