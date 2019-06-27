package com.mmt.web.sample.sms.context;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
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

    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}