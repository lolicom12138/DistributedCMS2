package xyz.apichiyu.distributedcms.adminservice.dto.admin;

import xyz.apichiyu.distributedcms.adminservice.util.JsonUtil;

/**
 *
 * @author lolicom
 */
public class AdminActiveDTO {
    private Long id;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }

}
