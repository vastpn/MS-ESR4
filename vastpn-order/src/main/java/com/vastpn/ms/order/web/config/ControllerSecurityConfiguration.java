package com.vastpn.ms.order.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/10/9 0009 14:44   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/10/9 0009 14:44          641597345@qq.com            new file.
 * <pre>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class ControllerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${security.user.name}")
    private String username;
    @Value("${security.user.password}")
    private String password;

    private final static String SECURITY_ROLE_ACTUATOR ="ACTUATOR";
    private final static String SECURITY_ROLE_ADMIN ="ADMIN";



    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略css.jq.img等文件
        web.ignoring().antMatchers("/**.html","/**.css", "/img/**", "/**.js","/third-party/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(User.withUsername(username).password(password).roles(SECURITY_ROLE_ACTUATOR,SECURITY_ROLE_ADMIN).build());

        http
                .csrf().disable() //HTTP with Disable CSRF
                .authorizeRequests() //Authorize Request Configuration
                .antMatchers( "/login",
                        "/api/**",
                        "/order/**",
                        "/**/heapdump",
                        "/**/loggers",
                        "/**/liquibase",
                        "/**/logfile",
                        "/**/flyway",
                        "/**/auditevents",
                        "/**/jolokia").permitAll() //放开"/api/**"：为了给被监控端免登录注册并解决Log与Logger冲突
                .and()
                .authorizeRequests()
                .antMatchers("/**").hasRole(SECURITY_ROLE_ACTUATOR)
                .antMatchers("/**/**").authenticated()
                .and() //Login Form configuration for all others
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login").permitAll()
                .defaultSuccessUrl("/")
                .and() //Logout Form configuration
                .logout()
                .deleteCookies("remove")
                .logoutSuccessUrl("/login.html").permitAll()
                .and()
                .httpBasic()
                .and()
                .userDetailsService(inMemoryUserDetailsManager);
    }
}