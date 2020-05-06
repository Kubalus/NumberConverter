package recruitment.comarchRecruitmentTask.model.converter;

import org.springframework.beans.factory.annotation.Value;
import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import java.util.ArrayList;
import java.util.Arrays;

public class DECConverter extends Converter {

    public DECConverter(NumberFactory factory){
        super(NumberType.DEC, factory);
    }

    @Override
    public NumberObject convertHEX(NumberObject number) {
        int value = parseDecimal(number.getNumber());
        StringBuilder binary = new StringBuilder();
        int letter;
        while(value >= 1){
            letter = value % 16;
            binary.append(this.hexLetters[letter]);
            value /= 16;
        }
        if(binary.toString().equals(""))
            binary = new StringBuilder("0");
        return factory.getNumber(binary.reverse().toString(), NumberType.HEX);
    }

    @Override
    public NumberObject convertBIN(NumberObject number) {
        int value = parseDecimal(number.getNumber());
        StringBuilder binary = new StringBuilder();
        while(value >= 1){
            binary.append(value % 2);
            value /= 2;
        }
        if(binary.toString().equals(""))
            binary = new StringBuilder("0");
        return factory.getNumber(binary.reverse().toString(), NumberType.BIN);
    }

    @Override
    public NumberObject convertDEC(NumberObject number) {
        int test = parseDecimal(number.getNumber());
        return number;
    }

    @Override
    public NumberObject convertROM(NumberObject number) {

        StringBuilder roman = new StringBuilder();
        int arabic = parseDecimal(number.getNumber());
        if(arabic < 1 || arabic > 3999){
            throw new ApiRequestException("Roman numeral must be between 1 and 3999.");
        }
        while(arabic > 0){
            if( arabic >= 1000){
                roman.append("M");
                arabic = arabic - 1000;
            }
            else if( arabic >= 900){
                roman.append("CM");
                arabic = arabic - 900;
            }
            else if( arabic >= 500){
                roman.append("D");
                arabic = arabic - 500;
            }
            else if( arabic >= 400){
                roman.append("CD");
                arabic = arabic - 400;
            }
            else if( arabic >= 100){
                roman.append("C");
                arabic = arabic - 100;
            }
            else if( arabic >= 90){
                roman.append("XC");
                arabic = arabic - 90;
            }
            else if( arabic >= 50){
                roman.append("L");
                arabic = arabic - 50;
            }
            else if( arabic >= 40){
                roman.append("XL");
                arabic = arabic - 40;
            }
            else if( arabic >= 10){
                roman.append("X");
                arabic = arabic - 10;
            }
            else if( arabic >= 9){
                roman.append("IX");
                arabic = arabic - 9;
            }
            else if( arabic >= 5){
                roman.append("V");
                arabic = arabic - 5;
            }
            else if( arabic >= 4){
                roman.append("IV");
                arabic = arabic - 4;
            }
            else {
                roman.append("I");
                arabic = arabic - 1;
            }
        }
        return factory.getNumber(roman.toString(),NumberType.ROM);
    }

    private int parseDecimal(String decimal){
        int value;
        try{
            value = Integer.parseInt(decimal);
        }catch (NumberFormatException e){
            throw new ApiRequestException(decimal + " is not a decimal number.");
        }
        if(value < 0){
            throw new ApiRequestException("decimal number can't be smaller than 0.");
        }
        return value;
    }
}
