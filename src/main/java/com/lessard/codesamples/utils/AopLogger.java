package com.lessard.codesamples.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * Created by fdlessard on 16-08-07.
 */

@Component
@Aspect
public class AopLogger {

    @Around("execution(* com.lessard.codesamples..*.*(..))")
    public Object timeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object retVal = joinPoint.proceed();

        stopWatch.stop();

        StringBuffer logMessageStringBuffer = new StringBuffer();
        logMessageStringBuffer.append(joinPoint.getTarget().getClass().getSimpleName());
        logMessageStringBuffer.append(".");
        logMessageStringBuffer.append(joinPoint.getSignature().getName());
        logMessageStringBuffer.append("(");

        Object[] signatureArgs = joinPoint.getArgs();

        String argListStr = StringUtils.join(signatureArgs, ", ");

        logMessageStringBuffer.append(argListStr);
        logMessageStringBuffer.append(") - ");

        logMessageStringBuffer.append(" Execution time: ");
        logMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
        logMessageStringBuffer.append(" ms");

        Logger.getLogger(this.getClass()).info(logMessageStringBuffer.toString());

        return retVal;
    }

}
