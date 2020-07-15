package xyz.apichiyu.distributedcms.adminservice.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;
import xyz.apichiyu.distributedcms.adminservice.dao.mybatis.abstracts.BaseDao;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminSearchForm;

/**
 * @author Administrator
 */
@Mapper
public interface AdminDao extends BaseDao<Admin, AdminSearchForm> {

}
