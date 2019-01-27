package com.pawpaw.fishinghome.usercenter.aop;

import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.pawpaw.common.cache.CleanCacheAdvisor;
import com.pawpaw.common.cache.EnableCacheAdvisor;
import com.pawpaw.common.util.JsonUtil;

/**
 * 同一个AOP类内，按照方法生命的顺序执行，方法先声明，则后执行
 * 
 * @author liujixin
 *
 */
@Aspect
@Component
public class ServiceAop {

	@Autowired
	private StringRedisTemplate redisTemplate;

	private static final ConcurrentHashMap<String, Class[]> argTypeMap = new ConcurrentHashMap<>();

	@Pointcut("execution(* com.pawpaw.fishinghome.usercenter..service..*.*(..))")
	public void allServiceMethod() {

	}

	@Pointcut("@annotation(com.pawpaw.common.cache.EnableCache)")
	public void enableCacheMethod() {

	}

	@Pointcut("@annotation(com.pawpaw.common.cache.CleanCache)")
	public void cleanCacheMethod() {

	}

	@Around("allServiceMethod() && enableCacheMethod()")
	@Order(3)
	public Object executeWithCache(ProceedingJoinPoint joinPoint) throws Throwable {
		return new EnableCacheAdvisor(this.redisTemplate, joinPoint).adviseEnableCache();
	}

	@Around("allServiceMethod() && cleanCacheMethod()")
	public Object executeCleanCache(ProceedingJoinPoint joinPoint) throws Throwable {
		return new CleanCacheAdvisor(this.redisTemplate, joinPoint).adviseCleanCache();
	}

	@Before("allServiceMethod()")
	public void logServiceMethodArgument(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object target = joinPoint.getTarget();
		Class<?> targetClass = target.getClass();
		Object[] args = joinPoint.getArgs();
		Logger logger = LoggerFactory.getLogger(targetClass);
		logger.info("{}.{} all argument--{}", targetClass.getName(), method, args);
	}

	@Around("allServiceMethod()")
	public Object logServiceExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object target = joinPoint.getTarget();
		Class<?> targetClass = target.getClass();
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		Logger logger = LoggerFactory.getLogger(targetClass);
		Object o = joinPoint.proceed();
		String respData = JsonUtil.object2Json(o);
		// 记录service方法耗时的日志
		long spend = System.currentTimeMillis() - startTime;
		logger.info("时间花费 {}.{}:{}ms ; resp data:{}", targetClass.getName(), methodName, spend, respData);
		return o;
	}

}
