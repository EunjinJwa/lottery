package jinny.app.lottery;

import jinny.app.lottery.common.LottoDrwNo;
import org.junit.jupiter.api.Test;

class LottoDrwNoTest {

    int baseDrwNumber = 1103;
    long baseDrwTimestamp = 1705708800000L;
    long ONE_DAY_TIMES = 86400000;

    @Test
    public void calcLastLottoDrwNo() {
        System.out.println(LottoDrwNo.calcLastLottoDrwNo());

    }

}