import app.UserConfiguration;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hello", "configuration"})
//@Import(DummyConfiguration.class)
public class PushServer
{
    public final UserConfiguration userConfiguration;

    public PushServer(final UserConfiguration userConfiguration)
    {
        this.userConfiguration = userConfiguration;
    }

    public void run(String... args)
    {
        final ConfigurableApplicationContext context = SpringApplication.run(new Object[]{PushServer.class}, args);
        final ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.registerSingleton(UserConfiguration.class.getName(), userConfiguration);
    }
}
