package jinny.app.lottery.webclient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoNumberWebClientTest {

    @Test
    void getLottoNumber() {

        LottoNumberWebClient client = new LottoNumberWebClient();
        client.getLottoNumber(1103);

    }
}