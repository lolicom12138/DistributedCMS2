package xyz.apichiyu.distributedcms.adminservice.dto.admin;

import xyz.apichiyu.distributedcms.adminservice.searchform.AdminSearchForm;
import xyz.apichiyu.distributedcms.adminservice.util.JsonUtil;

import java.util.List;

/**
 *
 * @author lolicom
 */
public class AdminUpdateDTO {
    private Long id;
    private String login;
    private String name;
    private Long levelId;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }

}
