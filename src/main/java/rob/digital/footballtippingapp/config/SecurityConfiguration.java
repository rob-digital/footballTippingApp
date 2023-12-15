package rob.digital.footballtippingapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import rob.digital.footballtippingapp.model.Role;

import static rob.digital.footballtippingapp.model.Role.ADMIN;
import static rob.digital.footballtippingapp.model.Role.USER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .and()
                .authorizeHttpRequests()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/v1/user/**").hasRole(Role.USER.name())
                .requestMatchers("/api/v1/admin/**").hasAnyRole(ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

//
//        httpSecurity
//                .csrf()
//                .disable()
//                .authorizeHttpRequests(authConfig -> {
//                            authConfig.requestMatchers("/").permitAll();
//                            authConfig.requestMatchers("/api/v1/auth/**").permitAll();
//                            authConfig.requestMatchers("/api/v1/user/**").hasRole("USER");
//                            authConfig.requestMatchers("/api/v1/demo/**").hasRole("ADMIN");
//                            authConfig.anyRequest().authenticated();
//                })
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
////                .formLogin(Customizer.withDefaults()) // Login with browser and Build in Form
////                .httpBasic(Customizer.withDefaults()) // Login with Insomnia or Postman and Basic Auth
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();
    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authConfig -> {
//                    authConfig.requestMatchers(HttpMethod.GET, "/").permitAll();
//                    authConfig.requestMatchers(HttpMethod.GET, "/api/v1/user").hasRole("USER");
//                    authConfig.requestMatchers(HttpMethod.GET, "/api/v1/demo").hasRole("ADMIN");
//                    authConfig.anyRequest().authenticated();
//                })
//                .formLogin(Customizer.withDefaults()) // Login with browser and Build in Form
//                .httpBasic(Customizer.withDefaults()); // Login with Insomnia or Postman and Basic Auth
//        return http.build();
//    }
}
