package xyz.apichiyu.distributedcms.adminservice.searchform;

import org.springframework.data.jpa.domain.Specification;
import xyz.apichiyu.distributedcms.adminservice.entity.AdminActionRecord;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

/**
 * @author Administrator
 */
public class AdminActionRecordSearchForm extends BaseSearchForm<AdminActionRecord> {
    private String login;
    private String pwd;
    private String name;

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

    @Override
    public Specification formToSpecification() {
        return null;
    }
}
