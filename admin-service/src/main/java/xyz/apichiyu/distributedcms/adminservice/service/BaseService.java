package xyz.apichiyu.distributedcms.adminservice.service;

import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

import java.util.List;

/**
 * @author Administrator
 */
public interface BaseService<T extends BaseEntity,U extends BaseSearchForm> {
    // C
    /**
     * 添加或修改
     * @param entity
     * @throws Exception
     */
    public void save(T entity) throws Exception;

    /**
     * 批量添加
     * @param list
     * @throws Exception
     */
    public void saveAll(List<T> list) throws Exception;
    // D

    /**
     * 删除
     * @param entity
     * @throws Exception
     */
    public void delete(T entity) throws Exception;

    /**
     * 批量删除
     * @param list
     * @throws Exception
     */
    public void deleteAll(List<T> list) throws Exception;

    /**
     * 查询后批量删除
     * @param form
     * @throws Exception
     */
    public void deleteAll(U form) throws Exception;
    // U

    /**
     * 批量修改
     * @param list
     * @throws Exception
     */
    public void updateAll(List<T> list) throws Exception;

    /**
     * 检索后批量修改
     * @param entity
     * @param form
     * @throws Exception
     */
    public void updateAll(T entity, U form) throws Exception;
    // R

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public T findById(Long id);

    /**
     * 通过form查询单个
     * @param form
     * @return
     */
    public T findByForm(U form);

    /**
     * 通过form查询多个,带分页，返回list
     * @param form
     * @return
     */
    public List<T> findAllByForm(U form);


    /**
     * 通过id的列表查询
     * @param ids
     * @return
     */
    public List<T> findAllByIds(List<Long> ids);


}
