package com.yunqiao.smart.http.logserver;


import com.yunqiao.smart.pojo.ServiceLog;

/**
 * Created by Liang on 2016/12/23.
 */
public interface ServiceLogService {
    /** API 添加 or 修改 日志服务*/
    void addServiceLog(ServiceLog serviceLog);

}
