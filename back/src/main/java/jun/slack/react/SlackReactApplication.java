package jun.slack.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class SlackReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackReactApplication.class, args);
	}

}
