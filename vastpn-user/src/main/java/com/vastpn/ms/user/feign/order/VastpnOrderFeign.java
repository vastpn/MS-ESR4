package com.vastpn.ms.user.feign.order;

import com.vastpn.ms.order.web.vo.HelloVO;
import com.vastpn.ms.user.feignfallback.order.OrderFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * <b>Feign 远程调用服务端.</b>
 * <b>Description:
 *      FeignClient(value = "vastpn-order" ,path = "order/t1",fallback = OrderFeignFallback.class)
 *          value= 微服务名称
 *          path=公共前缀
 *          fallback=降级回调配置
 * </b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/18 0018 16:41   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/18 0018 16:41          641597345@qq.com            new file.
 * <pre>
 */

@FeignClient(value = "vastpn-order" ,path = "order/t1"
        ,fallback = OrderFeignFallback.class //生产开启
)
public interface VastpnOrderFeign {

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    Object sayHello();

    @PostMapping(value = "/getResult")
    Object getResult(@RequestParam(name = "stringParam") String stringParam,
                     @RequestParam(name = "intParam") Integer intParam,
                     @RequestParam(name = "longParam") Long longParam);

    @PostMapping(value = "/getResultPost")
    Object getResultPost(@RequestParam(name = "stringParam") String stringParam,
                                @RequestParam(name = "intParam") Integer intParam,
                                @RequestParam(name = "longParam") Long longParam);
    @PostMapping(value = "/getResultPostJson")
    Object getResultPostJson(@RequestBody HelloVO helloVO);

    @PostMapping(value = "/getResultPostAnly")
    Object getResultPostAnly(@RequestParam("helloVO") HelloVO helloVO);

}
