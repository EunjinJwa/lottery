package jinny.app.lottery.web;

import java.util.List;
import jinny.app.lottery.domain.PickNumberSet;
import jinny.app.lottery.service.NumberGenerateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/lotto")
public class LottoNumberController {

    private final NumberGenerateService numberGenerateService;

    public LottoNumberController(NumberGenerateService numberGenerateService) {
        this.numberGenerateService = numberGenerateService;
    }

    @GetMapping("/get")
    public String generateLottoNumbers(Model model) {

        List<PickNumberSet> pickNumberSets = numberGenerateService.generateNumberSet();
        System.out.println(pickNumberSets);
        model.addAttribute("result", pickNumberSets);

        return "home";
    }
}
