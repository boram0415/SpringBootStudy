package hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
* AOP ( Aspect Oriented Programming )
* 쉽게 말해 어떤 로직을 기준으로 핵심 기능과 부가기능으로 나누고
* 그 관점을 기준으로 각각을 모듈화 하는 것
* */
@Aspect
@Component
/*AOP 사용 시 component scan 으로 spring 에 Bean 등록도 가능하지만 특별한 case 이므로
* Config 에 별도 등록해놓는 것이 좋다 */
public class TimeTraceAop {
    @Around("execution(* hello.hellospring.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint )throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally{
            long end = System.currentTimeMillis();
            long timeMs = end - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs  + "ms");
        }
    }
}
