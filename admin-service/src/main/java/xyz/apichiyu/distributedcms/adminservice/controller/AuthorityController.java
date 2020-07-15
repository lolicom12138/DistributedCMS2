package xyz.apichiyu.distributedcms.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.apichiyu.distributedcms.adminservice.annotation.Login;
import xyz.apichiyu.distributedcms.adminservice.dto.result.Result;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.entity.Authority;
import xyz.apichiyu.distributedcms.adminservice.searchform.AuthoritySearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AuthorityService;
import xyz.apichiyu.distributedcms.adminservice.service.impl.AuthorityServiceImpl;

import java.util.List;

/**
 * @author lolicom
 */
@RestController
@RequestMapping("/authority")
public class AuthorityController {
	private AuthorityService authorityService;

	@Autowired
	public AuthorityController(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
	}

	@RequestMapping("/list")
	@Login
	public Result listAuthority(@RequestBody AuthoritySearchForm form) {
		List<Authority> list = authorityService.findAllByForm(form);
		return Result.ok("",list);
	}

	@RequestMapping("/listAll")
	@Login
	public Result listAll() {
		List<Authority> list =  authorityService.findAllByForm(new AuthoritySearchForm());
		return Result.ok("",list);
	}
}
