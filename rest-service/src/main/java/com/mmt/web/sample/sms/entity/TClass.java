package com.mmt.web.sample.sms.entity;

import com.mmt.common.model.RObj;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author mmt
 * @since 2019-06-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TClass对象", description = "学生表")
public class TClass extends RObj {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级名称")
    private String name;

}
