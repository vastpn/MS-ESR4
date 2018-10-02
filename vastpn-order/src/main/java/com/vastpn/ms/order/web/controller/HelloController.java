package com.vastpn.ms.order.web.controller;

import com.vastpn.ms.order.web.config.LocaleMessageSourceService;
import com.vastpn.ms.order.web.vo.DemoBean;
import com.vastpn.ms.order.web.vo.HelloVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @Resource
    private LocaleMessageSourceService localeMessageSourceService;

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
        DemoBean demoBean = new DemoBean();
        demoBean.setBigDecimal(new BigDecimal("22222222222.33333333333333333333359"));
        Map temp =new HashMap();
        temp.put("mapBigDecimal",new BigDecimal("44444444444444444444444444.5555555555555555555555788888000002"));
        demoBean.setaMap(temp);
        return demoBean;

//        Map<String,Object> result =new HashMap();
//
//        BigDecimal bigDecimal = new BigDecimal(11111111111111.111111111111111112);
//        result.put("aFields",null);
//        result.put("context","无参API");
//        result.put("bigDecimal",bigDecimal);
//        result.put("time",new Date().getTime());
//        result.put("remoteValue",infoTest);
//        result.put("user.password",localeMessageSourceService.getMessage("user.password"));
//        return result;
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

    /**
     * <pre>
     * <b>Feign调用，服务端的错误配置示例.</b>
     * <b>Description:
     *  该示例为错误的feign调用方法，因不能获取到参数，必须增加@RequestBody 注解；非feign调用能获取参数；
     * </b>
     *
     * <b>Author: 641597345@qq.com </b>
     * <b>Date: 2018/9/25 0025 11:46 </b>
     * @param helloVO
     * @return java.lang.Object
     * <pre>
     */
    @Deprecated
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
