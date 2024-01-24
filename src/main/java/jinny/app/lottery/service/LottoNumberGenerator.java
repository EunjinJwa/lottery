package jinny.app.lottery.service;

import java.util.List;
import jinny.app.lottery.webclient.LottoNumberResponse;
import org.springframework.stereotype.Service;

@Service
public class LottoNumberGenerator {
    private final LottoDataFetchService lottoDataFetchService;

    public LottoNumberGenerator(LottoDataFetchService lottoDataFetchService) {
        this.lottoDataFetchService = lottoDataFetchService;
    }

    public void test() {
        List<LottoNumberResponse> lottoNumberResponses = lottoDataFetchService.fetchLottoNumbers();
    }


}
