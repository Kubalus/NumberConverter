package recruitment.comarchRecruitmentTask.model.converter;

import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

public class ROMConverter extends Converter {

    public ROMConverter(NumberFactory factory){
        super(NumberType.ROM, factory);
    }

    @Override
    public NumberObject convertHEX(NumberObject number) {

        throw new ApiRequestException("converting from ROM to HEX is not supported yet.");
    }

    @Override
    public NumberObject convertBIN(NumberObject number) {
        throw new ApiRequestException("converting from ROM to BIN is not supported yet.");
    }

    @Override
    public NumberObject convertDEC(NumberObject number) {
        String roman = number.getNumber();
        checkRoman(roman);
        int value = 0;
        char firstLetter,secondLetter;
        int size = roman.length();
        for(int i = 0; i < size; i++){
            firstLetter = roman.charAt(i);
            secondLetter = 'R';
            switch (firstLetter){
                case 'M':
                    value += 1000;
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'C':
                    if(i + 1 < size)
                        secondLetter = roman.charAt(i + 1);
                    switch (secondLetter){
                        case 'M':
                            value += 900;
                            i++;
                            break;
                        case 'D':
                            value += 400;
                            i++;
                            break;
                        default:
                            value += 100;
                    }
                    break;
                case 'X':
                    if(i + 1 < size)
                        secondLetter = roman.charAt(i + 1);
                    switch (secondLetter){
                        case 'C':
                            value += 90;
                            i++;
                            break;
                        case 'L':
                            value += 40;
                            i++;
                            break;
                        default:
                            value += 10;
                    }
                    break;
                case 'I':
                    if(i + 1 < size)
                        secondLetter = roman.charAt(i + 1);
                    switch (secondLetter){
                        case 'X':
                            value += 9;
                            i++;
                            break;
                        case 'V':
                            value += 4;
                            i++;
                            break;
                        default:
                            value += 1;
                    }
                    break;
            }
        }
        return factory.getNumber(Integer.toString(value),NumberType.DEC);
    }

    @Override
    public NumberObject convertROM(NumberObject number) {
        checkRoman(number.getNumber());
        return number;
    }

    private void checkRoman(String number){
        if(!(number.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))){
            throw new ApiRequestException(number + " is not a roman number.");
        }
    }
}
