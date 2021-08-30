package fr.formation.epicerievracprojet.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	@AfterThrowing(pointcut = "execution(* fr.formation.epicerievracprojet.services.*.*(..))", throwing = "e")
	public void exceptionLog(JoinPoint jp, Exception e) {
		System.err.println("LoggerAspect.exceptionLog() called on method " + jp.getSignature().getName());
		System.err.println("Exception type : " + e.getClass());
		System.err.println("Exception message : " + e.getMessage());
	}
	
}
