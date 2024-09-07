package com.vehiclechatserver;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.vehiclechatserver.utils.SpringContextUtils;

@SpringBootApplication
public class VehiclechatserverApplication implements ApplicationContextAware {
	public static void main(String[] args) {
		SpringApplication.run(VehiclechatserverApplication.class, args);
	}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.setApplicationContext(applicationContext);
    }
}
