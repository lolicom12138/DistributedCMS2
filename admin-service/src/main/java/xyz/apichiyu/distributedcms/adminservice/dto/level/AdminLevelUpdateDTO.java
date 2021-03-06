package xyz.apichiyu.distributedcms.adminservice.dto.level;

import xyz.apichiyu.distributedcms.adminservice.util.JsonUtil;

/**
 * @author lolicom
 */
public class AdminLevelUpdateDTO {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
