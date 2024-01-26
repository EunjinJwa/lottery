package jinny.app.lottery.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberSetGenerator {

    private static NumberStats numberStats;

    public NumberSetGenerator(NumberStats numberStats) {
        NumberSetGenerator.numberStats = numberStats;
    }

    // 직전 회차 Number Set
    public static List<NumberStat> getNumbersByPrevDrw() {
        return numberStats.getNumStatsByPrevDrw();
    }

    // 당첨 횟수 범위내에 있는 Number Set
    public static List<NumberStat> getNumbersByHitCountRange(int minHitCount, int maxHitCount) {
        boolean isIncludePrevDrw = false;   // 직전 회차 번호 포함 여부
        return IntStream.rangeClosed(minHitCount, maxHitCount)
            .mapToObj(hitCount -> numberStats.getNumStatsByHitCount(hitCount, isIncludePrevDrw))
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    // 1번 당첨 숫자 중 diff 가 기준 횟수의 diffRatio 이상 떨어진 숫자
    public static List<NumberStat> getNumbersByOneHit(double diffRatio) {
        return IntStream.rangeClosed(1, 1)
            .mapToObj(hitCount -> numberStats.getNumStatsByHitCount(hitCount, false))
            .flatMap(List::stream)
            .filter(numStat -> numStat.getLastDiff() >= numberStats.calcDrwDiffCount(diffRatio) )
            .collect(Collectors.toList());
    }


    public List<NumberStat> getNumbersByTwoHit(double diffRatio) {
        return IntStream.rangeClosed(2, 2)
            .mapToObj(hitCount -> numberStats.getNumStatsByHitCount(hitCount, false))
            .flatMap(List::stream)
            .filter(numStat -> numStat.getLastDiff() >= numberStats.calcDrwDiffCount(diffRatio) )
            .collect(Collectors.toList());
    }
}
