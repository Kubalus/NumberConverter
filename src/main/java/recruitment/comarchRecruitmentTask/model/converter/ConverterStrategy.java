package recruitment.comarchRecruitmentTask.model.converter;

import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

public interface ConverterStrategy{


     NumberObject convertHEX(NumberObject number);
     NumberObject convertBIN(NumberObject number);
     NumberObject convertDEC(NumberObject number);
     NumberObject convertROM(NumberObject number);
}
