package xyz.apichiyu.distributedcms.adminservice.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;

/**
 * @author Administrator
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long>, JpaSpecificationExecutor<T>, PagingAndSortingRepository<T, Long> {
}
