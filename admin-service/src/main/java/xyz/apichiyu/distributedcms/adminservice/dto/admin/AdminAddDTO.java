package xyz.apichiyu.distributedcms.adminservice.dto.admin;


import xyz.apichiyu.distributedcms.adminservice.util.JsonUtil;

/**
 *
 * @author lolicom
 */
public class AdminAddDTO {
    private String login;
    private String pwd;
    private String name;
    private Long levelId;
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
