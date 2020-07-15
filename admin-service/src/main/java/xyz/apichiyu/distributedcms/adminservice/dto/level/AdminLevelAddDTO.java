package xyz.apichiyu.distributedcms.adminservice.dto.level;

import xyz.apichiyu.distributedcms.adminservice.util.JsonUtil;

/**
 * @author lolicom
 */
public class AdminLevelAddDTO {
	private String name;

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
