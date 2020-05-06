package recruitment.comarchRecruitmentTask.model.converter;

import org.junit.jupiter.api.Test;
import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.BINNumber;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import static org.junit.jupiter.api.Assertions.*;

class BINConverterTest {
    private final BINConverter converter = new BINConverter( new NumberFactory());

    @Test
    void convertHEX_positive() {
        NumberObject number = converter.factory.getNumber("11111", NumberType.BIN);
        NumberObject result = converter.convertHEX(number);
        assertEquals("1F",result.getNumber());
        assertEquals(NumberType.HEX,result.getType());
    }

    @Test
    void convertBIN_positive() {
        NumberObject number = converter.factory.getNumber("11111", NumberType.BIN);
        NumberObject result = converter.convertBIN(number);
        assertEquals("11111",result.getNumber());
        assertEquals(NumberType.BIN,result.getType());
    }

    @Test
    void convertDEC_positive() {
        NumberObject number = converter.factory.getNumber("11111", NumberType.BIN);
        NumberObject result = converter.convertDEC(number);
        assertEquals("31",result.getNumber());
        assertEquals(NumberType.DEC,result.getType());
    }

    @Test
    void convertHEX_not_a_binary(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.BIN);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a binary number.",e.getMessage());
        }
    }

    @Test
    void convertBIN_not_a_binary(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.BIN);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a binary number.",e.getMessage());
        }
    }

    @Test
    void convertDEC_not_a_binary(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.BIN);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a binary number.",e.getMessage());
        }
    }

    @Test
    void convertROM(){
        NumberObject number = converter.factory.getNumber("1111",NumberType.BIN);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("conversion from BIN to ROM is not supported yet.",e.getMessage());
        }
    }
}