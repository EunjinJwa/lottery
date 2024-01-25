package jinny.app.lottery.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import jinny.app.lottery.webclient.LottoNumberResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class NumberStats {

    private final int latestDrw;
    private final int baseDrwCount;           // 최근 당첨 회차 건수
    private List<NumberStat> numStats;          // 1 ~ 45 까지 숫자의 당첨 통계

    public NumberStats(int latestDrw, int baseDrwCount) {
        this.latestDrw = latestDrw;
        this.baseDrwCount = baseDrwCount;
        initNumberStats();
    }

    private void initNumberStats() {
        numStats = IntStream.rangeClosed(1, 45)
            .mapToObj(NumberStat::new)
            .collect(Collectors.toList());
    }

    public void addNumStats(LottoNumberResponse data) {
        setNumStat(data.getDrwNo(), data.getDrwtNo1());
        setNumStat(data.getDrwNo(), data.getDrwtNo2());
        setNumStat(data.getDrwNo(), data.getDrwtNo3());
        setNumStat(data.getDrwNo(), data.getDrwtNo4());
        setNumStat(data.getDrwNo(), data.getDrwtNo5());
        setNumStat(data.getDrwNo(), data.getDrwtNo6());

    }

    private void setNumStat(int drwNo, int number) {
        NumberStat numStatByNumber = getNumStatByNumber(number);
        numStatByNumber.addHit();
        numStatByNumber.setLastDiff(latestDrw - drwNo+1);
    }

    public NumberStat getNumStatByNumber(int number) {
        return numStats.stream().filter(numberStat -> numberStat.getNumber() == number)
            .findFirst().get();
    }

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

    public int calcDrwDiffCount(double ratio) {
        return (int) (baseDrwCount * ratio);
    }

}
