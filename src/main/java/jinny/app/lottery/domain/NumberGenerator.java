package jinny.app.lottery.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class NumberGenerator {

    private static Random random = new Random();
    private static Set<String> genNumbers;
    private static NumberSetGenerator numberSetGenerator;

    public NumberGenerator(NumberStats numberStats) {
        new NumberSetGenerator(numberStats);
        System.out.println("SET Type0: " + getNumbers("Type0"));
        System.out.println("SET Type1: " + getNumbers("Type1"));
        System.out.println("SET Type2: " + getNumbers("Type2"));
        System.out.println("SET Type3: " + getNumbers("Type3"));
        System.out.println("SET Type4: " + getNumbers("Type4"));
        System.out.println("SET Type5: " + getNumbers("Type5"));
        System.out.println("SET Type6: " + getNumbers("Type6"));
        System.out.println("SET Default: " + getNumbers("Default"));
    }

    List<Integer> getNumbers(String type) {
        List<NumberStat> numbersSet = getNumbersSet(type);

        return numbersSet.stream()
                .map(set -> set.getNumber())
                .collect(Collectors.toList());
    }

    private static List<NumberStat> getNumbersSet(String type) {
        switch (type) {
            case "Type0":
                return numberSetGenerator.getNumbersByHitCountRange(0, 0);
            case "Type1":
                return numberSetGenerator.getNumbersByPrevDrw();
            case "Type2":
                return numberSetGenerator.getNumbersByHitCountRange(4, 4);
            case "Type3":
                return numberSetGenerator.getNumbersByHitCountRange(4, 10);
            case "Type4":
                return numberSetGenerator.getNumbersByHitCountRange(2, 3);
            case "Type5":
                return numberSetGenerator.getNumbersByOneHit(0.5);
            case "Type6":
                return numberSetGenerator.getNumbersByHitCountRange(3, 3);
            default:
                return numberSetGenerator.getNumbersByHitCountRange(2, 5);
        }
    }

    public static Set<String> genNumbersByAlorithm1() {
        genNumbers = new TreeSet<>();
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type5"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type6"));
        genNumbers.add(pickNumber("Type2"));
        genNumbers.add(pickNumber("Type6"));
        System.out.println("Alg1 : " + genNumbers);
        return genNumbers;
    }

    public static Set<String> genNumbersByAlorithm2() {
        genNumbers = new TreeSet<>();
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type1"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type6"));
        System.out.println("Alg2 : " + genNumbers);

        return genNumbers;
    }

    public static Set<String> genNumbersByAlorithm3() {
        genNumbers = new TreeSet<>();
        genNumbers.add(pickNumber("Type2"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type5"));
        genNumbers.add(pickNumber("Type4"));
        System.out.println("Alg3 : " + genNumbers);
        return genNumbers;
    }

    public static Set<String> genNumbersByAlorithm4() {
        genNumbers = new TreeSet<>();
        genNumbers.add(pickNumber("Type5"));
        genNumbers.add(pickNumber("Type2"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type6"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Default"));
        System.out.println("Alg4 : " + genNumbers);
        return genNumbers;
    }

    public static Set<String> genNumbersByAlorithm5() {
        genNumbers = new TreeSet<>();
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type4"));
        genNumbers.add(pickNumber("Type3"));
        genNumbers.add(pickNumber("Type5"));
        genNumbers.add(pickNumber("Type6"));
        genNumbers.add(pickNumber("Default"));
        System.out.println("Alg5 : " + genNumbers);
        return genNumbers;
    }


    private static String convertNumberFormat(int number) {
        String formattedNumber = String.format("%02d", number);
        return formattedNumber;
    }

    private static String pickNumber(String type) {
        List<NumberStat> collection = getNumbersSet(type);

        return pickNumberFromCollection(collection);
    }



    public static String pickNumberFromCollection(List<NumberStat> numStats) {
        Integer index = getRandomIndex(numStats.size());

        String pickNumber = convertNumberFormat(numStats.get(index).getNumber());
        while (genNumbers.contains(pickNumber)) {
            System.out.println("index retry : " + index);
            index = getRandomIndex(numStats.size());
            pickNumber = convertNumberFormat(numStats.get(index).getNumber());
        }
        return pickNumber;
    }

    private static Integer getRandomIndex(int max) {
        return random.nextInt(max);
    }

}
