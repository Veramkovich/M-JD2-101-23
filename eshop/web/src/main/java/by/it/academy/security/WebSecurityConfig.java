package by.it.academy.security;


import by.it.academy.data.DataConfiguration;
import by.it.academy.service.ServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@Import({DataConfiguration.class, ServiceConfiguration.class})
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @SuppressWarnings({"deprecation", "unused"})
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @SuppressWarnings({"unused"})
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Configure Spring security filters
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home", "/static/**", "/WEB-INF/jsp/**").permitAll()
                        .requestMatchers("/login", "/deliveries/types").anonymous()
                        .requestMatchers("/logout").authenticated()
                        .requestMatchers("/add**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .logout(Customizer.withDefaults())
        ;
        return http.build();
    }

    @SuppressWarnings({"unused"})
    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }
}
