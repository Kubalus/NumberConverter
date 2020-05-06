package recruitment.comarchRecruitmentTask.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.converter.*;

public class ConverterFactory {

    public final NumberFactory factory;

    public ConverterFactory(NumberFactory factory) {
        this.factory = factory;
    }

    public Converter getConverter(NumberType type){
        if(type == NumberType.HEX)
            return new HEXConverter(factory);

        if(type == NumberType.BIN){
            return new BINConverter(factory);
        }
        if(type == NumberType.DEC){
            return new DECConverter(factory);
        }
        if(type == NumberType.ROM){
            return new ROMConverter(factory);
        }
        return null;
    }
}
