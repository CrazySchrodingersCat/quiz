package quad.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Quiz4quadApplication {

    public static void main(String[] args) {
        SpringApplication.run(Quiz4quadApplication.class, args);
    }

}
