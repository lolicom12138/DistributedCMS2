package xyz.apichiyu.distributedcms.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.apichiyu.distributedcms.adminservice.dao.jpa.AdminRepository;
import xyz.apichiyu.distributedcms.adminservice.dao.mybatis.AdminDao;
import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.feign.CacheFeign;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminSearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AdminService;
import xyz.apichiyu.distributedcms.adminservice.util.StringUtil;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminSearchForm, AdminRepository, AdminDao> implements AdminService {
    private CacheFeign cacheFeign;
    @Value("${session.expire}")
    private long sessionExpire;
    @Autowired
    public AdminServiceImpl(AdminDao adminDao, AdminRepository repository,CacheFeign cacheFeign) {
        super(adminDao, repository);
        this.cacheFeign = cacheFeign;
    }


    @Override
    public Admin checkLogin(String sessionId, String nonceStr, String sign) {
        Admin admin = getLoginAdmin(sessionId,nonceStr,sign);
        if (null != admin) {
            cacheFeign.redisValueSet("admin"+admin.getSessionId(),admin,sessionExpire);
        }
        return admin;
    }

    @Override
    public Admin getLoginAdmin(String sessionId, String nonceStr, String sign) {
        Admin admin = (Admin) cacheFeign.redisValueGet("admin"+sessionId);
        if (null != admin) {
            String str = "sessionId=" + sessionId + "&sessionKey=" + admin.getSessionKey() + "&nonceStr=" + nonceStr;
            if (StringUtil.encrypt(str).equals(sign)) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin login(String login, String pwd) {
        AdminSearchForm form = new AdminSearchForm();
        form.setLogin(login);
        form.setPwd(StringUtil.encrypt(pwd));
        Admin admin = findByForm(form);
        if (null != admin && admin.isActive()) {
            admin.setSessionId(StringUtil.randomString(32));
            admin.setSessionKey(StringUtil.randomNumString(32));
            cacheFeign.redisValueSet("admin"+admin.getSessionId(),admin,sessionExpire);
            return admin;
        }
        return null;
    }

    @Override
    public void logout(Admin admin) {
        cacheFeign.redisValueDelete("admin"+admin.getSessionId());
    }

    @Override
    public boolean checkLoginDuplicate(String login) {
        AdminSearchForm form = new AdminSearchForm();
        form.setLogin(login);
        return baseFindByForm(form) == null;
    }
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void save(Admin entity)  throws Exception{
        baseSave(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<Admin> list) throws Exception {
        baseSaveAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void delete(Admin entity) throws Exception {
        baseDelete(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(List<Admin> list) throws Exception {
        baseDeleteAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(AdminSearchForm form) throws Exception {
        baseDeleteAll(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(List<Admin> list) throws Exception {
        baseUpdateAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(Admin entity, AdminSearchForm form) throws Exception {
        baseUpdateAll(entity,form);
    }

    @Override
    public Admin findById(Long id) {
        return baseFindById(id);
    }

    @Override
    public Admin findByForm(AdminSearchForm form) {
        return baseFindByForm(form);
    }

    @Override
    public List<Admin> findAllByForm(AdminSearchForm form) {
        return baseFindAllByForm(form);
    }

    @Override
    public List<Admin> findAllByIds(List<Long> ids) {
        return baseFindAllByIds(ids);
    }
}
