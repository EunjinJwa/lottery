package jinny.app.lottery;

public class LottoDrwNo {

    private final static int BASE_DRW_NUMBER = 1103;
    private final static long BASE_DRW_TIMESTAMP = 1705708800000L;       // 1103 회자인 2024-01-20 의 timestamp
    private final static long ONE_DAY_TIMES = 86400000;

    public static int calcLastLottoDrwNo() {
        final long currentTimeMillis = System.currentTimeMillis();
        int days = (int) Math.floor((currentTimeMillis - BASE_DRW_TIMESTAMP) / ONE_DAY_TIMES / 7);

        return BASE_DRW_NUMBER + days;
    }

}
