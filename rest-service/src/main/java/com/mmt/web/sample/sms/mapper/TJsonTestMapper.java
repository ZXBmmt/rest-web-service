package com.mmt.web.sample.sms.mapper;

import com.mmt.web.sample.sms.entity.TJsonTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * json字段测试 Mapper 接口
 * </p>
 *
 * @author mmt
 * @since 2019-06-26
 */
public interface TJsonTestMapper extends BaseMapper<TJsonTest> {

    public int insert(TJsonTest jsonTest);

    public TJsonTest get(Long id);
}
