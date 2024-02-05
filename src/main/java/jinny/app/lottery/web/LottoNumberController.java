package jinny.app.lottery.web;

import java.time.OffsetDateTime;
import java.util.List;
import jinny.app.lottery.domain.PickNumberSet;
import jinny.app.lottery.service.NumberGenerateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lotto")
public class LottoNumberController {

    private final NumberGenerateService numberGenerateService;

    public LottoNumberController(NumberGenerateService numberGenerateService) {
        this.numberGenerateService = numberGenerateService;
    }

    @GetMapping("")
    public String goHome() {

        return "home.html";
    }

    @GetMapping("/get")
    public @ResponseBody List<PickNumberSet> generateLottoNumbers() {

        System.out.println(OffsetDateTime.now() + " * * * * * * * * * ");
        List<PickNumberSet> pickNumberSets = numberGenerateService.generateNumberSet();

        return pickNumberSets;
    }
}
