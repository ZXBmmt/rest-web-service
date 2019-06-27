package com.mmt.web.sample.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmt.client.form.ClassForm;
import com.mmt.client.vo.ClassVo;
import com.mmt.common.model.PageRestResponse;
import com.mmt.common.model.RestResponse;
import com.mmt.common.util.MyBeanCopier;
import com.mmt.web.sample.sms.entity.TClass;
import com.mmt.web.sample.sms.mapper.TClassMapper;
import com.mmt.web.sample.sms.service.ITClassService;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public RestResponse<Void> add( ClassForm classForm){
        TClass tClass = MyBeanCopier.copyAsObject(classForm,TClass.class);
        this.save(tClass);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<Void> update(Long id,ClassForm classForm){
        TClass history = this.getById(id);
        if(history == null){
            return RestResponse.buildNotFound();
        }
        history.setName(classForm.getName());
        this.updateById(history);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<ClassVo> get(Long id){
        TClass tClass = this.getById(id);
        if(tClass == null){
            return RestResponse.buildNotFound();
        }
        return RestResponse.buildSuccess(MyBeanCopier.copyAsObject(tClass,ClassVo.class));
    }

    public PageRestResponse<List<ClassVo>> query(Long currentPage,Long size,String nameKey){
        QueryWrapper<TClass> whereParam = new QueryWrapper<TClass>().like("name",nameKey).orderByDesc("id");
        IPage<TClass> classIPage = this.baseMapper.selectPage(new Page<>(currentPage, size),whereParam);
        List<ClassVo> vos = MyBeanCopier.copyAsList(classIPage.getRecords(),ClassVo.class);
        return PageRestResponse.buildSuccess(vos,classIPage.getTotal(),(int)classIPage.getCurrent(),(int)classIPage.getSize());
    }
}
