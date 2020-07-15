package xyz.apichiyu.distributedcms.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.apichiyu.distributedcms.adminservice.annotation.Login;
import xyz.apichiyu.distributedcms.adminservice.dto.admin.AdminActiveDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.admin.AdminAddDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.admin.AdminUpdateDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.result.Result;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminSearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AdminService;
import xyz.apichiyu.distributedcms.adminservice.service.impl.AdminServiceImpl;

import java.util.List;

/**
 * @author lolicom
 */
@RestController
@RequestMapping("/manage")
public class AdminManageController {
	private AdminService adminService;
	@Autowired
	public AdminManageController(AdminServiceImpl adminService){
		this.adminService = adminService;
	}

	@RequestMapping("/add")
	@Login
	public Result add(@RequestBody AdminAddDTO dto) throws Exception {
		Admin admin = Admin.createByDTO(dto);
		if(null == admin){
			throw new Exception("访问错误");
		}
		adminService.save(admin);
		return Result.ok("",admin);
	}
	@RequestMapping("/listAll")
	@Login
	public Result listAll(){
		List<Admin> list = adminService.findAllByForm(new AdminSearchForm());
		return Result.ok("",list);
	}
	@RequestMapping("/list")
	@Login
	public Result list(@RequestBody AdminSearchForm form){
		List<Admin> list = adminService.findAllByForm(form);
		return Result.ok("",list);
	}
	@RequestMapping("/update")
	@Login
	public Result update(@RequestBody AdminUpdateDTO dto) throws Exception {
		if(null == dto || null == dto.getId()){
			throw new Exception("访问错误");
		}
		Admin admin = adminService.findById(dto.getId());
		if(null == admin){
			throw new Exception("访问错误");
		}
		admin.updateByDTO(dto);
		adminService.save(admin);
		return Result.ok("",admin);
	}
	@RequestMapping("/active")
	@Login
	public Result active(@RequestBody AdminActiveDTO dto) throws Exception {
		if(null == dto || null == dto.getId()){
			throw new Exception("访问错误");
		}
		Admin admin = adminService.findById(dto.getId());
		if(null == admin){
			throw new Exception("访问错误");
		}
		admin.setActive(dto.getActive());
		adminService.save(admin);
		return Result.ok("",admin);
	}
}
