package spring_lesson2_AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("spring_lesson2_AOP")
@EnableAspectJAutoProxy
public class MyConfig {
    @Bean
    public UniLibrary library(){
        return new UniLibrary();
    }

}
