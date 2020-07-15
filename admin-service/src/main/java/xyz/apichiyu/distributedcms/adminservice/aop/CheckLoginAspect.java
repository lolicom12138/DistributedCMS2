package xyz.apichiyu.distributedcms.adminservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import xyz.apichiyu.distributedcms.adminservice.annotation.Login;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.util.LoginAdminUtil;



/**
 * @author lolicom
 */
@Aspect
@Component
public class CheckLoginAspect {
	@Pointcut(value = "execution(public * xyz.apichiyu.distributedcms.adminservice.controller..*(..))")
	public void actions() {
	}

	@Around("actions()")
	public Object needLogin(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Login login = signature.getMethod().getAnnotation(Login.class);
		if (null != login) {
			Admin admin = LoginAdminUtil.checkLogin();
			if (null != admin) {
			    // TODO 缺少鉴权
				return pjp.proceed();
			}
		} else {
			return pjp.proceed();
		}
		return null;
	}
}
