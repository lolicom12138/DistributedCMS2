package xyz.apichiyu.distributedcms.adminservice.service;


import xyz.apichiyu.distributedcms.adminservice.entity.Admin;
import xyz.apichiyu.distributedcms.adminservice.searchform.AdminSearchForm;

/**
 * @author Administrator
 */
public interface AdminService extends BaseService<Admin, AdminSearchForm>{
    /**
     * api调用时检测用户登录情况,api模式
     * @param sessionId
     * @param nonceStr
     * @param sign
     * @return
     */
    public Admin checkLogin(String sessionId, String nonceStr, String sign);
    /**
     * 获取登录的admin，不续期
     * @param sessionId
     * @param nonceStr
     * @param sign
     * @return
     */
    public Admin getLoginAdmin(String sessionId, String nonceStr, String sign);

    /**
     * 用户登录
     * @param login
     * @param pwd
     * @return
     */
    public Admin login(String login, String pwd);

    /**
     * 用户登出
     * @param admin
     * @return
     */
    public void logout(Admin admin);

    /**
     * 检查登录名是否重复
     * @param login
     * @return 重复返回false，不重复返回true
     */
    public boolean checkLoginDuplicate(String login);
}
