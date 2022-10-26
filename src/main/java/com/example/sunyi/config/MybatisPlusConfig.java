package com.example.sunyi.config;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * mybatisplus配置类,需要@Configuration和@MapperScan注解:
 * @Configuration表示springboot将其视为配置类
 * @MapperScan包括所有使用mybatis框架的mapper操作数据库映射接口所在包
 */
@Configuration
@MapperScan("com.example.sunyi.mapper")
public class MybatisPlusConfig {

    /**
     * 此为mybatis+插件(虽然看上去声明的像一个拦截器)
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}