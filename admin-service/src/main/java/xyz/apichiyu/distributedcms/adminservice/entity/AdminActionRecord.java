package xyz.apichiyu.distributedcms.adminservice.entity;


import xyz.apichiyu.distributedcms.adminservice.entity.abstracts.BaseEntity;

import javax.persistence.*;

/**
 * @author Administrator
 */
@Entity
@Table(name = "cms_admin_action_record")
public final class AdminActionRecord extends BaseEntity {
    @Id
    private Long id;
    private String action;
    private String controller;
    private String method;
    private String args;
	@Column(columnDefinition = "text")
    private String content;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey( ConstraintMode.NO_CONSTRAINT))
    private Admin admin;
    private Long time;
    private String ip;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

}
