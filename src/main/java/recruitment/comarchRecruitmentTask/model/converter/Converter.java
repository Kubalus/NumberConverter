package recruitment.comarchRecruitmentTask.model.converter;

import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

public abstract class Converter implements ConverterStrategy {
    NumberFactory factory;
    private NumberType type;
    protected String[] hexLetters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    Converter(NumberType type, NumberFactory factory){
        this.type = type;
        this.factory = factory;
    }

    // type - na jaka liczbe konwertujemy
    public NumberObject convert (NumberObject number, NumberType type){

        if(type == NumberType.DEC)
            return convertDEC(number);
        if(type == NumberType.BIN)
            return convertBIN(number);
        if(type == NumberType.ROM)
            return convertROM(number);
        if(type == NumberType.HEX)
            return convertHEX(number);
        //TODO: obsługa złego typu
        return null;
    }

    public NumberType getType() {
        return type;
    }
}
