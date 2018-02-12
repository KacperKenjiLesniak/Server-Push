import configuration.NotificationSocketConfig;
import configuration.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan({"controllers"})
@Import(NotificationSocketConfig.class)
public class PushServer
{
    public static void run(String... args)
    {
        final ConfigurableApplicationContext context = SpringApplication.run(new Object[]{PushServer.class}, args);
    }
}
