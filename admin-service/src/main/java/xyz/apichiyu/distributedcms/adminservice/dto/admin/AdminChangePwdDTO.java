package xyz.apichiyu.distributedcms.adminservice.dto.admin;

import xyz.apichiyu.distributedcms.adminservice.util.JsonUtil;

/**
 * @author lolicom
 */
public class AdminChangePwdDTO {
    private Long id;
    private String oldPwd;
    private String newPwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString(){
        return JsonUtil.toJson(this);
    }
}
