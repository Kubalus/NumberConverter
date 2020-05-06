package recruitment.comarchRecruitmentTask.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import recruitment.comarchRecruitmentTask.api.exception.ApiRequestException;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class ConvertRequest {
    private String numberValue;
    private NumberType numberType;
    private NumberType conversionType;


    public String getNumberValue() {
        return numberValue;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public NumberType getConversionType() {
        return conversionType;
    }

    public ConvertRequest(@JsonProperty("numberValue")  String number,
                          @JsonProperty("numberType")  String numberType,
                          @JsonProperty("conversionType")  String conversionType){

        if(number == null)
            throw new ApiRequestException(("JSON field : numberValue can't be empty."));
        if(numberType == null)
            throw new ApiRequestException(("JSON field : numberType can't be empty."));
        if(conversionType == null)
            throw new ApiRequestException(("JSON field : conversionType can't be empty."));

        this.numberValue = number;

        try{
            this.numberType = NumberType.valueOf(numberType);
        }catch (IllegalArgumentException e){
            System.out.println(e.getClass().getName() + "  " + e.getMessage());
            throw new ApiRequestException(numberType + " is not a legal type. Choose from : " + Arrays.toString(NumberType.values()));
        }

        try{
            this.conversionType = NumberType.valueOf(conversionType);
        }catch (IllegalArgumentException e){
            throw new ApiRequestException(conversionType + " is not a legal type. Choose from : "
                    + Arrays.toString(NumberType.values()));
        }

    }
}

