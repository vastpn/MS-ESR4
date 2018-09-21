package com.vastpn.ms.user.web;

import com.vastpn.ms.order.web.vo.HelloVO;
import com.vastpn.ms.user.feign.order.VastpnOrderFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/18 0018 17:28   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/18 0018 17:28          641597345@qq.com            new file.
 * <pre>
 */
@Api(value = "FeignOrderController", tags = "FeignOrderTest")
@RestController
@RequestMapping(value = "/user/t1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FeignOrderController {

    @Autowired
    private VastpnOrderFeign vastpnOrderFeign;

    /**
     * <pre>
     * <b>无参数API.</b>
     * <b>Description:</b>
     *
     * <b>Author: 641597345@qq.com </b>
     * <b>Date: 2018/9/18 0018 14:53 </b>
     * @return
     * <pre>
     */
    @ApiOperation(value = "通讯测试", httpMethod = "GET", notes = "通讯测试")
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public Object sayHello(){
        return this.vastpnOrderFeign.sayHello();
    }

    /**
     * <pre>
     * <b>普通参数API.</b>
     * <b>Description:swagger传递form表单</b>
     *
     * <b>Author: 641597345@qq.com </b>
     * <b>Date: 2018/9/18 0018 14:54 </b>
     * @param stringParam
     * @param intParam
     * @param longParam
     * @return java.lang.Object
     * <pre>
     */
    @ApiOperation(value = "注解方法：@ApiImplicitParams({@ApiImplicitParam})", notes = "注解方法：@ApiImplicitParams({@ApiImplicitParam})")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stringParam", value = "stringParam", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "intParam", value = "intParam", required = true, dataType = "Long", paramType = "form"),
            @ApiImplicitParam(name = "longParam", value = "longParam", required = true, dataType = "Long", paramType = "form")
    })
    @PostMapping(value = "/getResult")
    public Object getResult(String stringParam,Integer intParam,Long longParam){

        return this.vastpnOrderFeign.getResult(stringParam,intParam,longParam);
    }

    @ApiOperation(value = "注解参数：@RequestParam", notes = "注解参数：@RequestParam")
    @PostMapping(value = "/getResultPost")
    public Object getResultPost(@RequestParam String stringParam,@RequestParam Integer intParam,@RequestParam Long longParam){

        return this.vastpnOrderFeign.getResultPost(stringParam,intParam,longParam);
    }

    @ApiOperation(value = "注解自定义对象参数：@RequestBody[JSON传参]", notes = "注解自定义对象参数：@RequestBody[JSON传参]")
    @PostMapping(value = "/getResultPostJson")
    public Object getResultPostJson(@RequestBody HelloVO helloVO){
        return this.vastpnOrderFeign.getResultPostJson(helloVO);
    }

    @ApiOperation(value = "自定义对象参数：Form", notes = "自定义对象参数：Form")
    @PostMapping(value = "/getResultPostAnly")
    public Object getResultPostAnly(HelloVO helloVO){
        return this.vastpnOrderFeign.getResultPostAnly(helloVO);
    }
}
