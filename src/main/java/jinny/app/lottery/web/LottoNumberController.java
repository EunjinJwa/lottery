package jinny.app.lottery.web;

import java.util.List;
import jinny.app.lottery.domain.PickNumberSet;
import jinny.app.lottery.service.NumberGenerateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lotto")
public class LottoNumberController {

    private final NumberGenerateService numberGenerateService;

    public LottoNumberController(NumberGenerateService numberGenerateService) {
        this.numberGenerateService = numberGenerateService;
    }

    @GetMapping("/get")
    public List<PickNumberSet> generateLottoNumbers() {
        return numberGenerateService.generateNumberSet();
    }
}
