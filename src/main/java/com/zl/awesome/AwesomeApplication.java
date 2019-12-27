package com.zl.awesome;

import com.alibaba.druid.pool.DruidDataSource;
import com.zl.awesome.config.HttpPortCfg;
import com.zl.awesome.config.NettyServerConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author ZL
 */
@SpringBootApplication
@MapperScan("com.zl.awesome.dao")
// 如果要扫描多个，用下面这种写法
//@MapperScan(basePackages={"com.boot.placms.mapper", "com.boot.placms.dao"})
public class AwesomeApplication {
    @Resource
    private HttpPortCfg httpPortCfg;

    @Resource
    private NettyServerConfig nettyConfig;

	public static void main(String[] args) {
		SpringApplication.run(AwesomeApplication.class, args);
	}

    // datasource注入
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    //mybatis SQLSession注入
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    //事务支持
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}

