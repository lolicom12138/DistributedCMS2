package xyz.apichiyu.distributedcms.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.apichiyu.distributedcms.adminservice.dao.jpa.AuthorityRepository;
import xyz.apichiyu.distributedcms.adminservice.dao.mybatis.AuthorityDao;
import xyz.apichiyu.distributedcms.adminservice.entity.Authority;
import xyz.apichiyu.distributedcms.adminservice.searchform.AuthoritySearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AuthorityService;

import java.util.List;

/**
 * @author Authorityistrator
 */
@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, AuthoritySearchForm, AuthorityRepository, AuthorityDao> implements AuthorityService {
    @Autowired
    public AuthorityServiceImpl(AuthorityDao authorityDao, AuthorityRepository repository){
        super(authorityDao,repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void save(Authority entity)  throws Exception{
        baseSave(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<Authority> list) throws Exception {
        baseSaveAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void delete(Authority entity) throws Exception {
        baseDelete(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(List<Authority> list) throws Exception {
        baseDeleteAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(AuthoritySearchForm form) throws Exception {
        baseDeleteAll(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(List<Authority> list) throws Exception {
        baseUpdateAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(Authority entity, AuthoritySearchForm form) throws Exception {
        baseUpdateAll(entity,form);
    }

    @Override
    public Authority findById(Long id) {
        return baseFindById(id);
    }

    @Override
    public Authority findByForm(AuthoritySearchForm form) {
        return baseFindByForm(form);
    }

    @Override
    public List<Authority> findAllByForm(AuthoritySearchForm form) {
        return baseFindAllByForm(form);
    }

    @Override
    public List<Authority> findAllByIds(List<Long> ids) {
        return baseFindAllByIds(ids);
    }
}
