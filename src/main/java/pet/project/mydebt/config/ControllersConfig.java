package pet.project.mydebt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllersConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/").setViewName("home");
        viewControllerRegistry.addViewController("/page/registration").setViewName("registration");
        viewControllerRegistry.addViewController("/test").setViewName("test");
    }
}
