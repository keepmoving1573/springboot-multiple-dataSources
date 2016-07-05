package com.ptmind.ptengine.config;

import com.ptmind.ptengine.service.PtengineService;
import com.ptmind.ptengine.service.impl.PtengineServiceImpl;
import com.ptmind.ptengine.util.DatabaseContextHolder;
import com.ptmind.ptengine.util.DatabaseType;
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
    @Pointcut("execution(* com.ptmind.ptengine.service.**.*(..))")
    public void declareJointPointExpression() {
    }

    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point){
        //连接点所属的类实例是PtengineService
        if(point.getTarget() instanceof PtengineService
              || point.getTarget() instanceof PtengineServiceImpl){
            DatabaseContextHolder.setDatabaseType(DatabaseType.ptengine);
        } else{//连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            DatabaseContextHolder.setDatabaseType(DatabaseType.ptmindCommon);
        }
    }
}