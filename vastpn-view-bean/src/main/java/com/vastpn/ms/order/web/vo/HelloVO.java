package com.vastpn.ms.order.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b>
 *
 * <b>Author: 641597345@qq.com </b>
 * <b>Date: 2018/9/18 0018 15:07   </b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver    Date                     Author                        Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018/9/18 0018 15:07          641597345@qq.com            new file.
 * <pre>
 */
@ApiModel("Hello视图对象")
public class HelloVO implements Serializable {

    @ApiModelProperty(value="字符串参数", hidden=false, required=true, dataType="String")
    private String stringParam;

    @ApiModelProperty(value="Integer参数(dataType设置为Long,Swagger的BUG)", hidden=false, required=true, dataType="Long")
    private Integer intParam;

    @ApiModelProperty(value="Long参数", hidden=false, required=true, dataType="Long")
    private Long longParam;

    public String getStringParam() {
        return stringParam;
    }

    public void setStringParam(String stringParam) {
        this.stringParam = stringParam;
    }

    public Integer getIntParam() {
        return intParam;
    }

    public void setIntParam(Integer intParam) {
        this.intParam = intParam;
    }

    public Long getLongParam() {
        return longParam;
    }

    public void setLongParam(Long longParam) {
        this.longParam = longParam;
    }
}
