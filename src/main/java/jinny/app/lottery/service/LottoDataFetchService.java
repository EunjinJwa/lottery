package jinny.app.lottery.service;

import java.util.ArrayList;
import java.util.List;
import jinny.app.lottery.LottoDrwNo;
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

    public List<LottoNumberResponse> fetchLottoNumbers() {
        int latestDrw = LottoDrwNo.calcLastLottoDrwNo();
        List<LottoNumberResponse> lottoNumbers = fetchLottoNumbers(latestDrw);

        return lottoNumbers;
    }

    public List<LottoNumberResponse> fetchLottoNumbers(int lastDrw) {
        List<LottoNumberResponse> results = new ArrayList<>();

        int i = FETCH_COUNT -1;
        while (i >= 0) {
            results.add(getLottoNumber(lastDrw - i));
        }

        return results;
    }

    public LottoNumberResponse getLottoNumber(int drwNo) {
        return lottoNumberWebClient.getLottoNumber(drwNo);
    }

}
