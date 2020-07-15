package xyz.apichiyu.distributedcms.adminservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 */
@Component
public class StringUtil {

    private static int instanceNumber;
    @Value("${instance.number}")
    public void setInstanceNumber(int number){
        StringUtil.instanceNumber = number;
    }
    /**
     * 去除掉字符串两边的引号和空格
     *
     * @param str
     * @return 计算后的字符串
     */
    public static String cleanString(String str) {
        if (null == str) {
            return "";
        }
        //结果
        String result = str.trim();
        return result.replace("'", "").replace("\"", "");
    }

    /**
     * 生成随机字符串
     *
     * @param length 随机字符串长度
     * @return 生成的随机字符串
     */
    public static String randomString(int length) {
        //字符池
        String all = "0EkFaGlH1ImJbKnL2MoNcOpP3QqRdSrT4UsVeWtX5YuZfv6wgx7yhz8AiB9CjD";
        //结果
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * all.length());
            result.append(all.charAt(index));
        }
        return result.toString();
    }

    /**
     * 生成随机的数字字符串
     *
     * @param length 长度
     * @return 生成的随机字符串
     */
    public static String randomNumString(int length) {
        //字符池
        String all = "0849251637";
        //结果
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * all.length());
            result.append(all.charAt(index));
        }
        return result.toString();
    }

    /**
     * 生成随机的纯字母字符串
     *
     * @param length 长度
     * @return 生成的随机字符串
     */
    public static String randomAlphabetString(int length) {
        //字符池
        String all = "GaHqIiJrKeLsMjNtOcPuQkRvSfTwUlVxWbXyYmZzgAnBdCoDhEpF";
        //结果
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * all.length());
            result.append(all.charAt(index));
        }
        return result.toString();
    }

    /**
     * 一个通用的方法，用于生成Id，组成为当前的时间戳+随机字符串
     *
     * @param length 随机字符串的长度（不是总长度，只是后边的随机字符串的长度）
     * @return 生成的ID
     */
    public static String makeId(int length) {
        Date now = new Date();
        return now.getTime() + randomNumString(length);
    }
    public static Long makeIdLong(int length){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(instanceNumber);
        String str = sdf.format(new Date())+instanceNumber+randomNumString(length);
        return Long.valueOf(str);
    }
    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    /**
     * 用于将字符串进行加密，在最终的md5加密进行前可先对字符串进行修改以增加安全性
     * @param str
     * @return
     */
    public static String encrypt(String str){
        return fenceSort(aroundSort(md5(postfix(prefix(str)))));
    }
    private static String prefix(String str){
        String prefix = "prefix";
        return prefix+str;
    }
    private static String postfix(String str){
        String postfix = "postfix";
        return str+postfix;
    }
    private static String aroundSort(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            if(i%2 == 0){
                sb.append(str.charAt(i));
            }else{
                sb.insert(0,str.charAt(i));
            }
        }
        return  sb.toString();
    }
    private static String fenceSort(String str){
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            if(i%2 == 0){
                sbLeft.append(str.charAt(i));
            }else{
                sbRight.append(str.charAt(i));
            }
        }
        return sbLeft.toString()+sbRight.toString();
    }
}
