package com.mmt.web.sample.sms.context;

import com.mmt.web.sample.sms.aop.SqlInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages={"com.mmt.web.sample.sms.mapper"})
public class MybatisPlusConfig {
    @Bean
    public SqlInterceptor sqlInterceptor() {
        return new SqlInterceptor();
    }
}