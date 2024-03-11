package pl.szymcze.contentcalendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.szymcze.contentcalendar.config.ContentCalendarProperties;
import pl.szymcze.contentcalendar.model.Content;
import pl.szymcze.contentcalendar.model.Status;
import pl.szymcze.contentcalendar.model.Type;
import pl.szymcze.contentcalendar.repository.ContentRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
