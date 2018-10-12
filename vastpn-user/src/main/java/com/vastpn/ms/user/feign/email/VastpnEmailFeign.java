package com.vastpn.ms.user.feign.email;

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
 *
 *      注意：
 *          1、FeignClient 尽量使用  name或者value  ,不建议使用serviceId（版本已废弃）；
 *          2、FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 *              示例：  @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
 *                      public User findById(@PathVariable("id") Long id);
 *          3、尽量用@RequestMapping ，不建议直接使用 @GetMapping、@PostMapping
 *          4、Get请求时，多个参数传递正确方法
 *               正确示例：  @RequestMapping(value = "/query-by", method = RequestMethod.GET)
 *                           public User queryBy(@RequestParam("id")Long id, @RequestParam("username")String username);
 *                   或者：  @RequestMapping(value = "/query-by", method = RequestMethod.GET)
 *                           public List<User> queryBy(@RequestParam Map<String, Object> param);
 *
 *               错误示例：  @RequestMapping(value = "/query-by", method = RequestMethod.GET)
 *                           public User queryBy(User user);
 *
 *           5、feign可以使用占位符，服务名称、地址等信息可以配置在yml或者properties文件中：
 *                   示例：  @FeignClient(name = "${feign.name}", url = "${feign.url}")
 *
 *
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

@FeignClient(value = "vastpn-email" ,path = "${vastpn-email.feign.path}"
//        ,fallback = EmailFeignFallback.class //生产开启
)
public interface VastpnEmailFeign {

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    Object send();


}
