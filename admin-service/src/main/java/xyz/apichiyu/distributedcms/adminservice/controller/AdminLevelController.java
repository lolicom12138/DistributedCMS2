package xyz.apichiyu.distributedcms.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.apichiyu.distributedcms.adminservice.annotation.Login;
import xyz.apichiyu.distributedcms.adminservice.dto.level.AdminLevelAddDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.level.AdminLevelUpdateDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.result.Result;
import xyz.apichiyu.distributedcms.adminservice.entity.AdminLevel;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminLevelSearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AdminLevelService;
import xyz.apichiyu.distributedcms.adminservice.service.impl.AdminLevelServiceImpl;

import java.util.List;

/**
 * @author lolicom
 */
@RestController
@RequestMapping("/level")
public class AdminLevelController {
	private AdminLevelService adminLevelService;
	@Autowired
	public AdminLevelController(AdminLevelServiceImpl adminLevelService){
		this.adminLevelService = adminLevelService;
	}

	@RequestMapping("/add")
	@Login
	public Result add(@RequestBody AdminLevelAddDTO dto) throws Exception {
		AdminLevel adminLevel = AdminLevel.createByDTO(dto);
		if(null != adminLevel){
			adminLevelService.save(adminLevel);
			return Result.ok("",adminLevel);
		}
		throw new Exception("失败");
	}
	@RequestMapping("/update")
	@Login
	public Result update(@RequestBody AdminLevelUpdateDTO dto) throws Exception{
		if(null == dto || null == dto.getId()){
			throw new Exception("访问错误");
		}
		AdminLevel adminLevel = adminLevelService.findById(dto.getId());
		if(null == adminLevel){
			throw new Exception("访问错误");
		}
		adminLevel.updateByDTO(dto);
		adminLevelService.save(adminLevel);
		return Result.ok("",adminLevel);
	}
	@RequestMapping("/list")
	@Login
	public Result list(@RequestBody AdminLevelSearchForm form) throws Exception{
		List<AdminLevel> list = adminLevelService.findAllByForm(form);
		return Result.ok("",list);
	}
}
