package io.eho.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ShareAOPExpressions {
	
	@Pointcut("execution(* io.eho.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// pointcut-declaration for getters
	@Pointcut("execution(* io.eho.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// pointcut-declaration for setters
	@Pointcut("execution(* io.eho.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// pointcut-declaration to combine: include package / exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
