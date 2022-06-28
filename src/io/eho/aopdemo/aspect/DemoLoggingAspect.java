package io.eho.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.eho.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
	
	@Before("io.eho.aopdemo.aspect.ShareAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		
		// display the method arguments
			// 1 get args
		Object[] args = joinPoint.getArgs();
		
			// 2 loop thru args
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
				
			}
		}
	}

}
