package xyz.apichiyu.distributedcms.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.apichiyu.distributedcms.adminservice.annotation.Login;
import xyz.apichiyu.distributedcms.adminservice.dto.admin.AdminLoginDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.result.Result;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminSearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AdminService;
import xyz.apichiyu.distributedcms.adminservice.service.impl.AdminServiceImpl;
import xyz.apichiyu.distributedcms.adminservice.util.LoginAdminUtil;

/**
 * @author lolicom
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	private AdminService adminService;
	@Autowired
	public LoginController(AdminServiceImpl adminService){
		this.adminService = adminService;
	}
	@RequestMapping("/index")
	public Result login(@RequestBody AdminLoginDTO dto) throws Exception{
		String login = dto.getLogin();
		String pwd = dto.getPwd();
		if(null == login || pwd == login){
			throw new Exception("用户名或密码错误");
		}
		Admin admin = adminService.login(login,pwd);
		if(null == admin){
			throw new Exception("用户名或密码错误");
		}
		return Result.ok("",admin);
	}
	@RequestMapping("/logout")
	@Login
	public Result logout(){
		Admin admin = LoginAdminUtil.getLoginAdmin();
		adminService.logout(admin);
		return Result.ok("",null);
	}
}
