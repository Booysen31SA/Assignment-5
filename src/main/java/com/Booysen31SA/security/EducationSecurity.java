package com.Booysen31SA.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EducationSecurity extends WebSecurityConfigurerAdapter {


    private static final String USER_ROLE = "USER";
    private static final String TEACHER_ROLE = "TEACHER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
            .inMemoryAuthentication()
                  .withUser("teacher").password(encoder().encode("password")).roles(TEACHER_ROLE)
            .and().withUser("HR").password(encoder().encode("password")).roles(USER_ROLE,TEACHER_ROLE)
            .and()
            .withUser("admin").password(encoder().encode("password")).roles(USER_ROLE, ADMIN_ROLE,TEACHER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/appointment/**/**").hasRole(ADMIN_ROLE)
                .antMatchers("/retirement/**/**").hasRole(TEACHER_ROLE)
                .antMatchers("/transfer/**/**").hasRole(TEACHER_ROLE)
                .antMatchers("/teacher/**/**").hasRole(USER_ROLE)
                .antMatchers("/").hasRole(TEACHER_ROLE)
                .antMatchers("/**").hasRole(ADMIN_ROLE)
                .antMatchers("/userRole").hasRole(TEACHER_ROLE)
        .and()
        .csrf().disable()
                ;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
