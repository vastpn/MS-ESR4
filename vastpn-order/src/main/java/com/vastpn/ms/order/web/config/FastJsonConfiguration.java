package com.vastpn.ms.order.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/10/1 0001 11:38   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/10/1 0001 11:38          641597345@qq.com            new file.
 * <pre>
 */

@Configuration
public class FastJsonConfiguration {

    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverter() {
        /**定义一个转换消息的对象*/
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        /**添加fastjson的配置信息 比如 ：是否要格式化返回的json数据*/
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                SerializerFeature.PrettyFormat,
                SerializerFeature.QuoteFieldNames,          //序列化输出字段，使用引号,默认为true
                SerializerFeature.WriteMapNullValue,        //空值是否输出,默认为false
                SerializerFeature.WriteEnumUsingToString,   //Enum
                SerializerFeature.WriteNullListAsEmpty,     //list字段如果为null，输出为[]
                SerializerFeature.WriteNullNumberAsZero,    //数值字段如果为null，输出为0
                SerializerFeature.WriteNullBooleanAsFalse,  //Boolean字段如果为null，输出为false
                SerializerFeature.WriteNullStringAsEmpty,   //字符类型字段如果为null，输出为""
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteBigDecimalAsPlain

        };

        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.QuoteFieldNames,          //序列化输出字段，使用引号,默认为true
//                SerializerFeature.WriteMapNullValue,        //空值是否输出,默认为false
//                SerializerFeature.WriteEnumUsingToString,   //Enum
//                SerializerFeature.WriteNullListAsEmpty,     //list字段如果为null，输出为[]
//                SerializerFeature.WriteNullNumberAsZero,    //数值字段如果为null，输出为0
//                SerializerFeature.WriteNullBooleanAsFalse,  //Boolean字段如果为null，输出为false
//                SerializerFeature.WriteNullStringAsEmpty,   //字符类型字段如果为null，输出为""
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteBigDecimalAsPlain
//        );


//        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON);

//        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XML);
//        supportedMediaTypes.add(MediaType.IMAGE_GIF);
//        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//        supportedMediaTypes.add(MediaType.IMAGE_PNG);
//        supportedMediaTypes.add(MediaType.MULTIPART_FORM_DATA);
//        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//        supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        supportedMediaTypes.add(MediaType.TEXT_XML);


        return new HttpMessageConverters(converter);
    }

}
