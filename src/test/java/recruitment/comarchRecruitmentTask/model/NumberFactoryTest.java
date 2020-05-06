package recruitment.comarchRecruitmentTask.model;

import org.junit.jupiter.api.Test;
import recruitment.comarchRecruitmentTask.model.numbers.NumberObject;

import static org.junit.jupiter.api.Assertions.*;

class NumberFactoryTest {
    private final NumberFactory factory = new NumberFactory();

    @Test
    public void getHEXNumber(){
        NumberObject number = factory.getNumber("11",NumberType.HEX);
        assertEquals("11", number.getNumber());
        assertEquals(NumberType.HEX,number.getType());
    }

    @Test
    public void getROMNumber(){
        NumberObject number = factory.getNumber("XX",NumberType.ROM);
        assertEquals("XX", number.getNumber());
        assertEquals(NumberType.ROM,number.getType());
    }

    @Test
    public void getBINNumber(){
        NumberObject number = factory.getNumber("11",NumberType.BIN);
        assertEquals("11", number.getNumber());
        assertEquals(NumberType.BIN,number.getType());
    }

    @Test
    public void getDECNumber(){
        NumberObject number = factory.getNumber("11",NumberType.DEC);
        assertEquals("11", number.getNumber());
        assertEquals(NumberType.DEC,number.getType());
    }
}