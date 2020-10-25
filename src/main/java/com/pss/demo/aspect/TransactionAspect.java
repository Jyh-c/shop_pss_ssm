package com.pss.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/28 22:40
 */
@Aspect
@Component
public class TransactionAspect {

    @Around("execution(* com.pss.demo.service.impl.*.*(..))")
    @Transactional(rollbackFor=Exception.class)
    public Object transactionAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("开启事务");
        Object object;
        try {
            object = joinPoint.proceed();
            System.out.println("关闭事务");
        } catch (Throwable throwable) {
            System.out.println("回滚");
            object = throwable;
            throwable.printStackTrace();
        }
        return object;
    }

    @Autowired
    private DataSourceTransactionManager dstManager;

}
