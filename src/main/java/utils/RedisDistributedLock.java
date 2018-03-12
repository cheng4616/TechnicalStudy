package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年9月14日       redis 分布式锁
 * </pre>
 */
public class RedisDistributedLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisDistributedLock.class);

    private RedisTemplate redisTemplate;

    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLS = 100;

    /**
     * 共享锁
     */
    private String lockKey;

    private int expireMsecs = 60 * 1000;

    /**
     * 线程获得锁等待时间，防止线程饥饿
     */
    private int timeoutMsecs = 10 * 1000;

    private volatile boolean locked = false;

    public RedisDistributedLock(RedisTemplate redisTemplate, String lockKey) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
    }

    public RedisDistributedLock(RedisTemplate redisTemplate, String lockKey, int timeoutMsecs) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
        this.timeoutMsecs = timeoutMsecs;
    }

    public RedisDistributedLock(RedisTemplate redisTemplate, String lockKey, int timeoutMsecs, int expireMsecs) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
        this.timeoutMsecs = timeoutMsecs;
        this.expireMsecs = expireMsecs;
    }

    public String getLockKey() {
        return this.lockKey;
    }

    /**
     * 获得 lock. 实现思路: 主要是使用了redis 的setnx命令,缓存了锁. reids缓存的key是锁的key,所有的共享,
     * value是锁的到期时间(注意:这里把过期时间放在value了,没有时间上设置其超时时间) 执行过程:
     * 1.通过setnx尝试设置某个key的值,成功(当前没有这个锁)则返回,成功获得锁
     * 2.锁已经存在则获取锁的到期时间,和当前时间比较,超时的话,则设置新的值
     *
     * @return
     * @throws InterruptedException
     * @author liuzhicheng
     * @date 2017年9月14日 下午4:36:21
     */
    public synchronized boolean lock() throws InterruptedException {
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            String expiersStr = String.valueOf(expires);
            System.out.println(get(lockKey));
            if (this.setNX(lockKey, expiersStr)) {
                System.out.println(get(lockKey));
                locked = true;
                return true;
            }

            String currentValueStr = this.get(lockKey);
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                String oldValueStr = this.getSet(lockKey, expiersStr);
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    locked = true;
                    return true;
                }
            }

            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLS;

            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLS);

        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private boolean setNX(final String key, final String value) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {

                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    Boolean result = connection.setNX(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return result;
                }

            });
        } catch (Exception e) {
            logger.error("setNX redis error,key: %s", key);
        }
        return obj != null ? (Boolean) obj : false;
    }

    /**
     * <p>
     * 根据key值获取value
     * </p>
     *
     * @param key
     * @return
     * @author liuzhicheng
     * @date 2017年9月14日 下午4:10:52
     */
    @SuppressWarnings("unchecked")
    private String get(final String key) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {

                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] data = connection.get(serializer.serialize(key));
                    connection.close();
                    if (data == null) {
                        return null;
                    }
                    return serializer.deserialize(data);
                }

            });
        } catch (Exception e) {
            logger.error("get redis error,key: %s", key);
        }
        return obj != null ? obj.toString() : null;
    }

    @SuppressWarnings("unchecked")
    private String getSet(final String key, final String value) {
        Object obj = null;

        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] data = connection.getSet(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return serializer.deserialize(data);
                }
            });
        } catch (Exception e) {
            logger.error("getSet redis error,key: %s", key);
        }

        return obj != null ? obj.toString() : null;
    }

    @SuppressWarnings("unchecked")
    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }
}
