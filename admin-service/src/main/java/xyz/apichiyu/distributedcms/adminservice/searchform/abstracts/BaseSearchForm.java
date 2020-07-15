package xyz.apichiyu.distributedcms.adminservice.searchform.abstracts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;

/**
 * @author Administrator
 */
public abstract class BaseSearchForm<T extends BaseEntity>{
    private Integer page = 1;
    private Integer pageRows = 10;

    private String sort = "id";
    private Sort.Direction sortType = Sort.Direction.ASC;

    private final String ASC = "asc";

    private Boolean fuzzy;
    private Boolean pager;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Sort.Direction getSortType() {
        return sortType;
    }

    public void setSortType(Sort.Direction sortType) {
        this.sortType = sortType;
    }

    public void setSortType(String type){
        if(ASC.equals(type)){
            this.sortType = Sort.Direction.ASC;
        }else{
            this.sortType = Sort.Direction.DESC;
        }
    }

    public Boolean isFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(Boolean fuzzy) {
        this.fuzzy = fuzzy;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    public Boolean getFuzzy() {
        return fuzzy;
    }

    public Boolean getPager() {
        return pager;
    }

    public void setPager(Boolean pager) {
        this.pager = pager;
    }

    /**
     * 将searchForm转换为检索用的specification
     * @return
     */
    public abstract Specification<T> formToSpecification();
}
