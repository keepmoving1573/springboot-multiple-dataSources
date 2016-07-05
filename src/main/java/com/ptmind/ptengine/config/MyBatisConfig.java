package com.ptmind.ptengine.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ptmind.ptengine.util.DatabaseType;
import com.ptmind.ptengine.util.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration // 该注解类似于spring配置文件
//@MapperScan(basePackages = "com.ptmind.ptengine.mapper")
//@PropertySource("classpath:application.properties")
public class MyBatisConfig implements EnvironmentAware {

    /*@Autowired
    private Environment env;*/

    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    /**
     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
     */
    @Bean
    public DataSource ptengineDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", environment.getProperty("ptengine-datasource.driverClassName"));
        props.put("url", environment.getProperty("ptengine-datasource.url"));
        props.put("username", environment.getProperty("ptengine-datasource.username"));
        props.put("password", environment.getProperty("ptengine-datasource.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public DataSource ptmindCommonDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", environment.getProperty("ptmindCommon-datasource.driverClassName"));
        props.put("url", environment.getProperty("ptmindCommon-datasource.url"));
        props.put("username", environment.getProperty("ptmindCommon-datasource.username"));
        props.put("password", environment.getProperty("ptmindCommon-datasource.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("ptengineDataSource") DataSource ptengineDataSource,
                                        @Qualifier("ptmindCommonDataSource") DataSource ptmindCommonDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.ptengine, ptengineDataSource);
        targetDataSources.put(DatabaseType.ptmindCommon, ptmindCommonDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(ptmindCommonDataSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.ptmind.ptengine.mapper");
        Properties props = new Properties();
        props.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        props.setProperty("IDENTITY", "MYSQL");
        props.setProperty("notEmpty", "true");
        scannerConfigurer.setProperties(props);
        return scannerConfigurer;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage("com.ptmind.ptengine.model");// 指定基包
        fb.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));//

        return fb.getObject();
    }



    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


}