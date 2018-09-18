package com.vastpn.ms.order.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/18 0018 09:20   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/18 0018 09:20          641597345@qq.com            new file.
 * <pre>
 */
@Api(value = "HelloController", tags = "OrderTest")
@RestController
@RequestMapping(value = "/order/t1")
public class HelloController {

    @Value("${info.test}")
    private String infoTest;

    @ApiOperation(value = "通讯测试", httpMethod = "GET", notes = "通讯测试")
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public Object sayHello(){
        Map<String,Object> result =new HashMap();
        result.put("time",new Date().getTime());
        result.put("remoteValue",infoTest);
        return result;
    }
}
