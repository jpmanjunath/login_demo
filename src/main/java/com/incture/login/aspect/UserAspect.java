package com.incture.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class UserAspect {


		@AfterReturning(value = "execution(* com.incture.login.controller.UserController.getAllUsers())", returning = "account")
		public void afterReturningAdvice(JoinPoint joinPoint) {
			log.info("After Returing method:" + joinPoint.getSignature());
		}

		@AfterThrowing(value = "execution(* com.incture.login.controller.UserController.getAllUsers())", throwing = "ex")
		public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
			log.info("After Throwing exception in method:" + joinPoint.getSignature());
			log.info("Exception is:" + ex.getMessage());
		}
		
		@Before(value = "execution(* com.incture.login.controller.UserController.getAllUsers())")
		public void beforeAdvice(JoinPoint joinPoint) {
			log.info("Before method:" + joinPoint.getSignature());
		}

		@Around(value = "execution(* com.incture.login.controller.UserController.getAllUsers())")
		public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
			log.info("Around  method  at the begining:" + joinPoint.getSignature());
			var obj= joinPoint.proceed();
			log.info("Around  method  at the end:" + joinPoint.getSignature());
			return obj;
		}
		@After(value = "execution(* com.incture.login.controller.UserController.getAllUsers())")
		public void afterAdvice(JoinPoint joinPoint) {
			log.info("After method:" + joinPoint.getSignature());
		}
}
