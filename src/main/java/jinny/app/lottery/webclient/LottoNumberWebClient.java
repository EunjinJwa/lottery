package jinny.app.lottery.webclient;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LottoNumberWebClient {
    private final static String URL = "https://www.dhlottery.co.kr";

    public LottoNumberResponse getLottoNumber(int drwNo) {
        WebClient webClient = WebClient.create(URL);

        String responseBody = webClient.get()
            .uri(uriBuilder -> uriBuilder.path("/common.do")
                .queryParam("method", "getLottoNumber")
                .queryParam("drwNo", drwNo)
                .build()
            ).retrieve()
            .bodyToMono(String.class)
            .block();

        Gson gson = new Gson();
        LottoNumberResponse result = gson.fromJson(responseBody, LottoNumberResponse.class);

        return result;
    }



}
