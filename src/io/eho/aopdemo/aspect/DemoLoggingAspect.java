package io.eho.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	@Pointcut("execution(* io.eho.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// pointcut for getters
	@Pointcut("execution(* io.eho.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// pointcut for setters
	@Pointcut("execution(* io.eho.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// pointcut to combine: include package / exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing Api analytics");
	}

}
