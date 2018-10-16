
package com.example.demo.aspect;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HttpServletBean;

/**
 * Created by wangmeng on 2017/12/26.
 */
@Aspect
@Component //引入到spring容器中
public class HttpAspect {

    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    /*@Before("execution(public * com.example.demo.controller.GrelController.grilList(..))")替换为*/
    @Pointcut("execution(public * com.example.demo.controller.GrelController.grilList(..))")/*要切哪个点*/
    public void log(){
    }

    @Before("log()")
    public void  doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        javax.servlet.http.HttpServletRequest request = (HttpServletRequest) attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURI());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    @After("log()")
    public void  doAfter(){
        logger.info("33333333333333333");
    }

    @AfterReturning(returning ="object",pointcut = "log()")
    public void doAfterReturn(Object object){
        logger.info("response={}",object.toString());
    }



}
