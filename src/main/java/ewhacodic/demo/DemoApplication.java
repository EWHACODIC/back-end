package ewhacodic.demo;

import ewhacodic.demo.config.GithubProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ewhacodic.demo.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {AppProperties.class, ScrapingProperties.class, GithubProperties.class})
@EnableJpaAuditing


public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


