package com.devops.eventmanagement;

import com.devops.eventmanagement.util.LoginSuccesMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LoginSuccesMessage loginSuccesMessage;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT u.username, r.rol FROM roles r INNER JOIN users u ON r.user_id=u.id WHERE u.username = ?");
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/index").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/images/**").permitAll()
                        .requestMatchers("/views/clientes/").hasAnyRole("USER")
                        .requestMatchers("/views/clientes/create").hasAnyRole("ADMIN")
                        .requestMatchers("/views/clientes/save").hasAnyRole("ADMIN")
                        .requestMatchers("/views/clientes/edit/**").hasAnyRole("ADMIN")
                        .requestMatchers("/views/clientes/delete/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login").successHandler(loginSuccesMessage)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}