package Hello.example.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class TimeTraceAop {
    @Around("execution(* Hello.example.spring..s*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long time = System.currentTimeMillis();
        log.info("START: {}", joinPoint.toString());
        try{
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish -time;
            log.info("END : {} {}ms", joinPoint.toString(), timeMs);
        }
    }
}
