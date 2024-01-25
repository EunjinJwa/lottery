package jinny.app.lottery.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private static NumberSetGenerator numberSetGenerator;

    public NumberGenerator(NumberStats numberStats) {
        new NumberSetGenerator(numberStats);
    }

    public static Set<String> genNumbersByAlorithm1() {
        Set<String> genNumbers = new HashSet<>();
        genNumbers.addAll(pickNumber("Type1", 1));
        genNumbers.addAll(pickNumber("Type2", 1));
        genNumbers.addAll(pickNumber("Type3", 1));
        genNumbers.addAll(pickNumber("Type4", 2));
        genNumbers.addAll(pickNumber("Type5", 1));

        return genNumbers;
    }

    private static String convertNumberFormat(int number) {
        String formattedNumber = String.format("%02d", number);
        return formattedNumber;
    }

    public static Set<String> genNumbersByAlorithm2() {
        Set<String> genNumbers = new HashSet<>();
        genNumbers.addAll(pickNumber("Type2",1));
        genNumbers.addAll(pickNumber("Type3",1));
        genNumbers.addAll(pickNumber("Type4", 3));
        genNumbers.addAll(pickNumber("Type5",1));

        return genNumbers;
    }

    private static int pickNumber(String type) {
        List<NumberStat> collection = getNumbersSet(type);

        return pickNumber(collection);
    }

    private static Set<String> pickNumber(String type, int count) {
        List<NumberStat> collection = getNumbersSet(type);

        return pickNumber(collection, count);
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

    public static Set<String> pickNumber(List<NumberStat> numStats, int count) {
        Set<String> result = new HashSet<>();

        List<Integer> randomIndex = getRandomIndex(numStats.size(), count);

        for (Integer index : randomIndex) {
            result.add(convertNumberFormat(numStats.get(index).getNumber()));
        }

        return result;
    }
    private static List<Integer> getRandomIndex(int max, int count) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            result.add(random.nextInt(max));
        }

        return result;
    }

}
