package recruitment.comarchRecruitmentTask.model.converter;

import org.junit.jupiter.api.Test;
import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;
import recruitment.comarchRecruitmentTask.model.NumberFactory;
import recruitment.comarchRecruitmentTask.model.NumberType;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import static org.junit.jupiter.api.Assertions.*;

class ROMConverterTest {
    private final ROMConverter converter = new ROMConverter(new NumberFactory());

    @Test
    public void convertHEX(){
        NumberObject number = converter.factory.getNumber("XXIX", NumberType.ROM);
        NumberObject result;
        try{
            result = converter.convertHEX(number);
        }catch (ApiRequestException e){
            assertEquals("converting from ROM to HEX is not supported yet.",e.getMessage());
        }
    }

    @Test
    public void convertBIN(){
        NumberObject number = converter.factory.getNumber("XXIX", NumberType.ROM);
        NumberObject result;
        try{
            result = converter.convertBIN(number);
        }catch (ApiRequestException e){
            assertEquals("converting from ROM to BIN is not supported yet.",e.getMessage());
        }
    }

    @Test
    public void convertDEC_positive(){
        NumberObject number = converter.factory.getNumber("XXIX", NumberType.ROM);
        NumberObject result = converter.convertDEC(number);
        assertEquals("29",result.getNumber());
        assertEquals(NumberType.DEC,result.getType());
    }

    @Test
    public void convertROM_positive(){
        NumberObject number = converter.factory.getNumber("XXIX", NumberType.ROM);
        NumberObject result = converter.convertROM(number);
        assertEquals("XXIX",result.getNumber());
        assertEquals(NumberType.ROM,result.getType());
    }

    @Test
    public void convertDEC_negative(){
        NumberObject number = converter.factory.getNumber("AA",NumberType.ROM);
        NumberObject result;
        try{
            result = converter.convertDEC(number);
        }catch (ApiRequestException e){
            assertEquals("AA is not a roman number.",e.getMessage());
        }
    }

    @Test
    public void convertROM_negative(){
        NumberObject number = converter.factory.getNumber("AA",NumberType.ROM);
        NumberObject result;
        try{
            result = converter.convertROM(number);
        }catch (ApiRequestException e){
            assertEquals("AA is not a roman number.",e.getMessage());
        }
    }



}