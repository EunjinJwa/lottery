package jinny.app.lottery.service;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jinny.app.lottery.domain.LottoNumberFetchInfo;
import jinny.app.lottery.domain.NumberGenerator;
import jinny.app.lottery.domain.NumberStats;
import jinny.app.lottery.domain.PickNumberSet;
import jinny.app.lottery.webclient.LottoNumberResponse;
import org.springframework.stereotype.Service;

@Service
public class NumberGenerateService {

    private static Gson gson = new Gson();
    private final int FETCH_COUNT = 20;

    private final LottoDataFetchService lottoDataFetchService;

    public NumberGenerateService(LottoDataFetchService lottoDataFetchService) {
        this.lottoDataFetchService = lottoDataFetchService;
        init();
    }

    public void init() {
        LottoNumberFetchInfo lottoNumberFetchInfo = lottoDataFetchService.fetchLottoNumbers(FETCH_COUNT);
        NumberStats numberStats = new NumberStats(lottoNumberFetchInfo.getLatestDrw(), lottoNumberFetchInfo.getResults().size());

        List<LottoNumberResponse> results = lottoNumberFetchInfo.getResults();
        results.stream().forEach(item -> numberStats.addNumStats(item));

        new NumberGenerator(numberStats);
    }

    public List<PickNumberSet> generateNumberSet() {
        List<PickNumberSet> pickNumbers = new ArrayList<>();
        pickNumbers.add(new PickNumberSet(1, NumberGenerator.genNumbersByAlorithm1()));
        pickNumbers.add(new PickNumberSet(2, NumberGenerator.genNumbersByAlorithm2()));
        pickNumbers.add(new PickNumberSet(3, NumberGenerator.genNumbersByAlorithm2()));
        pickNumbers.add(new PickNumberSet(4, NumberGenerator.genNumbersByAlorithm1()));
        pickNumbers.add(new PickNumberSet(5, NumberGenerator.genNumbersByAlorithm1()));

        return pickNumbers;
    }

}
