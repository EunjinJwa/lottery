package jinny.app.lottery.domain;

import java.util.List;
import jinny.app.lottery.webclient.LottoNumberResponse;
import lombok.Getter;

@Getter
public class LottoNumberFetchInfo {

    private int latestDrw;
    private List<LottoNumberResponse> results;

    public LottoNumberFetchInfo(int latestDrw, List<LottoNumberResponse> results) {
        this.latestDrw = latestDrw;
        this.results = results;
    }
}
