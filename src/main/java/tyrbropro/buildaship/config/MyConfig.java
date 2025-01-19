package tyrbropro.buildaship.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:myApp.properties")
@ComponentScan(basePackages = "tyrbropro.buildaship")
public class MyConfig {
}
