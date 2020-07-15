package xyz.apichiyu.distributedcms.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.apichiyu.distributedcms.adminservice.dao.jpa.AdminActionRecordRepository;
import xyz.apichiyu.distributedcms.adminservice.dao.mybatis.AdminActionRecordDao;
import xyz.apichiyu.distributedcms.adminservice.entity.AdminActionRecord;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminActionRecordSearchForm;
import xyz.apichiyu.distributedcms.adminservice.service.AdminActionRecordService;

import java.util.List;

/**
 * @author AdminActionRecordistrator
 */
@Service
public class AdminActionRecordServiceImpl extends BaseServiceImpl<AdminActionRecord, AdminActionRecordSearchForm, AdminActionRecordRepository, AdminActionRecordDao> implements AdminActionRecordService {
    @Autowired
    public AdminActionRecordServiceImpl(AdminActionRecordDao adminActionRecordDao, AdminActionRecordRepository repository){
        super(adminActionRecordDao,repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void save(AdminActionRecord entity)  throws Exception{
        baseSave(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<AdminActionRecord> list) throws Exception {
        baseSaveAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void delete(AdminActionRecord entity) throws Exception {
        baseDelete(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(List<AdminActionRecord> list) throws Exception {
        baseDeleteAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(AdminActionRecordSearchForm form) throws Exception {
        baseDeleteAll(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(List<AdminActionRecord> list) throws Exception {
        baseUpdateAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateAll(AdminActionRecord entity, AdminActionRecordSearchForm form) throws Exception {
        baseUpdateAll(entity,form);
    }

    @Override
    public AdminActionRecord findById(Long id) {
        return baseFindById(id);
    }

    @Override
    public AdminActionRecord findByForm(AdminActionRecordSearchForm form) {
        return baseFindByForm(form);
    }

    @Override
    public List<AdminActionRecord> findAllByForm(AdminActionRecordSearchForm form) {
        return baseFindAllByForm(form);
    }

    @Override
    public List<AdminActionRecord> findAllByIds(List<Long> ids) {
        return baseFindAllByIds(ids);
    }
}
