package xyz.apichiyu.distributedcms.adminservice.searchform;

import org.springframework.data.jpa.domain.Specification;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class AdminSearchForm extends BaseSearchForm<Admin> {
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
    public Specification<Admin> formToSpecification() {
        Specification<Admin> specification = new Specification<Admin>() {
            @Override
            public Predicate toPredicate(Root<Admin> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(null != login){
                    predicates.add(criteriaBuilder.equal(root.get("login"), login));
                }
                if(null != pwd){
                    predicates.add(criteriaBuilder.equal(root.get("pwd"), pwd));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return specification;
    }
}
