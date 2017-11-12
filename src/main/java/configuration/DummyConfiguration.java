package configuration;

import app.UserConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyConfiguration
{
    @Bean
    public UserConfiguration get()
    {
        return null;
    }
}
