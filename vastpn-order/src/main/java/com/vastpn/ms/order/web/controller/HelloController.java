package com.vastpn.ms.order.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
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

@RestController
@RequestMapping(value = "/order/t1")
public class HelloController {

    @RequestMapping("/sayHello")
    public Object sayHello(){
        Map<String,Object> result =new HashMap();
        result.put("time",new Date().getTime());
        return result;
    }
}
