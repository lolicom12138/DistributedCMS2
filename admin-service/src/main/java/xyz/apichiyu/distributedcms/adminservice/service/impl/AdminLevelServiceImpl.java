package xyz.apichiyu.distributedcms.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.apichiyu.distributedcms.adminservice.dao.jpa.AdminLevelRepository;
import xyz.apichiyu.distributedcms.adminservice.dao.mybatis.AdminLevelDao;
import xyz.apichiyu.distributedcms.adminservice.entity.AdminLevel;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminLevelSearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AdminLevelService;

import java.util.List;

/**
 * @author AdminLevelistrator
 */
@Service
public class AdminLevelServiceImpl extends BaseServiceImpl<AdminLevel, AdminLevelSearchForm, AdminLevelRepository, AdminLevelDao> implements AdminLevelService {
    @Autowired
    public AdminLevelServiceImpl(AdminLevelDao adminLevelDao, AdminLevelRepository repository){
        super(adminLevelDao,repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void save(AdminLevel entity)  throws Exception{
        baseSave(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<AdminLevel> list) throws Exception {
        baseSaveAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void delete(AdminLevel entity) throws Exception {
        baseDelete(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(List<AdminLevel> list) throws Exception {
        baseDeleteAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(AdminLevelSearchForm form) throws Exception {
        baseDeleteAll(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(List<AdminLevel> list) throws Exception {
        baseUpdateAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(AdminLevel entity, AdminLevelSearchForm form) throws Exception {
        baseUpdateAll(entity,form);
    }

    @Override
    public AdminLevel findById(Long id) {
        return baseFindById(id);
    }

    @Override
    public AdminLevel findByForm(AdminLevelSearchForm form) {
        return baseFindByForm(form);
    }

    @Override
    public List<AdminLevel> findAllByForm(AdminLevelSearchForm form) {
        return baseFindAllByForm(form);
    }

    @Override
    public List<AdminLevel> findAllByIds(List<Long> ids) {
        return baseFindAllByIds(ids);
    }
}
