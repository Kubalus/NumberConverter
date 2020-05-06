package recruitment.comarchRecruitmentTask.model.numbers;

import recruitment.comarchRecruitmentTask.model.NumberType;

public abstract class NumberObject {
    private String number;
    private NumberType type;

    public NumberObject( String number, NumberType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public NumberType getType() {
        return type;
    }

}
