package com.mmt.web.sample.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmt.client.form.ClassForm;
import com.mmt.client.vo.ClassVo;
import com.mmt.common.model.RestResponse;
import com.mmt.common.util.MyBeanCopier;
import com.mmt.web.sample.sms.entity.TClass;
import com.mmt.web.sample.sms.mapper.TClassMapper;
import com.mmt.web.sample.sms.service.ITClassService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mmt
 * @since 2019-06-25
 */
@Service
public class TClassServiceImpl extends ServiceImpl<TClassMapper, TClass> implements ITClassService {


    public RestResponse<Void> add(@RequestBody ClassForm classForm){
        TClass tClass = MyBeanCopier.copyAsObject(classForm,TClass.class);
        this.save(tClass);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<Void> update(@PathVariable Long id, @RequestBody ClassForm classForm){
        TClass history = this.getById(id);
        if(history == null){
            return RestResponse.buildNotFound();
        }
        history.setName(classForm.getName());
        this.updateById(history);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<ClassVo> get(@PathVariable Long id){
        TClass tClass = this.getById(id);
        if(tClass == null){
            return RestResponse.buildNotFound();
        }
        return RestResponse.buildSuccess(MyBeanCopier.copyAsObject(tClass,ClassVo.class));
    }
}
