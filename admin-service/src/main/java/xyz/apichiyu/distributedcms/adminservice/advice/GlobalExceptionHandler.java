package xyz.apichiyu.distributedcms.adminservice.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import xyz.apichiyu.distributedcms.adminservice.dto.result.Result;

/**
 * @author lolicom
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Result exceptionHandler(Exception e){
		return Result.fail(e.getMessage());
	}
}
