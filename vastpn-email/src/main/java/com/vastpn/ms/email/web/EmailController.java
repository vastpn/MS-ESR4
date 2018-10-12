package com.vastpn.ms.email.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/10/12 0012 15:54   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/10/12 0012 15:54          641597345@qq.com            new file.
 * <pre>
 */
@Api(value = "EmailController", tags = "EmailControllerTest")
@RestController
@RequestMapping(value = "/email/t1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {
    @ApiOperation(value = "通讯测试", httpMethod = "GET", notes = "通讯测试")
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public Object send(){
        Map result =new HashMap<>();
        result.put("email","context");
        result.put("send","success");
        return result;
    }
}
