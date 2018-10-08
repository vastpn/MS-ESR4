package com.vastpn.ms.order.web.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/10/8 0008 10:59   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/10/8 0008 10:59          641597345@qq.com            new file.
 * <pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseController {



    @LocalServerPort
    public int port;

    public URL base;

    @Autowired
    public TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format(TestConstant.CURRENT_SERVER_URL_PREFIX, port);
        System.out.println(String.format("当前服务前缀地址: [%S]", url));
        this.base = new URL(url);
    }
}
