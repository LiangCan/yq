package com.yunqiao.smart.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/7 0007.
 */
@RefreshScope
@Component
public class AuthFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Value("${diy.redis.prefix.appssid}")
    private String REDIS_APPSSID;


    //过滤的目录，静态的
    private static List<String> fileStatic;

    static {
        fileStatic = new ArrayList<>();
        fileStatic.add("swagger");
        fileStatic.add("v2");
        fileStatic.add("upload");
    }

    @Override
    public Object run() {
        log.debug(REDIS_APPSSID);
        return null;
    }

//    public void checkPram(){
//        ReqBaseDTO reqBaseDTO = null;
//        InputStream is = null;
//        String reqData = null;
//        RequestContext ctx = null;
//        try {
//            ctx = RequestContext.getCurrentContext();
//            HttpServletRequest request = ctx.getRequest();
//            is = request.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
//            String line = null;
//            StringBuilder sb = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                sb.append(line);
//            }
//            reqData = sb.toString();
//            reqBaseDTO = GsonUtils.toObj(reqData, ReqBaseDTO.class);
//            //校验参数
//            ValidatorUtils.validata(reqBaseDTO);
//        } catch (CustomRunTimeException c) {
//            log.error( c.getErrorMsg() + " : " + reqData);
//            resultData(ctx, GsonUtils.toJSON(new ResponseDTO(Constants.resultCode.PARAM_VALUE_INVALID, c.getErrorMsg(), APP_UP_RUL_ALL)));
//        } catch (Exception e) {
//            e.printStackTrace();
//            //返回主协议错误
//            resultData(ctx, GsonUtils.toJSON(new ResponseDTO(Constants.resultCode.PARAM_VALUE_INVALID, Constants.systemError.PARAM_VALUE_INVALID, new Object[]{"main"}, APP_UP_RUL_ALL)));
//        }
//    }
//
//
//    public boolean gl(String reqIul) {
//        for (String iul : fileStatic) {
//            if (reqIul.indexOf(iul) > -1) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 获取升级的URL
//     *
//     * @param os
//     * @return
//     */
//    public String getUpUrl(Short os) {
//        String appUpUrl = APP_UP_RUL_ALL;
//        if (os == 4) {
//            appUpUrl = APP_UP_URL_IOS;
//        } else if (os == 3) {
//            appUpUrl = APP_UP_URL_ANDROID;
//        }
//        return appUpUrl;
//    }
//
//
//    /**
//     * 200 直接返回数据
//     */
//    public static void resultData(RequestContext rcx, String data) {
//        try {
//            rcx.setSendZuulResponse(false);
//            rcx.setResponseStatusCode(200);
//            HttpServletResponse httpServletResponse = rcx.getResponse();
//            httpServletResponse.setCharacterEncoding(Constants.CHARSET);
//            httpServletResponse.setContentType("application/json");
//            httpServletResponse.getWriter().write(data);
//        } catch (Exception e) {
//            log.error(" is re Error：" + data);
//        }
//    }


    /**
     * pre：进行路由前调用；
     * routing：进行路由的时候调用；
     * error：发生错误时调用；
     * post：routing&error之后调用；
     **/
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
