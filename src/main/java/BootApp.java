import configuration.ConfigurationYAML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"configuration", "hello"})
public class BootApp
{
    @Autowired
    private ConfigurationYAML configuration;

    public static void main(String[] args)
    {
        SpringApplication.run(new Object[]{BootApp.class}, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("[SERVER PUSH] using environment: " + configuration.getEnvironment());
        System.out.println("[SREVER PUSH] servers: " + configuration.getServers());
    }
}
