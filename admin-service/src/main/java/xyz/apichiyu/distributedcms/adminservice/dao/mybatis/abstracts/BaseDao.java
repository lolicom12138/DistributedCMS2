package xyz.apichiyu.distributedcms.adminservice.dao.mybatis.abstracts;

import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

import java.util.List;

/**
 * @author Administrator
 */
public abstract interface BaseDao<T extends BaseEntity,U extends BaseSearchForm> {
    /**
     * 批量修改
     * @param entity
     * @param form
     */
    public void updateAll(T entity,U form);
    /**
     * 通过form查询多个
     * @param form
     * @return
     */
    public List<T> findAllByForm(U form);

    /**
     * 通过id的列表查询
     * @param ids
     * @return
     */
    public List<T> findAllByIds(List<String> ids);
}
