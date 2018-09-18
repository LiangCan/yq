package com.yunqiao.smart.exception;


import com.yunqiao.smart.Constants;
import com.yunqiao.smart.http.dto.ResponseDTO;
import com.yunqiao.smart.http.logserver.ServiceLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice(basePackages={"com.yq.smart.controller"})
public class GlobalExceptionHandler{
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseDTO httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletResponse response){
        ResponseDTO responseDTO = new ResponseDTO(Constants.resultCode.PARAM_FORMAT_ERROR,Constants.systemError.PARAM_FORMAT_ERROR, new Object[] {"json"});
        return responseDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseDTO methodArgumentNotValidException(MethodArgumentNotValidException e,  HttpServletResponse response){
        ResponseDTO responseDTO = new ResponseDTO(Constants.resultCode.PARAM_VALUE_INVALID,Constants.systemError.PARAM_VALUE_INVALID, new Object[] {"main"});
        return responseDTO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseDTO exceptionHandler(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        ResponseDTO responseDTO = new ResponseDTO(Constants.resultCode.SYSTEM_ERROR, Constants.systemError.SYSTEM_ERROR);
        return responseDTO;
    }

    @ExceptionHandler(CustomRunTimeException.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseDTO exceptionHandler(CustomRunTimeException e, HttpServletResponse response) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.sethRA(e.getErrorCode());
        responseDTO.sethRD(e.getErrorMsg());
        responseDTO.sethRC("");
//        saveSerLog(responseDTO);
        return responseDTO;
    }

    @Autowired
    ServiceLogService serviceLogService;



}
