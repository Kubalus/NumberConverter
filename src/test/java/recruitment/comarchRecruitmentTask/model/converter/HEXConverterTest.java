package recruitment.comarchRecruitmentTask.model.converter;

import org.junit.jupiter.api.Test;
import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import static org.junit.jupiter.api.Assertions.*;

class HEXConverterTest {
    private final HEXConverter converter = new HEXConverter( new NumberFactory());

    @Test
    void convertHEX_positive() {
        NumberObject number = converter.factory.getNumber("FF", NumberType.HEX);
        NumberObject result = converter.convertHEX(number);
        assertEquals("FF",result.getNumber());
        assertEquals(NumberType.HEX,result.getType());
    }

    @Test
    void convertBIN_positive() {
        NumberObject number = converter.factory.getNumber("FF", NumberType.HEX);
        NumberObject result = converter.convertBIN(number);
        assertEquals("11111111",result.getNumber());
        assertEquals(NumberType.BIN,result.getType());
    }

    @Test
    void convertDEC_positive() {
        NumberObject number = converter.factory.getNumber("FF", NumberType.HEX);
        NumberObject result = converter.convertDEC(number);
        assertEquals("255",result.getNumber());
        assertEquals(NumberType.DEC,result.getType());
    }

    @Test
    void convertHEX_not_a_hex(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.HEX);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a hexadecimal number.",e.getMessage());
        }
    }

    @Test
    void convertBIN_not_a_hex(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.HEX);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a hexadecimal number.",e.getMessage());
        }
    }

    @Test
    void convertDEC_not_a_hex(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.HEX);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a hexadecimal number.",e.getMessage());
        }
    }

    @Test
    void convertROM(){
        NumberObject number = converter.factory.getNumber("AA",NumberType.HEX);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("conversion from HEX to ROM is not supported yet.",e.getMessage());
        }
    }

}