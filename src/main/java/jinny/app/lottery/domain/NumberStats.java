package jinny.app.lottery.domain;

import java.util.List;
import java.util.stream.Collectors;
import jinny.app.lottery.webclient.LottoNumberResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class NumberStats {

    private int baseDrwCount;           // 최근 당첨 회차 건수
    private List<NumberStat> numStats;


    public List<NumberStat> getNumStatsByHitCount(int hitCount, boolean includePrevDrw) {
        return numStats.stream()
            .filter(numStat -> numStat.getHitCount() == hitCount)
            .filter(numStat -> includePrevDrw || !numStat.isPrevDrwHit())
            .collect(Collectors.toList());
    }

    public List<NumberStat> getNumStatsByPrevDrw() {
        return numStats.stream()
            .filter(NumberStat::isPrevDrwHit)
            .collect(Collectors.toList());
    }

}
