package recruitment.comarchRecruitmentTask.model.converter;

import org.junit.jupiter.api.Test;
import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import static org.junit.jupiter.api.Assertions.*;

class DECConverterTest {
    private final DECConverter converter = new DECConverter(new NumberFactory());

    @Test
    void convertHEX_positive() {
        NumberObject number = converter.factory.getNumber("32", NumberType.DEC);
        NumberObject result = converter.convertHEX(number);
        assertEquals("20",result.getNumber());
        assertEquals(NumberType.HEX,result.getType());
    }

    @Test
    void convertBIN_positive() {
        NumberObject number = converter.factory.getNumber("32", NumberType.DEC);
        NumberObject result = converter.convertBIN(number);
        assertEquals("100000",result.getNumber());
        assertEquals(NumberType.BIN,result.getType());
    }

    @Test
    void convertDEC_positive() {
        NumberObject number = converter.factory.getNumber("32", NumberType.DEC);
        NumberObject result = converter.convertDEC(number);
        assertEquals("32",result.getNumber());
        assertEquals(NumberType.DEC,result.getType());
    }

    @Test
    void convertROM_positive(){
        NumberObject number = converter.factory.getNumber("32", NumberType.DEC);
        NumberObject result = converter.convertROM(number);
        assertEquals("XXXII",result.getNumber());
        assertEquals(NumberType.ROM,result.getType());
    }

    @Test
    void convertHEX_not_a_decimal(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a decimal number.",e.getMessage());
        }
    }

    @Test
    void convertBIN_not_a_decimal(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a decimal number.",e.getMessage());
        }
    }

    @Test
    void convertDEC_not_a_decimal(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a decimal number.",e.getMessage());
        }
    }

    @Test
    void convertROM_not_a_decimal(){
        NumberObject number = converter.factory.getNumber("123AR", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("123AR is not a decimal number.",e.getMessage());
        }
    }

    @Test
    void convertHEX_smaller_than_0(){
        NumberObject number = converter.factory.getNumber("-12", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("decimal number can't be smaller than 0.",e.getMessage());
        }
    }

    @Test
    void convertBIN_smaller_than_0(){
        NumberObject number = converter.factory.getNumber("-12", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("decimal number can't be smaller than 0.",e.getMessage());
        }
    }

    @Test
    void convertDEC_smaller_than_0(){
        NumberObject number = converter.factory.getNumber("-12", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("decimal number can't be smaller than 0.",e.getMessage());
        }
    }

    @Test
    void convertROM_smaller_than_0(){
        NumberObject number = converter.factory.getNumber("-12", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("decimal number can't be smaller than 0.",e.getMessage());
        }
    }

    @Test
    void convertROM_range1(){
        NumberObject number = converter.factory.getNumber("5000", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("Roman numeral must be between 1 and 3999.",e.getMessage());
        }
    }

    @Test
    void convertROM_range2(){
        NumberObject number = converter.factory.getNumber("0", NumberType.DEC);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("Roman numeral must be between 1 and 3999.",e.getMessage());
        }
    }
}