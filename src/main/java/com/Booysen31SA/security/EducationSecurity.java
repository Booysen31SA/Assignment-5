package com.Booysen31SA.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

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
             .csrf().disable()
                .authorizeRequests()
                .antMatchers("/appointment/**/**").hasRole(TEACHER_ROLE)
                .antMatchers("/retirement/**/**").hasRole(TEACHER_ROLE)
                .antMatchers("/school/**/**").hasRole(TEACHER_ROLE)
                .antMatchers("/teacher/**/**").hasRole(USER_ROLE)
                .antMatchers("/").hasRole(TEACHER_ROLE)
                .antMatchers("/**").hasRole(ADMIN_ROLE)
                .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .defaultSuccessUrl("/", true)
                     .and()
                .logout()
                  .permitAll()
                  .deleteCookies("JSESSIONID")
                ;

//        http.httpBasic().and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/**").hasRole(ADMIN_ROLE)
//                .and()
//                .csrf();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
