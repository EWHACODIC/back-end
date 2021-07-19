package ewhacodic.demo.config;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class EmbeddedRedisConfig {

    RedisServer redisServer = new RedisServer(6379);;

    public EmbeddedRedisConfig() throws IOException {
    }

    @PostConstruct
    public void redisServer() {

        redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}

