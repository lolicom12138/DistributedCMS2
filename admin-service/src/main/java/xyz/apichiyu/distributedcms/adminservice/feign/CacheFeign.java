package xyz.apichiyu.distributedcms.adminservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.apichiyu.distributedcms.adminservice.dto.result.Result;

/**
 * @author lolicom
 */
@Component
@FeignClient(value = "cache-service")
public interface CacheFeign {
	/**
	 * 往redis中写数据
	 * @return
	 */
	@RequestMapping("/redis/value/set")
	public Result redisValueSet(@RequestParam(value="key")String key, @RequestParam(value="value")Object value);
	/**
	 * 往redis中写数据
	 * @return
	 */
	@RequestMapping("/redis/value/setWithExpire")
	public Result redisValueSet(@RequestParam(value="key")String key,@RequestParam(value="value")Object value,@RequestParam(value="expire")long expire);

	/**
	 * 从redis中拿数据
	 * @param key
	 * @return
	 */
	@RequestMapping("/redis/value/get")
	public Result redisValueGet(@RequestParam(value="key")String key);

	/**
	 * 从redis中删除key的value
	 * @param key
	 * @return
	 */
	@RequestMapping("/redis/value/delete")
	public Result redisValueDelete(@RequestParam(value="key")String key);

	@RequestMapping("/test/test")
	public Result test();
}
