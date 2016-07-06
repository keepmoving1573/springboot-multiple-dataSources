package com.huan.config;

import com.huan.service.Test1Service;
import com.huan.service.impl.Test1ServiceImpl;
import com.huan.util.DatabaseContextHolder;
import com.huan.util.DatabaseType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.huan.service.**.*(..))")
    public void declareJointPointExpression() {
    }

    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point){
        //根据连接点所属的类实例，动态切换数据源
        if (point.getTarget() instanceof Test1Service
                || point.getTarget() instanceof Test1ServiceImpl) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.test1);
        } else {//连接点所属的类实例是（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            DatabaseContextHolder.setDatabaseType(DatabaseType.test2);
        }
    }
}