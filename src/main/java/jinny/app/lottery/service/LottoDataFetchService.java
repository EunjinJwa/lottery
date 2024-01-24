package jinny.app.lottery.service;

import java.util.ArrayList;
import java.util.List;
import jinny.app.lottery.LottoDrwNo;
import jinny.app.lottery.domain.LottoNumberFetchInfo;
import jinny.app.lottery.webclient.LottoNumberResponse;
import jinny.app.lottery.webclient.LottoNumberWebClient;
import org.springframework.stereotype.Service;

@Service
public class LottoDataFetchService {

    private final int FETCH_COUNT = 20;

    private final LottoNumberWebClient lottoNumberWebClient;

    public LottoDataFetchService(LottoNumberWebClient lottoNumberWebClient) {
        this.lottoNumberWebClient = lottoNumberWebClient;
    }

    public LottoNumberFetchInfo fetchLottoNumbers(int fetchSize) {
        int latestDrw = LottoDrwNo.calcLastLottoDrwNo();

        return fetchLottoNumbersByDrw(latestDrw, fetchSize);
    }

    public LottoNumberFetchInfo fetchLottoNumbersByDrw(int lastDrw, int fetchSize) {
        List<LottoNumberResponse> results = new ArrayList<>();

        int i = fetchSize -1;
        while (i >= 0) {
            results.add(getLottoNumber(lastDrw - i));
        }

        return new LottoNumberFetchInfo(lastDrw, results);
    }

    public LottoNumberResponse getLottoNumber(int drwNo) {
        return lottoNumberWebClient.getLottoNumber(drwNo);
    }

}
