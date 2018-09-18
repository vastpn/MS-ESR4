package com.vastpn.ms.order.web.controller;

import com.vastpn.ms.order.web.vo.HelloVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(value = "/order/t1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {

    @Value("${info.test}")
    private String infoTest;

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
        Map<String,Object> result =new HashMap();
        result.put("context","无参API");
        result.put("time",new Date().getTime());
        result.put("remoteValue",infoTest);
        return result;
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

        Map<String,Object> result =new HashMap();
        result.put("context","注解方法：@ApiImplicitParams({@ApiImplicitParam})");
        result.put("time",new Date().getTime());
        result.put("remoteValue",infoTest);
        result.put("stringParam",stringParam);
        result.put("intParam",intParam);
        result.put("longParam",longParam);
        return result;
    }

    @ApiOperation(value = "注解参数：@RequestParam", notes = "注解参数：@RequestParam")
    @PostMapping(value = "/getResultPost")
    public Object getResultPost(@RequestParam String stringParam,@RequestParam Integer intParam,@RequestParam Long longParam){

        Map<String,Object> result =new HashMap();
        result.put("context","注解参数：@RequestParam");
        result.put("time",new Date().getTime());
        result.put("remoteValue",infoTest);
        result.put("stringParam",stringParam);
        result.put("intParam",intParam);
        result.put("longParam",longParam);
        return result;
    }

    @ApiOperation(value = "注解自定义对象参数：@RequestBody[JSON传参]", notes = "注解自定义对象参数：@RequestBody[JSON传参]")
    @PostMapping(value = "/getResultPostJson")
    public Object getResultPostJson(@RequestBody HelloVO helloVO){
        Map<String,Object> result =new HashMap();
        result.put("context","注解自定义对象参数：@RequestBody[JSON传参]");
        result.put("time",new Date().getTime());
        result.put("helloVO",helloVO);
        return result;
    }

    @ApiOperation(value = "自定义对象参数：Form", notes = "自定义对象参数：Form")
    @PostMapping(value = "/getResultPostAnly")
    public Object getResultPostAnly(HelloVO helloVO){
        Map<String,Object> result =new HashMap();
        result.put("context","自定义对象参数：Form");
        result.put("time",new Date().getTime());
        result.put("helloVO",helloVO);
        return result;
    }
}
