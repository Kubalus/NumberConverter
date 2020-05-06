package recruitment.comarchRecruitmentTask.model.numbers;

import recruitment.comarchRecruitmentTask.model.NumberType;

public class BINNumber extends NumberObject{
    public BINNumber(String number) {
        super(number, NumberType.BIN);
    }
}
