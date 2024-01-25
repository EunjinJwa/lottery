package jinny.app.lottery.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private static NumberSetGenerator numberSetGenerator;

    public NumberGenerator(NumberStats numberStats) {
        new NumberSetGenerator(numberStats);
    }

    public static Set<Integer> genNumbersByAlorithm1() {
        Set<Integer> genNumbers = new HashSet<>();
        genNumbers.add(pickNumber("Type1"));
        genNumbers.add(pickNumber("Type2"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type5"));

        return genNumbers;
    }

    public static Set<Integer> genNumbersByAlorithm2() {
        Set<Integer> genNumbers = new HashSet<>();
        genNumbers.add(pickNumber("Type2"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type5"));

        return genNumbers;
    }

    private static int pickNumber(String type) {
        List<NumberStat> collection = getNumbersSet(type);

        return pickNumber(collection);
    }

    private static List<NumberStat> getNumbersSet(String type) {
        switch (type) {
            case "Type1":
                return numberSetGenerator.getNumbersByPrevDrw();
            case "Type2":
                return numberSetGenerator.getNumbersByHitCountRange(4, 4);
            case "Type3":
                return numberSetGenerator.getNumbersByHitCountRange(5, 10);
            case "Type4":
                return numberSetGenerator.getNumbersByHitCountRange(2, 3);
            case "Type5":
                return numberSetGenerator.getNumbersByOneHit();
            default:
                return numberSetGenerator.getNumbersByHitCountRange(2, 5);
        }
    }

    private static List<NumberStat> getNumbersAlgorithm2(String type) {
        switch (type) {
            case "Type1":
                return numberSetGenerator.getNumbersByPrevDrw();
            case "Type2":
                return numberSetGenerator.getNumbersByHitCountRange(4, 4);
            case "Type3":
                return numberSetGenerator.getNumbersByHitCountRange(5, 10);
            case "Type4":
                return numberSetGenerator.getNumbersByHitCountRange(2, 3);
            case "Type5":
                return numberSetGenerator.getNumbersByOneHit();
            default:
                return numberSetGenerator.getNumbersByHitCountRange(2, 5);
        }
    }


    public static int pickNumber(List<NumberStat> numStats) {
        int randomIndex = getRandomIndex(numStats.size());

        return numStats.get(randomIndex).getNumber();
    }

    private static int getRandomIndex(int max) {
        Random random = new Random();

        return random.nextInt(max);
    }

}
