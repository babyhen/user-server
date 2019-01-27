package com.pawpaw.fishinghome.usercenter.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.pawpaw.common.util.AssertUtil;

/**
 * 具体使用参考：https://github.com/redisson/redisson/wiki/2.-%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95#21-%E7%A8%8B%E5%BA%8F%E5%8C%96%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95
 * 初始化Redisson的bean实例
 * 
 * @author liujixin
 *
 */
@Configuration
public class RedissonConfig {
	private final Logger logger = LoggerFactory.getLogger(RedissonConfig.class);

	@Autowired
	private Environment environment;

	@Bean
	public RedissonClient buildRedissonBean() {
		Config config = new Config();
		config.setTransportMode(TransportMode.NIO);
		String host = this.environment.getRequiredProperty("spring.redis.host", String.class);
		AssertUtil.notBlank(host, "redis host参数不能为空");
		Integer port = this.environment.getRequiredProperty("spring.redis.port", Integer.class);
		AssertUtil.notNull(port, "redis port参数不能为空");
		Integer dataBase = this.environment.getRequiredProperty("spring.redis.database", Integer.class);
		if (dataBase == null) {
			logger.warn("redis数据库index没有指定，设置成默认的0");
			dataBase = 0;
		}
		String password = this.environment.getRequiredProperty("spring.redis.password", String.class);
		config.useMasterSlaveServers().setMasterAddress("redis://" + host + ":" + port).setDatabase(dataBase)
				.setPassword(password);
		RedissonClient redisson = Redisson.create(config);
		return redisson;
	}

}
