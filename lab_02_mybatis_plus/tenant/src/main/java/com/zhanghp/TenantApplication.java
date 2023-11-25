package com.zhanghp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.swing.*;

/**
 * @author zhanghp
 * @since 2023/11/20 11:34
 */
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
@SpringBootApplication
public class TenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantApplication.class, args);
	}

}
