package xyz.apichiyu.distributedcms.adminservice.searchform;

import org.springframework.data.jpa.domain.Specification;
import xyz.apichiyu.distributedcms.adminservice.entity.AdminLevel;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

/**
 * @author Administrator
 */
public class AdminLevelSearchForm extends BaseSearchForm<AdminLevel> {

    @Override
    public Specification formToSpecification() {
        return null;
    }
}
