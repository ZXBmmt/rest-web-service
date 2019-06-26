package com.mmt.web.sample.sms.service.impl;

import com.mmt.common.model.RestResponse;
import com.mmt.web.sample.sms.entity.TJsonTest;
import com.mmt.web.sample.sms.mapper.TJsonTestMapper;
import com.mmt.web.sample.sms.service.ITJsonTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * json字段测试 服务实现类
 * </p>
 *
 * @author mmt
 * @since 2019-06-26
 */
@Service
public class TJsonTestServiceImpl extends ServiceImpl<TJsonTestMapper, TJsonTest> implements ITJsonTestService {
    public RestResponse<Void> insert(TJsonTest jsonTest){
        baseMapper.insert(jsonTest);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<TJsonTest> get(Long id){
        TJsonTest jsonTest = baseMapper.get(id);
        if(jsonTest == null){
            return RestResponse.buildNotFound();
        }
        return RestResponse.buildSuccess(jsonTest);
    }
}
