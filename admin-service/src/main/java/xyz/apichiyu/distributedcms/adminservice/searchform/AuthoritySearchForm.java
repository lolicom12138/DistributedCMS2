package xyz.apichiyu.distributedcms.adminservice.searchform;

import org.springframework.data.jpa.domain.Specification;
import xyz.apichiyu.distributedcms.adminservice.entity.Authority;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

/**
 * @author Administrator
 */
public class AuthoritySearchForm extends BaseSearchForm<Authority> {
    @Override
    public Specification formToSpecification() {
        return null;
    }
}
