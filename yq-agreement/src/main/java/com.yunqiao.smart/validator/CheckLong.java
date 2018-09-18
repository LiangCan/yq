package com.yunqiao.smart.validator;

import com.yunqiao.smart.Constants;
import com.yunqiao.smart.validator.impl.CheckLongValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2018/5/15 0015.
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckLongValidator.class)
@Documented
public @interface CheckLong {
    String message() default Constants.systemError.PARAM_VALUE_LENGTH;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 0;

    int max() default 2147483647;


}
