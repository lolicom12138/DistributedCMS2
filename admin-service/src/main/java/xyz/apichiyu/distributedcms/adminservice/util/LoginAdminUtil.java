package xyz.apichiyu.distributedcms.adminservice.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.service.AdminService;
import xyz.apichiyu.distributedcms.adminservice.service.impl.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author lolicom
 */
@Component
public class LoginAdminUtil {
	private static AdminService adminService;
	public void setAdminService(AdminServiceImpl adminService){
		LoginAdminUtil.adminService = adminService;
	}
	public static Admin checkLogin(){
		/*
		HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		try{
			String sessionId = (String) request.getAttribute("sessionId");
			String nonceStr = (String) request.getAttribute("nonceStr");
			String sign = (String) request.getAttribute("sign");
			if(sessionId != null && nonceStr != null && sign != null){
				return adminService.checkLogin(sessionId,nonceStr,sign);
			}
		}catch (Exception e) {
		}
		return null;

		 */
		return new Admin();
	}
	public static Admin getLoginAdmin(){
		/*
		HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		try{
			String sessionId = (String) request.getAttribute("sessionId");
			String nonceStr = (String) request.getAttribute("nonceStr");
			String sign = (String) request.getAttribute("sign");
			if(sessionId != null && nonceStr != null && sign != null){
				return adminService.getLoginAdmin(sessionId,nonceStr,sign);
			}
		}catch (Exception e) {
		}
		return null;

		 */
		return new Admin();
	}
}
