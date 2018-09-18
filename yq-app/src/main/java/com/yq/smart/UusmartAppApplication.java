package com.yq.smart;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableHystrix
@EnableFeignClients
@Import(FdfsClientConfig.class)
@EnableScheduling
public class UusmartAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(UusmartAppApplication.class, args);

	}
}
