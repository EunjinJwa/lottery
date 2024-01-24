package jinny.app.lottery.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class NumberStat {

    private int number;
    private int hitCount;
    private int lastDiff;           // 마지막 당첨된 회차와 다음 회자 간의 거리. default = 0
    private String grade;

    public NumberStat(int number) {
        this.number = number;
        this.hitCount = 1;
        this.lastDiff = 0;
    }

    // 직전 회차 당첨 여부
    public boolean isPrevDrwHit() {
        return lastDiff == 1;
    }
}
