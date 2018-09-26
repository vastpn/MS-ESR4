//package com.vastpn.ms.admin.config;
//
//import com.hazelcast.config.Config;
//import com.hazelcast.config.EvictionPolicy;
//import com.hazelcast.config.ListConfig;
//import com.hazelcast.config.MapConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * <pre>
// * <b>.</b>
// * <b>Description:</b>
// *
// * <b>Author: 641597345@qq.com </b>
// * <b>Date: 2018/9/8 0008 11:14   </b>
// * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
// * <b>Changelog:</b>
// *   ----------------------------------------------------------------------------
// *   Ver    Date                     Author                        Detail
// *   ----------------------------------------------------------------------------
// *   1.0   2018/9/8 0008 11:14          641597345@qq.com            new file.
// * <pre>
// */
//
//@Configuration
//public class HazelcastConfiguration {
//    @Bean
//    public Config hazelcastConfig() {
//        return new Config().setProperty("hazelcast.jmx", "true")
//                .addMapConfig(new MapConfig("spring-boot-admin-application-store").setBackupCount(1)
//                        .setEvictionPolicy(EvictionPolicy.NONE))
//                .addListConfig(new ListConfig("spring-boot-admin-event-store").setBackupCount(1)
//                        .setMaxSize(1000));
//    }
//}
