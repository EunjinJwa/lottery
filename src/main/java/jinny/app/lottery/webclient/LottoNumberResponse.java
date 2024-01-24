package jinny.app.lottery.webclient;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LottoNumberResponse {

    private Long totSellamnt;
    private String returnValue;
    private String drwNoDate;   // yyyy-mm-dd
    private long firstWinamnt;
    private int drwNo;
    private int drwtNo1;
    private int drwtNo2;
    private int drwtNo3;
    private int drwtNo4;
    private int drwtNo5;
    private int drwtNo6;
    private int bnusNo;
    private int firstPrzwnerCo;
    private long firstAccumamnt;

}
