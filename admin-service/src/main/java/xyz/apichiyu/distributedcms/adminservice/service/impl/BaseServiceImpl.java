package xyz.apichiyu.distributedcms.adminservice.service.impl;

import org.apache.logging.log4j.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.apichiyu.distributedcms.adminservice.dao.jpa.BaseRepository;
import xyz.apichiyu.distributedcms.adminservice.dao.mybatis.abstracts.BaseDao;
import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;
import xyz.apichiyu.distributedcms.adminservice.searchform.abstracts.BaseSearchForm;

import java.util.List;
import java.util.Optional;

/**
 * @author lolicom
 */
public class BaseServiceImpl<E extends BaseEntity, S extends BaseSearchForm, R extends BaseRepository,K extends BaseDao> {
    protected Logger logger = LogManager.getLogger(BaseServiceImpl.class);
    protected R repository;
    protected K dao;

    protected BaseServiceImpl(K dao, R repository) {
        this.dao = dao;
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    protected void baseSave(E entity) throws Exception {
        entity = (E) repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    protected void baseSaveAll(List<E> list) throws Exception {
        list = repository.saveAll(list);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    protected void baseDelete(E entity) throws Exception {
        repository.delete(entity);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    protected void baseDeleteAll(List<E> list) throws Exception {
        repository.deleteAll(list);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    protected void baseUpdateAll(List<E> list) throws Exception {
        list = repository.saveAll(list);
    }

    protected E baseFindById(Long id) {
        Optional<E> optionalE = repository.findById(id);
        if (optionalE.isPresent()) {
            return optionalE.get();
        } else {
            return null;
        }
    }

    protected List<E> baseFindByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    protected void baseDeleteAll(S form) throws Exception {
        Specification<E> specification = form.formToSpecification();
        List<E> list = repository.findAll(specification);
        baseDeleteAll(list);
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    protected void baseUpdateAll(E entity, S form) throws Exception {
        //TODO
        dao.updateAll(entity,form);
    }

    protected E baseFindByForm(S form) {
        Specification<E> specification = form.formToSpecification();
        List<E> list = repository.findAll(specification);
        if (null == list || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    protected List<E> baseFindAllByForm(S form) {
        /*
        Specification<E> specification = form.formToSpecification();
        Pageable pageable = form.toPageable();
        if (null == pageable) {
            return repository.findAll(specification);
        } else {
            Page<E> page = repository.findAll(specification, pageable);
            return page.getContent();
        }
         */
        // TODO
        return dao.findAllByForm(form);
    }

    public List<E> baseFindAllByIds(List<Long> ids){
        //TODO
        return dao.findAllByIds(ids);
    }
}
