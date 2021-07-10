package ewhacodic.demo.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;


@Getter
@NoArgsConstructor
@Setter
@ConfigurationProperties(prefix = "github")
public class GithubProperties {
    private Duration connectionTimeout;
    private Duration readTimeout;
    private String host;
}
