package com.yq.smart.controller;


import com.yunqiao.smart.Constants;
import com.yunqiao.smart.ResultCodeEnum;
import com.yunqiao.smart.exception.CustomRunTimeException;
import com.yunqiao.smart.validator.ValidatorUtils;
import org.springframework.validation.BindingResult;


public class BaseController extends ValidatorUtils {

    public static void validataBind(BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new CustomRunTimeException(ResultCodeEnum.PARAM_VALUE_INVALID, bindingResult.getFieldError().getDefaultMessage(), new Object[]{bindingResult.getFieldError().getField()});
        }
    }

    public static <T> void validataBind(BindingResult bindingResult, T t){
        if (bindingResult.hasErrors()) {
            throw new CustomRunTimeException(ResultCodeEnum.PARAM_VALUE_INVALID, bindingResult.getFieldError().getDefaultMessage(), new Object[]{bindingResult.getFieldError().getField()});
        }

        CustomRunTimeException.checkNull(t,"hG");
    }

}
