package xyz.apichiyu.distributedcms.adminservice.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Administrator
 */
public class HttpRequestUtil {
    private static RestTemplate restTemplate = new RestTemplate();
    public static String getRequest(String url) {
        ResponseEntity responseEntity=restTemplate.getForEntity(url, String.class);
        return (String) responseEntity.getBody();
    }
    public static Object getRequest(String url,Class clazz){
        ResponseEntity responseEntity=restTemplate.getForEntity(url, clazz);
        return responseEntity.getBody();
    }
    public static String postRequest(String url, Object parameters){
        ResponseEntity responseEntity = restTemplate.postForEntity(url,parameters,String.class);
        String body = (String) responseEntity.getBody();
        return body;
    }
    public static Object postRequest(String url, Object parameters,Class clazz){
        ResponseEntity responseEntity = restTemplate.postForEntity(url,parameters,clazz);
        return responseEntity.getBody();
    }
    public static String postRequestFile(String url, Map<String,Object> formPost, FileSystemResource file, String filePostName){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        for (String key : formPost.keySet()) {
            form.add(key,formPost.get(key));
        }
        HttpEntity<MultiValueMap<String, Object>> post = new HttpEntity<>(form, headers);
        return restTemplate.postForObject(url, post, String.class);
    }
    public static Object postRequestFile(String url, Map<String,Object> formPost, FileSystemResource file, String filePostName, Class clazz){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        for (String key : formPost.keySet()) {
            form.add(key,formPost.get(key));
        }
        HttpEntity<MultiValueMap<String, Object>> post = new HttpEntity<>(form, headers);
        return restTemplate.postForObject(url, post, clazz);
    }
}
