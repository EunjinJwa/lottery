package jinny.app.lottery.domain;

import java.util.HashSet;
import java.util.Set;
import jinny.app.lottery.webclient.LottoNumberResponse;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LottoNumber {

    private int drwNo;
    private Set<Integer> numbers = new HashSet<>();

    public void setNumbers(int num1, int num2, int num3, int num4, int num5, int num6) {
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);
        numbers.add(num4);
        numbers.add(num5);
        numbers.add(num6);
    }

    public void addNumbers(int num) {
        numbers.add(num);
    }

    public static LottoNumber from(LottoNumberResponse origin) {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.drwNo = origin.getDrwNo();
        lottoNumber.setNumbers(origin.getDrwtNo1(), origin.getDrwtNo2(), origin.getDrwtNo3(), origin.getDrwtNo4(), origin.getDrwtNo5(), origin.getDrwtNo6());

        return lottoNumber;
    }



}
