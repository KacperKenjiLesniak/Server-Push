import app.UserConfiguration;
import configuration.NotificationSocketConfig;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan({"hello"})
@Import(NotificationSocketConfig.class)
public class PushServer
{
    public static void run(UserConfiguration userConfiguration, String... args)
    {
        final ConfigurableApplicationContext context = SpringApplication.run(new Object[]{PushServer.class}, args);
        final ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.registerSingleton(UserConfiguration.class.getName(), userConfiguration);
    }
}
