package recruitment.comarchRecruitmentTask.model.converter;

import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

public class BINConverter extends Converter {

    public BINConverter(NumberFactory factory){
        super(NumberType.BIN, factory);
    }

    @Override
    public NumberObject convertHEX(NumberObject number) {
        String binary = number.getNumber();
        checkBinary(binary);
        StringBuilder hex = new StringBuilder();
        while(binary.length() >0){
            if(binary.length() <= 4){
                int position = Integer.parseInt(binary,2);
                hex.append(hexLetters[position]);
                binary = "";
            }
            else {
                String part = binary.substring(binary.length()- 4);
                int position = Integer.parseInt(part,2);
                hex.append(hexLetters[position]);
                binary = binary.substring(0,binary.length() - 4);
            }
        }
        return factory.getNumber(hex.reverse().toString(),NumberType.HEX);
    }

    @Override
    public NumberObject convertBIN(NumberObject number) {
        return number;
    }

    @Override
    public NumberObject convertDEC(NumberObject number) {
        String binary = number.getNumber();
        checkBinary(binary);
        int value = 0;
        char[] array = binary.toCharArray();
        for(char Char : array){
            value *= 2;
            if(Char == '1')
                value +=1;
        }
        return factory.getNumber(Integer.toString(value),NumberType.DEC);

    }

    @Override
    public NumberObject convertROM(NumberObject number) {
        throw new ApiRequestException("conversion from BIN to ROM is not supported yet.");
    }

    private void checkBinary(String number){
        String binary = number;
        binary = binary.replaceAll("0","");
        binary = binary.replaceAll("1","");
        if(binary.length() != 0)
                throw new ApiRequestException(number + " is not a binary number.");
    }
}
