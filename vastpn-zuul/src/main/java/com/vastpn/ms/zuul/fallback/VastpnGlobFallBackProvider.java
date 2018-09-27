package com.vastpn.ms.zuul.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * <pre>
 * <b>全局熔断器.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/27 0027 14:57   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/27 0027 14:57          641597345@qq.com            new file.
 * <pre>
 */

@Component
public class VastpnGlobFallBackProvider implements FallbackProvider {

    /**
     * <pre>
     * <b>对指定微服务降级.</b>
     * <b>Description:
     * 1、* 表示为所有微服务提供回退
     * 2、vastpn-user 代表对 spring.application.name 指定的微服务进行回退
     *  spring:
     *      application:
     *          name: vastpn-user
     * </b>
     *
     * <b>Author: 641597345@qq.com </b>
     * <b>Date: 2018/9/27 0027 14:58 </b>
     * @param
     * @return java.lang.String
     * <pre>
     */
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return this.response(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return this.fallbackResponse();
        }
    }
    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            /**
             * <pre>
             * <b>设置降级回退Body内容.</b>
             * <b>Description:</b>
             *
             * <b>Author: 641597345@qq.com </b>
             * <b>Date: 2018/9/27 0027 15:05 </b>
             * @param
             * @return java.io.InputStream
             * <pre>
             */
            @Override
            public InputStream getBody() throws IOException {

                return new ByteArrayInputStream("服务不可用，请稍后".getBytes());
            }
            /**
             * <pre>
             * <b>设置降级回退Header内容.</b>
             * <b>Description:</b>
             *
             * <b>Author: 641597345@qq.com </b>
             * <b>Date: 2018/9/27 0027 15:06 </b>
             * @param
             * @return org.springframework.http.HttpHeaders
             * <pre>
             */
            @Override
            public HttpHeaders getHeaders() {

                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
