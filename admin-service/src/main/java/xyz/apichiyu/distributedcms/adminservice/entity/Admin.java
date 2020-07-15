package xyz.apichiyu.distributedcms.adminservice.entity;


import xyz.apichiyu.distributedcms.adminservice.dto.admin.AdminAddDTO;
import xyz.apichiyu.distributedcms.adminservice.dto.admin.AdminUpdateDTO;
import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;
import xyz.apichiyu.distributedcms.adminservice.service.AdminLevelService;
import xyz.apichiyu.distributedcms.adminservice.service.impl.AdminLevelServiceImpl;
import xyz.apichiyu.distributedcms.adminservice.util.SpringUtil;
import xyz.apichiyu.distributedcms.adminservice.util.StringUtil;

import javax.persistence.*;


/**
 * @author Administrator
 */
@Entity
@Table(name = "cms_admin")
public final class Admin extends BaseEntity {
    @Id
    private Long id;
    @Column(unique = true, nullable = false, updatable = false)
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private String login;
    private String pwd;
    private String name;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private AdminLevel level;
    private String email;
    private Long timeLastLogin;
    @Version
    private Integer version;
    private Boolean active = true;
    @Transient
    private String sessionId;
    @Transient
    private String sessionKey;
    private Boolean changeable = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdminLevel getLevel() {
        return level;
    }

    public void setLevel(AdminLevel level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTimeLastLogin() {
        return timeLastLogin;
    }

    public void setTimeLastLogin(Long timeLastLogin) {
        this.timeLastLogin = timeLastLogin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getActive() {
        return active;
    }

    public static Admin createByDTO(AdminAddDTO dto) {
        Admin admin = new Admin();
        admin.id = StringUtil.makeIdLong(4);
        admin.login = dto.getLogin();
        admin.pwd = dto.getPwd();
        admin.name = dto.getName();
        admin.email = dto.getEmail();
        if(null == dto.getLevelId()){
            AdminLevelService adminLevelService = SpringUtil.getBean(AdminLevelServiceImpl.class);
            admin.level = adminLevelService.findById(dto.getLevelId());
            if(null == admin.level){
                return null;
            }
        }else{
            return null;
        }
        return admin;
    }
    public void updateByDTO(AdminUpdateDTO dto) throws Exception {
        login = dto.getLogin();
        name = dto.getName();
        email = dto.getEmail();
        if(null == dto.getLevelId()){
            AdminLevelService adminLevelService = SpringUtil.getBean(AdminLevelServiceImpl.class);
            AdminLevel adminlevel = adminLevelService.findById(dto.getLevelId());
            if(null == adminlevel){
                throw new Exception("权限设置错误");
            }
            level = adminlevel;
        }else{
            throw new Exception("权限设置错误");
        }
    }

    public Boolean getChangeable() {
        return changeable;
    }
    public boolean isChangeable() {
        return changeable;
    }

    public void setChangeable(Boolean changeable) {
        this.changeable = changeable;
    }
}
