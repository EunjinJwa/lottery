package jinny.app.lottery.web;

import java.time.OffsetDateTime;
import java.util.List;
import jinny.app.lottery.domain.PickNumberSet;
import jinny.app.lottery.service.NumberGenerateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/lotto")
public class LottoNumberController {

    private final NumberGenerateService numberGenerateService;

    public LottoNumberController(NumberGenerateService numberGenerateService) {
        this.numberGenerateService = numberGenerateService;
    }

    @GetMapping("/get")
    public String generateLottoNumbers(
        @RequestParam(defaultValue = "kevin") String requester,
        Model model) {

        System.out.println(OffsetDateTime.now() + " * * * * * * * * * " + requester);
        List<PickNumberSet> pickNumberSets = numberGenerateService.generateNumberSet();
        model.addAttribute("result", pickNumberSets);

        return "home";
    }
}
