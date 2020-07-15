package xyz.apichiyu.distributedcms.adminservice.dao.jpa;

import org.springframework.stereotype.Repository;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;

/**
 * @author Administrator
 */
@Repository
public interface AdminRepository extends BaseRepository<Admin> {
    /**
     * 通过login查找对应的admin
     * @param login
     * @return
     */
    public Admin findByLogin(String login);
}
