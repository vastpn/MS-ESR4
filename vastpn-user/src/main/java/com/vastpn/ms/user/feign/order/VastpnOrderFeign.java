package com.vastpn.ms.user.feign.order;

import com.vastpn.ms.order.web.vo.HelloVO;
import com.vastpn.ms.user.feignfallback.order.OrderFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
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

@FeignClient(value = "vastpn-order" ,fallback = OrderFeignFallback.class)
public interface VastpnOrderFeign {

    @RequestMapping(value = "order/t1/sayHello",method = RequestMethod.GET)
    Object sayHello();

    @PostMapping(value = "order/t1/getResult")
    Object getResult(@RequestParam(name = "stringParam") String stringParam,
                     @RequestParam(name = "intParam") Integer intParam,
                     @RequestParam(name = "longParam") Long longParam);

    @PostMapping(value = "order/t1/getResultPost")
    Object getResultPost(@RequestParam(name = "stringParam") String stringParam,
                                @RequestParam(name = "intParam") Integer intParam,
                                @RequestParam(name = "longParam") Long longParam);
    @PostMapping(value = "order/t1/getResultPostJson")
    Object getResultPostJson(@RequestBody HelloVO helloVO);

    @PostMapping(value = "order/t1/getResultPostAnly")
    Object getResultPostAnly(@RequestParam("helloVO") HelloVO helloVO);

}
