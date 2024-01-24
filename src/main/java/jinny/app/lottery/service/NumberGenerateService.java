package jinny.app.lottery.service;

import jinny.app.lottery.domain.LottoNumberFetchInfo;
import org.springframework.stereotype.Service;

@Service
public class NumberGenerateService {

    private final int FETCH_COUNT = 20;

    private final LottoDataFetchService lottoDataFetchService;

    public NumberGenerateService(LottoDataFetchService lottoDataFetchService) {
        this.lottoDataFetchService = lottoDataFetchService;
    }

    public void init() {
        LottoNumberFetchInfo lottoNumberFetchInfo = lottoDataFetchService.fetchLottoNumbers(FETCH_COUNT);


    }


}
