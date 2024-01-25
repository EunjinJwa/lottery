package jinny.app.lottery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberGenerateServiceTest {

    @Autowired
    private NumberGenerateService numberGenerateService;

    @Test
    public void initTest() {
        numberGenerateService.init();
    }

    @Test
    public void generateNumberTest() {
        numberGenerateService.generateNumberSet();
    }

}