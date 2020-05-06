package recruitment.comarchRecruitmentTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recruitment.comarchRecruitmentTask.model.ConverterFactory;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.converter.Converter;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import java.util.ArrayList;

@Service

public class ConverterService {
    private ArrayList<Converter> converterList;


    ConverterService(){
        converterList = buildConverterList();
    }

    public NumberObject convert(NumberObject number, NumberType type) {

        Converter converter = findConverterByType(converterList, number.getType());
        return converter.convert(number,type);
    }


    private Converter findConverterByType(ArrayList<Converter> list, NumberType type ){
        for(Converter converter: list){
            if(converter.getType() == type)
                return converter;
        }
        return null;
    }

    private ArrayList<Converter> buildConverterList(){
        ArrayList<Converter> list = new ArrayList<>();
        NumberFactory numberFactory = new NumberFactory();
        ConverterFactory converterFactory = new ConverterFactory(numberFactory);
        for(NumberType type : NumberType.values()){
            list.add(converterFactory.getConverter(type));
        }
        return list;
    }
}
