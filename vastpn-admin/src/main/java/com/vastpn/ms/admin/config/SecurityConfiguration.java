//package com.vastpn.ms.admin.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * <pre>
// * <b>.</b>
// * <b>Description:</b>
// *
// * <b>Author: 641597345@qq.com </b>
// * <b>Date: 2018/9/8 0008 11:32   </b>
// * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
// * <b>Changelog:</b>
// *   ----------------------------------------------------------------------------
// *   Ver    Date                     Author                        Detail
// *   ----------------------------------------------------------------------------
// *   1.0   2018/9/8 0008 11:32          641597345@qq.com            new file.
// * <pre>
// */
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Page with login form is served as /login.html and does a POST on /login
//        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
//        // The UI does a POST on /logout on logout
//        http.logout().logoutUrl("/logout");
//        // The ui currently doesn't support csrf
//        http.csrf().disable();
//
//        // Requests for the login page and the static assets are allowed
//        http.authorizeRequests()
//                .antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**")
//                .permitAll();
//        // ... and any other request needs to be authorized
//        http.authorizeRequests().antMatchers("/**").authenticated();
//
//        // Enable so that the clients can authenticate via HTTP basic for registering
//        http.httpBasic();
//    }
//}
