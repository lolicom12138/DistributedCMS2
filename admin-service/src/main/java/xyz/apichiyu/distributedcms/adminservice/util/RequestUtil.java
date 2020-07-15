package xyz.apichiyu.distributedcms.adminservice.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 */
public class RequestUtil {
    public static String getGetParameter(String name){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String[] result = request.getParameterValues(name);
        if(result != null){
            if(result.length == 1){
                return result[0];
            }
        }
        return null;
    }
}
