package demo.web.crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* demo.web.crm.controller.*.*(..))")
	private void forControllerPackage() {
	};

	@Pointcut("execution(* demo.web.crm.dao.*.*(..))")
	private void forDAOPackage() {
	};

	@Pointcut("execution(* demo.web.crm.service.*.*(..))")
	private void forServicePackage() {
	};

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	};

	// add @Before advice
	@Before("forAppFlow()")
	public void beforeAppFlowAdvice(JoinPoint joinPoint) {
		logger.info("=====> Aspect @Before in method: "+joinPoint.getSignature().toShortString());
		Object args[] = joinPoint.getArgs();
		StringBuilder stringBuilder = new StringBuilder("====> args: ");
		for(Object t:args) {
			stringBuilder.append(t+ "\t");
		}
		logger.info(stringBuilder.toString());
	}
	
	
	// add @AfterReturning advice

}
