package com.yajima.miaosha.common;

import com.google.common.base.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsMobileValidator implements ConstraintValidator<IsMobile, Long> {
    private boolean isRequired;
    @Override
    public void initialize(IsMobile isMobile) {
        isRequired = isMobile.required();
    }

    @Override
    public boolean isValid(Long s, ConstraintValidatorContext constraintValidatorContext) {
        String string = String.valueOf(s);

        if(isRequired){
            return isMobile(string);
        }else{
            if(Strings.isNullOrEmpty(string)){
                return true;
            }else{
                return isMobile(string);
            }
        }
    }

    private boolean isMobile(String s) {
        Pattern mobile_pattern = Pattern.compile("1\\d{10}");
        if(Strings.isNullOrEmpty(s)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(s);
        return m.matches();
    }
}
