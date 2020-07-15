package xyz.apichiyu.distributedcms.adminservice.entity;

import xyz.apichiyu.distributedcms.adminservice.dto.level.AdminLevelAddDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.level.AdminLevelUpdateDTO;
import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;
import xyz.apichiyu.distributedcms.adminservice.util.StringUtil;

import javax.persistence.*;
import java.util.List;

/**
 * @author Administrator
 */
@Entity
@Table(name = "cms_admin_level")
public final class AdminLevel extends BaseEntity {
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private Boolean deletable = true;
    @ManyToMany
    @JoinTable(
        name = "cms_level_authority",
        joinColumns = {
            @JoinColumn(name = "levelId")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "authorityId")
        },
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
        inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Authority> listAuthority;

    public String getName() {
        return name;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Authority> getListAuthority() {
        return listAuthority;
    }

    public void setListAuthority(List<Authority> listAuthority) {
        this.listAuthority = listAuthority;
    }

    public Boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public static AdminLevel createByDTO(AdminLevelAddDTO dto){
        if(null == dto){
            return null;
        }
        AdminLevel adminLevel = new AdminLevel();
        adminLevel.id = StringUtil.makeIdLong(4);
        adminLevel.name = dto.getName();
        adminLevel.deletable = true;
        return adminLevel;
    }
    public void updateByDTO(AdminLevelUpdateDTO dto){
        if(null != dto){
            name = dto.getName();
        }
    }
}
