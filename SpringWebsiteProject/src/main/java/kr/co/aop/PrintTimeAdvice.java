package kr.co.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintTimeAdvice {
	
	@Around("execution(* kr.co.service.TestService*.*(..))")
	public Object printTime(ProceedingJoinPoint pjp) throws Throwable{
		
		Object[] arr = pjp.getArgs();
		System.out.println(":::::::::::::::");
		for(Object x : arr) {
			System.out.println(x);
		}
		System.out.println(":::::::::::::::");
		
		
		
		long bt = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		long at = System.currentTimeMillis();
		System.out.println("Time: "+ (at-bt));
		
		return result;
		
	}

}
