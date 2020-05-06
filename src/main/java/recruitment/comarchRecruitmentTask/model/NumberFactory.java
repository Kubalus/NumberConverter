package recruitment.comarchRecruitmentTask.model;


import org.springframework.stereotype.Component;
import recruitment.comarchRecruitmentTask.model.numbers.*;

@Component
public class NumberFactory {

    public NumberObject getNumber(String value, NumberType type){

        if(type == NumberType.HEX)
            return new HEXNumber(value);

        if(type == NumberType.BIN){
            return new BINNumber(value);
        }
        if(type == NumberType.DEC){
            return new DECNumber(value);
        }
        if(type == NumberType.ROM){
            return new ROMNumber(value);
        }
        // TODO: przesyłanie błędów gdy typ się nie zgadza
        return null;
    }
}
