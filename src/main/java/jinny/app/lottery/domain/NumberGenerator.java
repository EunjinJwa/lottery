package jinny.app.lottery.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

    private NumberStats numberStats;

    public Set<Integer> genNumbers() {
        Set<Integer> genNumbers = new HashSet<>();
        genNumbers.add(pickNumber("Type1"));
        genNumbers.add(pickNumber("Type2"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type5"));
        genNumbers.add(pickNumber("Type6"));

        return genNumbers;
    }

    private int pickNumber(String type) {
        List<NumberStat> collection = getNumbers(type);

        return pickNumber(collection);
    }

    private List<NumberStat> getNumbers(String type) {
        switch (type) {
            case "Type1":
                return getNumbersByPrevDrw();
            case "Type2":
                return getNumStatByHitCountRange(4, 4);
            default:
                return getNumStatByHitCountRange(2, 5);
        }
    }

    private List<NumberStat> getNumbersByPrevDrw() {
        return numberStats.getNumStatsByPrevDrw();
    }

    private List<NumberStat> getNumStatByHitCountRange(int from, int to) {
        return IntStream.rangeClosed(from, to)
            .mapToObj(hitCount -> numberStats.getNumStatsByHitCount(hitCount, false))
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }


    public int pickNumber(List<NumberStat> numStats) {
        int randomIndex = getRandomIndex(numStats.size());

        return numStats.get(randomIndex).getNumber();
    }

    private int getRandomIndex(int max) {
        Random random = new Random();

        return random.nextInt(max);
    }



}
