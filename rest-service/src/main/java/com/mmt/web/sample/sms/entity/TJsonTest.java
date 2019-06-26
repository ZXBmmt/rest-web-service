package com.mmt.web.sample.sms.entity;

import com.mmt.common.model.RObj;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * json字段测试
 * </p>
 *
 * @author mmt
 * @since 2019-06-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TJsonTest对象", description = "json字段测试")
public class TJsonTest extends RObj {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "json数据")
    private JsonContent jsonContent;

    @Data
    public static class JsonContent{
        private String key;
        private String value;
    }
}
