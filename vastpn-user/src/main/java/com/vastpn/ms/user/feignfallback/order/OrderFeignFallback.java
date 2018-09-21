package com.vastpn.ms.user.feignfallback.order;

import com.vastpn.ms.order.web.vo.HelloVO;
import com.vastpn.ms.user.feign.order.VastpnOrderFeign;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/21 0021 09:46   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/21 0021 09:46          641597345@qq.com            new file.
 * <pre>
 */
@Component
public class OrderFeignFallback implements VastpnOrderFeign {
    @Override
    public Object sayHello() {
        Map<String,Object> fall = new HashMap<>();
        fall.put("error","Fallback-sayHello");
        return fall;
    }

    @Override
    public Object getResult(String stringParam, Integer intParam, Long longParam) {
        return "Fallback-getResult";
    }

    @Override
    public Object getResultPost(String stringParam, Integer intParam, Long longParam) {
        return "Fallback-getResultPost";
    }

    @Override
    public Object getResultPostJson(HelloVO helloVO) {
        return "Fallback-getResultPostJson";
    }

    @Override
    public Object getResultPostAnly(HelloVO helloVO) {
        return "Fallback-getResultPostAnly";
    }
}
