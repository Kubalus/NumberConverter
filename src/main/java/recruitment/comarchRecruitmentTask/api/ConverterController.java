package recruitment.comarchRecruitmentTask.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recruitment.comarchRecruitmentTask.model.ConvertRequest;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;
import recruitment.comarchRecruitmentTask.service.ConverterService;

@RequestMapping("api/converter")
@RestController
public class ConverterController {
    private final NumberFactory factory;
    private final ConverterService converterService;

    @Autowired
    public ConverterController(ConverterService converterService, NumberFactory factory) {
        this.converterService = converterService;
        this.factory = factory;
    }

    @GetMapping
    public NumberObject convert(@RequestBody ConvertRequest request){
        return converterService.convert(factory.getNumber(request.getNumberValue(), request.getNumberType()),
                                request.getConversionType());
    }
}
