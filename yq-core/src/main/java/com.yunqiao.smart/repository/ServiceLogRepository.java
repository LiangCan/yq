package com.yunqiao.smart.repository;

import com.yunqiao.smart.pojo.ServiceLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="t_service_log")
@Qualifier("serviceLogRepository")
public interface ServiceLogRepository extends CrudRepository<ServiceLog,Long> {

}
