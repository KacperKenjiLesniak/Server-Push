package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hello"})
public class BootApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(new Object[]{BootApp.class}, args);
    }
}
