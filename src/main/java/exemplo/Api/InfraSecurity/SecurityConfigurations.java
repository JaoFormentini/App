package exemplo.Api.InfraSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    SecurityFilter securityFilter;

//Corrigir liberaçoes de endpoints para as roles, ainda vou configurar, me deixa em paz.

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/posto/post").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/posto/{cnpj}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/posto/cnpj/{cnpj}").hasRole("MANEGER")
                        .requestMatchers(HttpMethod.POST, "/escala/post").hasRole("MANEGER")
                        .requestMatchers(HttpMethod.PUT, "/escala/{id}").hasRole("MANEGER")
                        .requestMatchers(HttpMethod.DELETE, "/escala/{id}").hasRole("MANEGER")
                        .requestMatchers(HttpMethod.POST, "/medico/post").hasRole("MANEGER")
                        .requestMatchers(HttpMethod.PUT, "/medico/crm/{crm}").hasRole("MANEGER")
                        .requestMatchers(HttpMethod.DELETE, "/medico/crm/{crm}").hasRole("MANEGER")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
