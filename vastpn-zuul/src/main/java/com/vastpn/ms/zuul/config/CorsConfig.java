package com.vastpn.ms.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <pre>
 * <b>网关跨域设置.</b>
 * <b>Description:
 * 正常情况下，跨域是这样的：
 * 1. 微服务配置跨域+zuul不配置=有跨域问题
 * 2. 微服务配置+zuul配置=有跨域问题
 * 3. 微服务不配置+zuul不配置=有跨域问题
 * 4. 微服务不配置+zuul配置=ok</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/6 0006 11:01   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/6 0006 11:01          641597345@qq.com            new file.
 * <pre>
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);                   // 允许cookies跨域
        config.addAllowedOrigin("*");                       // #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        config.addAllowedHeader("*");                       // #允许访问的头信息,*表示全部
        config.setMaxAge(18000L);                           // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
//        config.addAllowedMethod("*");                     // 允许提交请求的方法，*表示全部允许
        config.addAllowedMethod("GET");                     // 允许提交请求的GET方法
        config.addAllowedMethod("POST");                    // 允许提交请求的POST方法
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
