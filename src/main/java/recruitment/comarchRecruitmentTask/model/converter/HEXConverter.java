package recruitment.comarchRecruitmentTask.model.converter;

import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;
import recruitment.comarchRecruitmentTask.model.NumberType;

public class HEXConverter extends Converter {

    public HEXConverter(NumberFactory factory){
        super(NumberType.HEX,factory);
    }


    @Override
    public NumberObject convertHEX(NumberObject number) {

        checkHex(number.getNumber());
        return number;
    }

    @Override
    public NumberObject convertBIN(NumberObject number) {
        String hex = number.getNumber();
        checkHex(hex);
        StringBuilder bin = new StringBuilder();
        int value;
        char[] array = hex.toCharArray();
        for (char letter : array){
            value = indexOf(hexLetters, String.valueOf(letter));
            bin.append(binary(value));
        }
        String result = bin.toString();
        while(result.charAt(0) == '0'){
            result = result.substring(1);
        }
        return factory.getNumber(result,NumberType.BIN);
    }

    @Override
    public NumberObject convertDEC(NumberObject number) {
        String hex = number.getNumber();
        checkHex(hex);
        int value = 0;
        char[] array = hex.toCharArray();
        for(char letter : array){
            value *= 16;
            value += indexOf(hexLetters, String.valueOf(letter));
        }
        return factory.getNumber(Integer.toString(value), NumberType.DEC);
    }

    @Override
    public NumberObject convertROM(NumberObject number) {
        throw new ApiRequestException("conversion from HEX to ROM is not supported yet.");
    }

    private void checkHex(String number){
        String hex = number;
        for(String letter : hexLetters){
            hex = hex.replaceAll(letter,"");
        }
        if(hex.length() != 0 ){
            throw new ApiRequestException(number + " is not a hexadecimal number.");
        }
    }

    private int indexOf(String[] array, String val){
        int size = array.length;
        for(int i = 0; i <size; i++){
            if(array[i].equals(val))
                return i;
        }
        return -1;
    }

    private String binary(int number){
        StringBuilder binary = new StringBuilder(Integer.toString(number, 2));
        while(binary.length() < 4){
            binary.insert(0, "0");
        }
        return binary.toString();
    }
}
