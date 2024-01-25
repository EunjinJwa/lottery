package jinny.app.lottery.domain;

import java.util.Set;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PickNumberSet {

    private String no;
    private Set<Integer> numbers;

    public PickNumberSet(int index, Set<Integer> numbers) {
        this.no = parseNo(index);
        this.numbers = numbers;
    }

    private String parseNo(int index) throws RuntimeException{
        switch (index) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            default:
                throw new RuntimeException("out of range: pick number index. It's to be less than 6");
        }
    }
}
