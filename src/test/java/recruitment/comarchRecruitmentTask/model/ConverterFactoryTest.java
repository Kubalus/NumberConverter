package recruitment.comarchRecruitmentTask.model;

import org.junit.jupiter.api.Test;
import recruitment.comarchRecruitmentTask.model.converter.Converter;

import static org.junit.jupiter.api.Assertions.*;

class ConverterFactoryTest {

    private final ConverterFactory factory = new ConverterFactory(new NumberFactory());

    @Test
    public void getBINFactory(){
        Converter converter = factory.getConverter(NumberType.BIN);
        assertEquals(NumberType.BIN, converter.getType());
    }

    @Test
    public void getROMFactory(){
        Converter converter = factory.getConverter(NumberType.ROM);
        assertEquals(NumberType.ROM, converter.getType());
    }

    @Test
    public void getHEXFactory(){
        Converter converter = factory.getConverter(NumberType.HEX);
        assertEquals(NumberType.HEX, converter.getType());
    }

    @Test
    public void getDECFactory(){
        Converter converter = factory.getConverter(NumberType.DEC);
        assertEquals(NumberType.DEC, converter.getType());
    }

}