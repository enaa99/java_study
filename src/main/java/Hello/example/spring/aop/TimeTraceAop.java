package Hello.example.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {
    @Around("execution(* Hello.example.spring..s*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long time = System.currentTimeMillis();
        System.out.println("START : " +joinPoint.toString());
        try{
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish -time;
            System.out.println("END : "+ joinPoint.toString() + timeMs+"ms");
            System.out.println(timeMs);
        }
    }
}
