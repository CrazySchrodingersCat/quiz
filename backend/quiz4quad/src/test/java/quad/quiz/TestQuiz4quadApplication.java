package quad.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestQuiz4quadApplication {

    public static void main(String[] args) {
        SpringApplication.from(Quiz4quadApplication::main).with(TestQuiz4quadApplication.class).run(args);
    }

}
